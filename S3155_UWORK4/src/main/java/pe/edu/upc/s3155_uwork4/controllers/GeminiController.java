package pe.edu.upc.s3155_uwork4.controllers;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upc.s3155_uwork4.dtos.PromptDTO;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.GeminiServiceInterface;

import java.io.IOException;


@RestController
@RequestMapping("/chat")
public class GeminiController {

    @Autowired
    private GeminiServiceInterface geminiService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Chat IA Backend funcionando");
    }

    @PostMapping("/text")
    public ResponseEntity<String> chatTexto(@RequestBody PromptDTO prompt) {
        String respuesta = geminiService.llamarAGemini(prompt.getPrompt());
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping({"/image", "/audio", "/video"})
    public ResponseEntity<String> chatWithMultimodalFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("prompt") String prompt) {
        try {
            byte[] contenido = file.getBytes();
            String mimeType = file.getContentType();

            String respuesta = geminiService.llamarAGeminiConArchivo(contenido, mimeType, prompt);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al procesar el archivo: " + e.getMessage());
        }
    }
    @PostMapping("/file")
    public ResponseEntity<String> chatConDocumento(
            @RequestParam("file") MultipartFile file,
            @RequestParam("prompt") String prompt) {
        try {
            String extractedText = null;
            String nombreArchivo = file.getOriginalFilename();
            String mimeType = file.getContentType();

            if (nombreArchivo == null) {
                return ResponseEntity.badRequest().body("Nombre de archivo no válido.");
            }

            String lowerCaseFileName = nombreArchivo.toLowerCase();

            if (lowerCaseFileName.endsWith(".pdf")) {
                try (PDDocument document = PDDocument.load(file.getInputStream())) {
                    PDFTextStripper stripper = new PDFTextStripper();
                    extractedText = stripper.getText(document);
                }
            } else if (lowerCaseFileName.endsWith(".docx")) {
                try (XWPFDocument doc = new XWPFDocument(file.getInputStream())) {
                    XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
                    extractedText = extractor.getText();
                }
            } else if (lowerCaseFileName.endsWith(".xlsx")) {
                try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                        workbook.getSheetAt(i).forEach(row -> {
                            row.forEach(cell -> sb.append(cell.toString()).append(" "));
                            sb.append("\n");
                        });
                    }
                    extractedText = sb.toString();
                }
            } else if (lowerCaseFileName.endsWith(".pptx")) {
                try (XMLSlideShow ppt = new XMLSlideShow(file.getInputStream())) {
                    StringBuilder sb = new StringBuilder();
                    ppt.getSlides().forEach(slide -> {
                        slide.getShapes().forEach(shape -> {
                            if (shape instanceof XSLFTextShape) {
                                sb.append(((XSLFTextShape) shape).getText()).append(" ");
                            }
                        });
                        sb.append("\n---\n");
                    });
                    extractedText = sb.toString();
                }
            } else if (lowerCaseFileName.endsWith(".txt") || mimeType.startsWith("text/")) {
                extractedText = new String(file.getBytes());
            }

            String respuesta;
            if (extractedText != null && !extractedText.trim().isEmpty()) {
                String combinedPrompt = "Analiza el siguiente texto extraído de un documento:\n\n" + extractedText + "\n\n" + "Pregunta relacionada: " + prompt;
                respuesta = geminiService.llamarAGemini(combinedPrompt);
            } else {
                respuesta = geminiService.llamarAGeminiConArchivo(file.getBytes(), mimeType, prompt);
            }

            return ResponseEntity.ok(respuesta);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error de I/O al procesar el archivo: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error inesperado al procesar el archivo: " + e.getMessage());
        }
    }
}
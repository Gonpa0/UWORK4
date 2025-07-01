package pe.edu.upc.s3155_uwork4.controllers;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upc.s3155_uwork4.dtos.PromptDTO;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.GeminiServiceInterface;


@RestController
@RequestMapping("/chat")
public class GeminiController {

    @Autowired
    private GeminiServiceInterface geminiService;

    // Verificación básica
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Chat IA Backend funcionando");
    }

    // POST de texto → Gemini
    @PostMapping("/text")
    public ResponseEntity<String> chatTexto(@RequestBody PromptDTO prompt) {
        String respuesta = geminiService.llamarAGemini(prompt.getPrompt());
        return ResponseEntity.ok(respuesta);
    }

    // POST para imagen (multimodal)
    @PostMapping("/image")
    public ResponseEntity<String> chatConImagen(
            @RequestParam("file") MultipartFile file,
            @RequestParam("prompt") String prompt) {
        try {
            byte[] contenido = file.getBytes();
            String mimeType = file.getContentType();

            String respuesta = geminiService.llamarAGeminiConArchivo(contenido, mimeType, prompt);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al procesar la imagen: " + e.getMessage());
        }
    }

    // POST para audio
    @PostMapping("/audio")
    public ResponseEntity<String> chatConAudio(
            @RequestParam("file") MultipartFile file,
            @RequestParam("prompt") String prompt) {
        try {
            byte[] contenido = file.getBytes();
            String mimeType = file.getContentType();

            String respuesta = geminiService.llamarAGeminiConArchivo(contenido, mimeType, prompt);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al procesar el audio: " + e.getMessage());
        }
    }

    // POST para video
    @PostMapping("/video")
    public ResponseEntity<String> chatConVideo(
            @RequestParam("file") MultipartFile file,
            @RequestParam("prompt") String prompt) {
        try {
            byte[] contenido = file.getBytes();
            String mimeType = file.getContentType();

            String respuesta = geminiService.llamarAGeminiConArchivo(contenido, mimeType, prompt);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al procesar el video: " + e.getMessage());
        }
    }

    // POST para documentos
    @PostMapping("/file")
    public ResponseEntity<String> chatConArchivo(@RequestParam("file") MultipartFile file) {
        try {
            String contenido = "";
            String nombreArchivo = file.getOriginalFilename();

            if (nombreArchivo == null) {
                return ResponseEntity.badRequest().body("Nombre de archivo no válido.");
            }

            if (nombreArchivo.endsWith(".pdf")) {
                try (PDDocument document = PDDocument.load(file.getInputStream())) {
                    PDFTextStripper stripper = new PDFTextStripper();
                    contenido = stripper.getText(document);
                }
            } else if (nombreArchivo.endsWith(".docx")) {
                try (XWPFDocument doc = new XWPFDocument(file.getInputStream())) {
                    XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
                    contenido = extractor.getText();
                }
            } else {
                // .txt o cualquier otro archivo tratado como texto plano
                contenido = new String(file.getBytes());
            }

            // Llamada a Gemini con el texto extraído
            String respuesta = geminiService.llamarAGemini(contenido);
            return ResponseEntity.ok(respuesta);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
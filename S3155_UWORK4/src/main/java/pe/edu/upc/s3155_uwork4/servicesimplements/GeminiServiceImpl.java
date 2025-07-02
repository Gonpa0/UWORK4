package pe.edu.upc.s3155_uwork4.servicesimplements;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.GeminiConfig;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.GeminiServiceInterface;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class GeminiServiceImpl implements GeminiServiceInterface {

    private final WebClient webClient = WebClient.create();

    @Autowired
    private GeminiConfig geminiConfig;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String llamarAGemini(String prompt) {
        String apiKey = geminiConfig.getApiKey();

        String url = "https://generativelanguage.googleapis.com/v1/models/gemini-2.5-pro:generateContent?key=" + apiKey;

        String body = """
        {
          "contents": [{
            "parts": [{
              "text": "%s"
            }]
          }]
        }
        """.formatted(prompt);

        String response = webClient.post()
                .uri(url)
                .header("Content-Type", "application/json")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            return root
                    .path("candidates").get(0)
                    .path("content")
                    .path("parts").get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            return "Error al procesar la respuesta de Gemini";
        }
    }
    @Override
    public String llamarAGeminiConArchivo(byte[] archivo, String mimeType, String prompt) {
        try {
            String apiKey = geminiConfig.getApiKey();
            String url = "https://generativelanguage.googleapis.com/v1/models/gemini-2.5-pro:generateContent?key=" + apiKey;

            String base64Data = Base64.getEncoder().encodeToString(archivo);

            // Crear JSON
            Map<String, Object> inlineData = new HashMap<>();
            inlineData.put("mime_type", mimeType);
            inlineData.put("data", base64Data);

            Map<String, Object> partText = new HashMap<>();
            partText.put("text", prompt);

            Map<String, Object> partFile = new HashMap<>();
            partFile.put("inline_data", inlineData);

            Map<String, Object> content = new HashMap<>();
            content.put("parts", List.of(partText, partFile));

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("contents", List.of(content));

            String body = objectMapper.writeValueAsString(requestBody);

            String response = webClient.post()
                    .uri(url)
                    .header("Content-Type", "application/json")
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            JsonNode root = objectMapper.readTree(response);
            return root
                    .path("candidates").get(0)
                    .path("content")
                    .path("parts").get(0)
                    .path("text")
                    .asText();

        } catch (Exception e) {
            e.printStackTrace(); // Para depuración
            return "Error al procesar archivo con Gemini";
        }
    }
}
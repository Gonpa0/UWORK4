package pe.edu.upc.s3155_uwork4.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GeminiConfig {
    @Value("${gemini.api.key}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
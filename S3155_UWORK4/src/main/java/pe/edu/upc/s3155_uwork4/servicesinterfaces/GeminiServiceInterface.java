package pe.edu.upc.s3155_uwork4.servicesinterfaces;

public interface GeminiServiceInterface {
    String llamarAGemini(String prompt);
    String llamarAGeminiConArchivo(byte[] archivo, String mimeType, String prompt);
}
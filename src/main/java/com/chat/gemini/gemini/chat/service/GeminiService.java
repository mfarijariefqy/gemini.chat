package com.chat.gemini.gemini.chat.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;
    @Value("${gemini.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getChatResponse(String prompt){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Membangun struktur body JSON yang kompleks menggunakan Map dan List
            {Map<String, Object> part = Map.of("text", prompt);
            Map<String, Object> content = Map.of("parts", List.of(part));
            Map<String, Object> requestBody = Map.of("contents", List.of(content));

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

            String finalUrl = apiUrl + "?key=" + apiKey;

            try {
                // Mengirim permintaan dan mendapatkan respons sebagai Map
                Map<String, Object> response = restTemplate.postForObject(finalUrl, entity, Map.class);

                // Navigasi melalui struktur JSON respons untuk mendapatkan teks
                if (response != null && response.containsKey("candidates")) {
                    List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.get("candidates");
                    if (!candidates.isEmpty()) {
                        Map<String, Object> candidate = candidates.get(0);
                        Map<String, Object> contentMap = (Map<String, Object>) candidate.get("content");
                        List<Map<String, Object>> parts = (List<Map<String, Object>>) contentMap.get("parts");
                        if (!parts.isEmpty()) {
                            return (String) parts.get(0).get("text");
                        }
                    }
                }
                return "Maaf, saya tidak bisa memproses permintaan Anda saat ini.";

            } catch (Exception e) {
                // Log error
                System.err.println("Error calling Gemini API: " + e.getMessage());
                // Cetak URL 
                System.err.println("Attempted to call URL: " + finalUrl);
                return "Terjadi kesalahan saat menghubungi AI. Silakan coba lagi nanti.";
            }
        }
    }
}

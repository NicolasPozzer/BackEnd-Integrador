package com.portfolio.nico.tools;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TareaProgramada {

    private final RestTemplate restTemplate;

    public TareaProgramada(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedRate = 1440000) // 15000 milisegundos = 15 segundos - 1440000 = 24min
    public void realizarPeticionGET() {
        String url = "https://project-nico.onrender.com"; // URL de tu propia aplicación
        String respuesta = restTemplate.getForObject(url, String.class);
        // Puedes manejar la respuesta si es necesario
        System.out.println("Respuesta de la petición GET: " + respuesta);
    }
}

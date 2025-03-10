package fr.univtln.lezozzz.samples.imagery;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;


public class ImageryApp {
    public static void main(String[] args) {
        // 1. Client - Point d'entrée principal
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        // 2. WebTarget - Représente une ressource REST
        WebTarget target = client.target("https://api.nasa.gov/")
                .path("resources")
                .path("{id}");

        // 3. Response - Contient la réponse HTTP
        Response response = target.request(MediaType.APPLICATION_JSON).get();
    }

}

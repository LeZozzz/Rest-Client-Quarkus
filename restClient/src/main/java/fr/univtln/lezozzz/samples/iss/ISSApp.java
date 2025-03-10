package fr.univtln.lezozzz.samples.iss;

import fr.univtln.lezozzz.samples.iss.body.Body;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;

public class ISSApp {
    public static void main(String[] args) {
        // 1. Client - Point d'entrée principal
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        // 2. WebTarget - Représente une ressource REST
        WebTarget target = client.target("http://api.open-notify.org/iss-now.json");

        // 3. Response - Contient la réponse HTTP
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        // 4. Vérification et parsing de la réponse
        if (response.getStatus() == 200) {
            Body body = response.readEntity(Body.class);
            System.out.println("ISS Current Location:");
            System.out.println("Message: " + body.getMessage());
            System.out.println("Timestamp: " + body.getTimestamp());
            System.out.println("Latitude: " + body.getIssPosition().getLatitude());
            System.out.println("Longitude: " + body.getIssPosition().getLongitude());
        } else {
            System.out.println("Error: " + response.getStatus());
        }

        // 5. Fermeture du client
        response.close();
        client.close();
    }
}
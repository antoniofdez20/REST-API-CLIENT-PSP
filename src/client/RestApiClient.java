package client;

import models.Videogame;
import org.json.JSONObject;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class RestApiClient
{
    private final String BASE_URL = "http://localhost:8080/api/videojocs";
    private HttpClient client;

    public RestApiClient()
    {
        this.client = HttpClient.newHttpClient();
    }

    public void listAllVideogames() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .build();

        sendRequest(request);
    }

    public void listVideogamesByID(String id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .build();

        sendRequest(request);
    }

    public void listVideogamesByCompany(String company) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/filtrarEmpresa/" + URLEncoder.encode(company, StandardCharsets.UTF_8)))
                .build();

        sendRequest(request);
    }

    public void createVideogame(Videogame videogame) {
        JSONObject json = new JSONObject();
        json.put("ID", videogame.getId());
        json.put("TITOL", videogame.getTitle());
        json.put("ANY", videogame.getYear());
        json.put("MODALITAT", videogame.getModality());
        json.put("EMPRESA", videogame.getCompany());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/create"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        sendRequest(request);
    }

    public void updateVideogame(Videogame videogame) {
        JSONObject json = new JSONObject();
        json.put("ID", videogame.getId());
        json.put("TITOL", videogame.getTitle());
        json.put("ANY", videogame.getYear());
        json.put("MODALITAT", videogame.getModality());
        json.put("EMPRESA", videogame.getCompany());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/update/" + videogame.getId()))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        sendRequest(request);
    }


    public void deleteVideogameByID(String id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/delete/" + id))
                .DELETE()
                .build();

        sendRequest(request);
    }

    private void sendRequest(HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (Exception e) {
            System.out.println("Error al realizar la solicitud: " + e.getMessage());
        }
    }
}

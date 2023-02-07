package io.github.raphaelrighetti.filmes.services.imdb;

import io.github.raphaelrighetti.filmes.interfaces.APIClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbSeriesAPIClient implements APIClient {

    private final String apiKey;

    public ImdbSeriesAPIClient(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String getBody() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250TVs/" + apiKey))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    @Override
    public String type() {
        return "Série";
    }
}

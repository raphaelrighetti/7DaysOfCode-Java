package io.github.raphaelrighetti.filmes.services.marvel;

import io.github.raphaelrighetti.filmes.interfaces.APIClient;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarvelQuadrinhosAPIClient implements APIClient {

    private final String pvKey;
    private final String pubKey;

    public MarvelQuadrinhosAPIClient(String pvKey, String pubKey) {
        this.pvKey = pvKey;
        this.pubKey = pubKey;
    }

    @Override
    public String getBody() throws IOException, InterruptedException {
        long ts = System.currentTimeMillis();
        String hash = DigestUtils.md5Hex(ts + pvKey + pubKey);

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://gateway.marvel.com/v1/public/comics?ts="+ ts +"&apikey=" + pubKey + "&hash=" + hash))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    @Override
    public String type() {
        return "Quadrinho";
    }
}

package io.github.raphaelrighetti.filmes.services;

import io.github.raphaelrighetti.filmes.modelos.Filme;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

    private static String html = """
            <!DOCTYPE html>
            <html lang="pt-br">
            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
                <title>Filmes Show</title>
            </head>
            <body>
                <main class="d-flex justify-content-around flex-wrap">
                    %s
                </main>
            </body>
            </html>
            """;

    public static void generate(List<Filme> filmes) {
        StringBuilder cards = new StringBuilder();
        String card = """
                    <div class="card text-white bg-dark mb-3" style="width: 18rem;">
                        <h5 class="card-title">%s</h5>
                        <div class="card-body">
                            <img src="%s" class="card-img-top" alt="%s">
                            <p class="card-text mt-2">Ano: %s - Nota: %s</p>
                            <p class="card-text">Rank: %s</p>
                        </div>
                    </div>
                """;

        filmes.forEach(item -> {
            cards.append(String.format(card, item.getNome(), item.getImagemUrl(), item.getNome(), item.getAno(), item.getNota(), item.getRank()));
        });

        try (PrintWriter pw = new PrintWriter("index.html")) {
            pw.write(String.format(html, cards));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

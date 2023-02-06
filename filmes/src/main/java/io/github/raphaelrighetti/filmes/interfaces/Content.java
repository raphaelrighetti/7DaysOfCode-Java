package io.github.raphaelrighetti.filmes.interfaces;

import java.time.Year;

public interface Content {

    String getNome();

    String getImagemUrl();

    Year getAno();

    double getNota();

    int getRank();
}

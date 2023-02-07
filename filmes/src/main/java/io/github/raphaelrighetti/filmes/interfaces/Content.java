package io.github.raphaelrighetti.filmes.interfaces;

import java.time.Year;

public interface Content extends Comparable<Content> {

    String getNome();

    String getImagemUrl();

    Year getAno();

    double getNota();

    int getRank();

    String type();
}

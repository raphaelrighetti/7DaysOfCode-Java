package io.github.raphaelrighetti.filmes.modelos;

import java.time.Year;

public class Filme {

    private final String nome;
    private final String urlImage;
    private final Year year;
    private final int rank;

    public Filme(String nome, String urlImage, String year, String rank) {
        this.nome = nome;
        this.urlImage = urlImage;
        this.year = Year.parse(year);
        this.rank = Integer.parseInt(rank);
    }

    public String getNome() {
        return nome;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public Year getYear() {
        return year;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "[Nome: " + nome +
                ", Imagem URL: " + urlImage +
                ", Ano: " + year +
                ", Rank: " + rank + "]";
    }
}

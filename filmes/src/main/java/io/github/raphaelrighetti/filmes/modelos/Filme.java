package io.github.raphaelrighetti.filmes.modelos;

import java.time.Year;

public class Filme {

    private final String nome;
    private final String imagemUrl;
    private final Year ano;
    private final double nota;
    private final int rank;

    public Filme(String nome, String imagemUrl, String ano, String nota, String rank) {
        this.nome = nome;
        this.imagemUrl = imagemUrl;
        this.ano = Year.parse(ano);
        this.nota = Double.parseDouble(nota);
        this.rank = Integer.parseInt(rank);
    }

    public String getNome() {
        return nome;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public Year getAno() {
        return ano;
    }

    public double getNota() {
        return nota;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "[Nome: " + nome +
                ", Imagem URL: " + imagemUrl +
                ", Ano: " + ano +
                ", Nota: " + nota +
                ", Rank: " + rank + "]";
    }
}

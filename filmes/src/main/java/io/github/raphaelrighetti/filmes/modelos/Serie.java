package io.github.raphaelrighetti.filmes.modelos;

import io.github.raphaelrighetti.filmes.interfaces.Content;

import java.time.Year;

public class Serie implements Content {

    private final String nome;
    private final String imagemUrl;
    private final Year ano;
    private final double nota;
    private final int rank;

    public Serie(String nome, String imagemUrl, String ano, String nota, String rank) {
        this.nome = nome;
        this.imagemUrl = imagemUrl;
        this.ano = Year.parse(ano);
        this.nota = Double.parseDouble(nota);
        this.rank = Integer.parseInt(rank);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getImagemUrl() {
        return imagemUrl;
    }

    @Override
    public Year getAno() {
        return ano;
    }

    @Override
    public double getNota() {
        return nota;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public String type() {
        return "Série";
    }

    @Override
    public String toString() {
        return "[Nome: " + nome +
                ", Imagem URL: " + imagemUrl +
                ", Ano: " + ano +
                ", Nota: " + nota +
                ", Rank: " + rank + "]";
    }

    @Override
    public int compareTo(Content c) {
        return Double.compare(c.getNota(), nota);
    }
}

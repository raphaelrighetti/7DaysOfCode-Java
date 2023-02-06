package io.github.raphaelrighetti.filmes.modelos;

import io.github.raphaelrighetti.filmes.interfaces.Content;

import java.time.Year;

public class Quadrinho implements Content {

    private final String nome;
    private final String imagemUrl;
    private final Year ano;

    public Quadrinho(String nome, String imagemUrl, String ano) {
        this.nome = nome;
        this.imagemUrl = imagemUrl;
        this.ano = Year.parse(ano);
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
        return 0;
    }

    @Override
    public int getRank() {
        return 0;
    }

    @Override
    public String toString() {
        return "[Nome: " + nome +
                ", Imagem URL: " + imagemUrl +
                ", Ano: " + ano + "]";
    }
}

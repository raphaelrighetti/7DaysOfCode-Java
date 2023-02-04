package io.github.raphaelrighetti.filmes.modelos;

import io.github.raphaelrighetti.filmes.services.JsonParser;

import java.util.Collections;
import java.util.List;

public class Catalogo {

    private List<Filme> filmes;

    public Catalogo(String json) {
        filmes = new JsonParser(json).generateFilmesList(json);
    }

    public List<Filme> getFilmes() {
        checaListaVazia(filmes);
        return Collections.unmodifiableList(filmes);
    }

    private void checaListaVazia(List<Filme> lista) {
        if (lista.isEmpty()) {
            throw new NullPointerException("A lista está vazia!");
        }
    }
}

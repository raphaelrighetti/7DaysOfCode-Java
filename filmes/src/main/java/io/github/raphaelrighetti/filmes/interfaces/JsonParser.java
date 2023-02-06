package io.github.raphaelrighetti.filmes.interfaces;

public interface JsonParser {

    default void checaStringNull(String json) {
        if (json == null) {
            throw new NullPointerException("É necessário passar os dados!");
        }
    }

    String parse(String json);

    String getValorIsolado(String s);
}

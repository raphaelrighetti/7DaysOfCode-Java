package io.github.raphaelrighetti.filmes.services.imdb;

import io.github.raphaelrighetti.filmes.interfaces.ListGenerator;
import io.github.raphaelrighetti.filmes.modelos.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImdbFilmesListGenerator implements ListGenerator {

    private ImdbJsonParser parser = new ImdbJsonParser();
    private String json;

    public ImdbFilmesListGenerator(String json) {
        parser.checaStringNull(json);
        this.json = parser.parse(json);
    }

    @Override
    public List<Filme> generateList() {
        List<Filme> filmes = new ArrayList<>(250);

        Matcher m = Pattern.compile("\\{[^{}]*}").matcher(json);
        while (m.find()) {
            String[] information = m.group().split(",\"");
            String nome = parser.getValorIsolado(information[2]);
            String imagem = parser.getValorIsolado(information[5]);
            String ano = parser.getValorIsolado(information[4]);
            String nota = parser.getValorIsolado(information[7]);
            String rank = parser.getValorIsolado(information[1]);

            filmes.add(new Filme(nome, imagem, ano, nota, rank));
        }

        return filmes;
    }
}

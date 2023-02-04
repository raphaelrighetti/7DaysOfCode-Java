package io.github.raphaelrighetti.filmes.services;

import io.github.raphaelrighetti.filmes.modelos.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {

    private String json;

    public JsonParser(String json) {
        checaStringNull(json);
        this.json = formataJson(json);
    }

    public List<Filme> generateFilmesList(String json) {
        List<Filme> filmes = new ArrayList<>(250);

        Matcher m = Pattern.compile("\\{[^{}]*}").matcher(json);
        while (m.find()) {
            String[] information = m.group().split(",\"");
            String nome = getValorIsolado(information[2]);
            String imagem = getValorIsolado(information[5]);
            String ano = getValorIsolado(information[4]);
            String nota = getValorIsolado(information[7]);
            String rank = getValorIsolado(information[1]);

            filmes.add(new Filme(nome, imagem, ano, nota, rank));
        }

        return filmes;
    }

    private void checaStringNull(String json) {
        if (json == null) {
            throw new NullPointerException("É necessário passar os dados!");
        }
    }

    private String formataJson(String json) {
        Matcher mStart = Pattern.compile("^\\{\"items\":(\\[(.*)]),\"errorMessage\":\"\"}$").matcher(json);
        if (mStart.find()) {
            return mStart.group(2);
        }

        return json;
    }

    private String getValorIsolado(String s) {
        Matcher m1 = Pattern.compile(":\"([^\"]*)\"").matcher(s);
        if (m1.find()) {
            return m1.group(1);
        }

        return s;
    }
}

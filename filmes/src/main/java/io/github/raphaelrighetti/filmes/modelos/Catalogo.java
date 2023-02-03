package io.github.raphaelrighetti.filmes.modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Catalogo {

    private List<Filme> filmes = new ArrayList<>(250);

    public Catalogo(String json) {
        checaStringNull(json);
        json = formataJson(json);
        preencheFilmes(json);
    }

    public List<Filme> getFilmes() {
        checaListaVazia(filmes);
        return Collections.unmodifiableList(filmes);
    }

    private void preencheFilmes(String json) {
        Matcher m = Pattern.compile("\\{[^{}]*}").matcher(json);
        while (m.find()) {
            String[] information = m.group().split(",\"");
            String nome = getValorIsolado(information[2]);
            String imagem = getValorIsolado(information[5]);
            String ano = getValorIsolado(information[4]);
            String rank = getValorIsolado(information[1]);

            filmes.add(new Filme(nome, imagem, ano, rank));
        }
    }

    private void checaStringNull(String json) {
        if (json == null) {
            throw new NullPointerException("É necessário passar os dados!");
        }
    }

    private void checaListaVazia(List<Filme> lista) {
        if (lista.isEmpty()) {
            throw new NullPointerException("A lista está vazia!");
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

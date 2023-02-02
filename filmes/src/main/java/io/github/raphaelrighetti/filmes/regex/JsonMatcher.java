package io.github.raphaelrighetti.filmes.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonMatcher {

    private List<String> filmes = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private List<String> urlImages = new ArrayList<>();
    private List<String> years = new ArrayList<>();
    private List<String> ranks = new ArrayList<>();

    public JsonMatcher(String json) {
        checaStringNull(json);
        json = formataJson(json);
        preencheTudo(json);
    }

    public List<String> getFilmes() {
        checaListaVazia(filmes);
        return Collections.unmodifiableList(filmes);
    }

    public List<String> getTitles() {
        checaListaVazia(titles);
        return Collections.unmodifiableList(titles);
    }

    public List<String> getUrlImages() {
        checaListaVazia(urlImages);
        return Collections.unmodifiableList(urlImages);
    }

    public List<String> getYears() {
        checaListaVazia(years);
        return Collections.unmodifiableList(years);
    }

    public List<String> getRanks() {
        checaListaVazia(ranks);
        return Collections.unmodifiableList(ranks);
    }

    private void preencheFilmes(String json) {
        Matcher matcher = Pattern.compile("(\\{[^{}]*})").matcher(json);
        while (matcher.find()) {
            filmes.add(matcher.group());
        }
    }

    private void preencheTitles(String json) {
        Matcher matcher = Pattern.compile("\"title\":\"([^\"]*)\"").matcher(json);
        while (matcher.find()) {
            titles.add(matcher.group());
        }
    }

    private void preencheUrlImages(String json) {
        Matcher matcher = Pattern.compile("\"image\":\"([^\"]*)\"").matcher(json);
        while (matcher.find()) {
            urlImages.add(matcher.group());
        }
    }

    private void preencheYears(String json) {
        Matcher matcher = Pattern.compile("\"year\":\"([^\"]*)\"").matcher(json);
        while (matcher.find()) {
            years.add(matcher.group());
        }
    }

    private void preencheRanks(String json) {
        Matcher matcher = Pattern.compile("\"rank\":\"([^\"]*)\"").matcher(json);
        while (matcher.find()) {
            ranks.add(matcher.group());
        }
    }

    private void preencheTudo(String json) {
        preencheFilmes(json);
        preencheTitles(json);
        preencheUrlImages(json);
        preencheYears(json);
        preencheRanks(json);
    }

    private void checaStringNull(String json) {
        if (json == null) {
            throw new NullPointerException("É necessário passar os dados!");
        }
    }

    private void checaListaVazia(List<String> lista) {
        if (lista.isEmpty()) {
            throw new NullPointerException("A lista está vazia!");
        }
    }

    private String formataJson(String json) {
        Matcher matcherStart = Pattern.compile("\\{\"items\":\\[").matcher(json);
        String resultWithoutStart = matcherStart.replaceAll("");

        Matcher matcherEnd = Pattern.compile("],\"errorMessage\":\"\"}").matcher(resultWithoutStart);
        String result = matcherEnd.replaceAll("");

        return result;
    }
}

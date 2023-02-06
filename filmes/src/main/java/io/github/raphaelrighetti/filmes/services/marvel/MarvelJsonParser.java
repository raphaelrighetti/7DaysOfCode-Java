package io.github.raphaelrighetti.filmes.services.marvel;

import io.github.raphaelrighetti.filmes.interfaces.JsonParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarvelJsonParser implements JsonParser {

    public String getNome(String result) {
        Matcher matcher = Pattern.compile("\"title\":\"(.*)\",\"issueNumber\"").matcher(result);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    public String getImagemUrl(String result) {
        String path = "";
        String extension = "";

        Matcher pathMatcher = Pattern.compile("\"thumbnail\":\\{\"path\":\"([^\"]*)\",").matcher(result);
        if (pathMatcher.find()) {
            path = pathMatcher.group(1);
        }

        Matcher extensionMatcher = Pattern.compile("\"thumbnail\":\\{.*,\"extension\":\"([^\"]*)\"")
                .matcher(result);
        if (extensionMatcher.find()) {
            extension = extensionMatcher.group(1);
        }

        return path + "." + extension;
    }

    public String getAno(String result) {
        Matcher matcher = Pattern.compile("\"type\":\"onsaleDate\",\"date\":\"([^\"]*)\"},").matcher(result);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    @Override
    public String parse(String json) {
        Matcher matcher = Pattern.compile("\"results\":\\[(.*)]}}$").matcher(json);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    @Override
    public String getValorIsolado(String s) {
        return null;
    }
}

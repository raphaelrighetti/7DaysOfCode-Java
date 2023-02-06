package io.github.raphaelrighetti.filmes.services.imdb;

import io.github.raphaelrighetti.filmes.interfaces.JsonParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImdbJsonParser implements JsonParser {

    @Override
    public String parse(String json) {
        Matcher mStart = Pattern.compile("^\\{\"items\":(\\[(.*)]),\"errorMessage\":\"\"}$").matcher(json);
        if (mStart.find()) {
            return mStart.group(2);
        } else {
            throw new IllegalArgumentException("String passada não está no formato JSON certo");
        }


    }

    @Override
    public String getValorIsolado(String s) {
        Matcher m1 = Pattern.compile(":\"([^\"]*)\"").matcher(s);
        if (m1.find()) {
            return m1.group(1);
        } else {
            throw new IllegalArgumentException("Chave-valor em formato incorreto");
        }
    }
}

package io.github.raphaelrighetti.filmes.services.marvel;

import io.github.raphaelrighetti.filmes.interfaces.Content;
import io.github.raphaelrighetti.filmes.interfaces.ListGenerator;
import io.github.raphaelrighetti.filmes.modelos.Quadrinho;

import java.util.ArrayList;
import java.util.List;

public class MarvelQuadrinhosListGenerator implements ListGenerator {

    private MarvelJsonParser parser = new MarvelJsonParser();
    private String json;

    public MarvelQuadrinhosListGenerator(String json) {
        parser.checaStringNull(json);
        this.json = parser.parse(json);
    }

    @Override
    public List<? extends Content> generateList() {
        List<Quadrinho> quadrinhos = new ArrayList<>();
        String[] splitted = json.split("\\{?\"id\"");
        String[] splittedFixed = new String[splitted.length - 1];

        for (int i = 0; i < splitted.length; i++) {
            if (i == 0) continue;
            splittedFixed[i - 1] = splitted[i];
        }

        for (String item : splittedFixed) {
            String nome = parser.getNome(item);
            String ano = parser.getAno(item).split("-")[0];
            String imagemUrl = parser.getImagemUrl(item);

            quadrinhos.add(new Quadrinho(nome, imagemUrl, ano));
        }

        return quadrinhos;
    }
}

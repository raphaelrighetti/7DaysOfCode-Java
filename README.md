
# 7DaysOfCode-Java

Desafios propostos no 7DaysOfCode - Java da Alura.

## Dia 1

### Requisição à API

Achei muito insteressante o jeito de fazer requisições a APIs no Java 11, muito intuitivo e interessante de usar, pois usa o padrão de projeto "Builder", um padrão que não tinha tido tanto contato até agora.

## Dia 2

### Parseando a resposta JSON para criar listas com as informações retornadas pela API

Nesse desafio pude aprender muita coisa sobre regex no Java, pois foi dito para não usarmos nenhuma biblioteca que facilita o tratamento de dados JSON, apenas usar os métodos de String e regex, usando as classes Matcher e Pattern.

Minha solução não ficou nem de longe a melhor, mas funcionou, e toda a prática que tive solucionando esse desafio foi ótima, estou muito mais familiarizado com regex no Java e muito ansioso para melhorar o meu código!

## Dia 3

### Criando a classe Filme

Nesse desafio pude finalmente criar a classe "Filme" e remover as listas individuais com os valores extraídos da API. Também decidi melhorar um pouco o meu código e estou mais satisfeito com ele agora.

Tive a oportunidade de aprender um pouco sobre Records, apesar de não ter usado, e quebrei a cabeça mudando as minhas expressões regulares.

Reflexões feitas no desafio:

Algumas reflexões: você acha que faz sentido ter setters ou um construtor padrão? Um filme deve ser interfaceado? Deve ser imutável? Justifique a sua decisão no seu repositório. 

Respostas:

1. Não vi sentido em colocar setters na classe "Filmes", pois os filmes não são algo em que a gente vai ficar mexendo, os filmes têm as informações deles e é isso. Único caso em que faria sentido uma mudança seria se o filme tivesse sido registrado com informações erradas.
2. Não acho que um filme deve ser interfaceado, pois ele não precisa ter comportamentos específicos além dos getters e nem precisa ter uma ordem natural nesse caso, pois os filmes já são adicionados à lista por rank.
3. O filme deve ser imutável, pois tanto título quanto imagem, ano e rank não vão mudar (não no meu projeto, pelo menos, se a ordem dos rankings mudarem ou algo do tipo, é dever da API atualizar).

## Dia 4

### Gerando HTML

Nesse desafio pude gerar um código HTML pelo Java, a partir da lista dos filmes, com cada filme contendo as informações dele e guardar em um arquivo.

O layout ficou bem feio e dá pra melhorar muito, mas foi uma experiência muito boa pra praticar tudo que eu aprendi e aplicar umas coisas novas e mais recentes do Java.

Ansioso para melhorar o projeto!

![Screenshot da página](/img/page-screenshot.png)

## Dia 5

### Aplicando encapsulamento

Nesse desafio pude encapsular mais o meu código, criando uma classe separada responsável por executar a requisição HTTP à API e retornar o corpo da resposta, criando outra classe responsável por fazer o tratamento dos dados JSON em String e formar uma lista com os filmes, retornado-a em um método e passando a lógica de escrever/criar o arquivo HTML para a classe HTMLGenerator.

Estou gostando de resolver os desafios e de como o projeto está evoluindo.

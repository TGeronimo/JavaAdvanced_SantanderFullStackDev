package LambdasInterfacesFuncionais;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args) {
        String[] nomes = {"Thiago", "Matheus", "Geronimo", "Estudante", "Java"};
        Integer[] numeros = {1, 2, 3, 4, 5};
        imprimirNomesFiltrados(nomes);
        imprimirTodosNomes(nomes);
        imprimirDobroCadaItemLista(numeros);

        //    Utilizando ArrayList para invocar uma Stream
        List<String> profissoes = new ArrayList<>();
        profissoes.add("Desenvolvedor");
        profissoes.add("Testador");
        profissoes.add("Gerente de Projeto");
        profissoes.add("Gerente de Qualidade");

        profissoes.stream()
                .filter(nome -> nome.startsWith("Gerente"))
                .forEach(System.out::println);

    }

    //        String... -> os três pontos na frente do tipo significam que um array é solicitado como parâmetro.
    public static void imprimirNomesFiltrados(String... nomes) {
        String nomesParaImprimir = " ";
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals("Thiago")) {
                nomesParaImprimir += " " + nomes[i];
            }
        }

        System.out.println("Nomes for: " + nomesParaImprimir);

        String nomesParaImprimirStream = Stream.of(nomes)
                .filter(nome -> nome.equals("Thiago")) // .filter() pede um Predicate como parâmetro
                .collect(Collectors.joining()); // joining "pega" um array de Strings e transforma em uma só string
        System.out.println("Nomes stream: " + nomesParaImprimirStream);

    }

    public static void imprimirTodosNomes(String... nomes) {
        for (String nome : nomes) {
            System.out.println("Impresso pelo for: " + nome);
        }

        Stream.of(nomes)
                .forEach(nome -> System.out.println("Impresso pelo forEach do Stream: " + nome)); //.forEach() pede um Consumer como parâmetro
    }

    public static void imprimirDobroCadaItemLista (Integer... numeros) {

//        Pelo for each
//        for (Integer numero : numeros) {
//            System.out.println(numero * 2);
//        }

        Stream.of(numeros)
                .map(numero -> numero * 2)
                .forEach(System.out::println);
    }
}

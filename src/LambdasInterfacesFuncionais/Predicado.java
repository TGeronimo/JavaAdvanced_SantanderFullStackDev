package LambdasInterfacesFuncionais;

import java.util.function.Predicate;

public class Predicado {
    public static void main(String[] args) {

        //  Utilizando a sintaxe lambda padrão
//        Predicate<String> estaVazio = valor -> valor.isEmpty();

//          Utilizando method reference (sintaxe => Tipo::método (sem parênteses))
//        Predicate<String> estaVazio = String::isEmpty;

//        Utilizando chaves
        Predicate<String> estaVazio = valor -> {
            return valor.isEmpty();
        };


        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("Tales"));

    }
}

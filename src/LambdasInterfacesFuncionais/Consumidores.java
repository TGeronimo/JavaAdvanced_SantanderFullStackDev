package LambdasInterfacesFuncionais;

import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args) {

//        Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);

//        Outra forma de implementar a função acima, mas com sintaxe mais limpa e omitindo a variável
        Consumer<String> imprimirUmaFrase = System.out::println;

        imprimirUmaFrase.accept("Hello Worudo!");

    }
}

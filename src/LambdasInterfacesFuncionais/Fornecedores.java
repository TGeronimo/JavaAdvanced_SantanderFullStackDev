package LambdasInterfacesFuncionais;

import java.util.function.Supplier;

public class Fornecedores {
    public static void main(String[] args) {
        Supplier<Pessoa> suppliers = () -> new Pessoa("Tales",13);

//        Usando method reference. Neste caso, só funciona com contrutor vazio
//        Supplier<Pessoa> outraForma = Pessoa::new;

        System.out.println(suppliers.get());
    }
}

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.idade = idade;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return String.format("nome: %s, idade: %d", nome, idade);
    }
}
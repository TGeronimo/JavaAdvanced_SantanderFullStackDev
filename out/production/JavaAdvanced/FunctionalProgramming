# Functional Programming
___

## Lambda functions

Para implementar o paradigma funcional é necessário
implementar interfaces funcionais.
<br>
Para que uma interface seja considerada funcional
ela deve ter apenas um método abstrato.<br> A anotação
**_@FunctionalInterface_** auxilia o compilador e a leitura
do código.

Lambda sintax:
> InterfaceFuncional nomeVariavel = parametro -> logica;

Não é necessário o uso de chaves quando se tem apenas um parâmetro.
Para mais de um parâmetro, além do uso das chaves, o tipo de retorno 
deve ser declarado (caso não seja void).

### Funções de alta ordem

Recebem ou retornam uma função por parâmetro. No exemplo abaixo, criamos
a interface funcional Calculo(), cujo método abstrato calcular() recebe dois inteiros.
A classe FuncaoAltaOrdem utiliza a interface funcional no método executarOperacao()
e define calcular() como retorno, com os dois inteiros recebidos como argumento.
<br>
Finalmente, utilizamos expressões lambda em main() definindo o comportamento
de executarOperacao().

```java
public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        Calculo soma    = (a, b) -> a + b;
        Calculo subtr   = (a, b) -> a - b;
        Calculo multip  = (a, b) -> a * b;
        Calculo divisao = (a, b) -> a / b;
        
        System.out.println(executarOperacao(soma, 1, 3));
        System.out.println(executarOperacao(subtr, 1, 3));
        System.out.println(executarOperacao(multip, 2, 3));
        System.out.println(executarOperacao(divisao, 9, 3));
    }
    
//    Este método é uma função de alta ordem, pois pede a
//    função Calculo como parâmetro.
    public static executarOperacao(Calculo ca, int a, int b) {
        return ca.calcular(a, b);
    }
}

@FunctionalInterface
interface Calculo {
    public int calcular(int a, int b);
}
```
No Java é mais comum um método pedir uma função como parâmetro, mas dificilmente
retornará uma função.
___
## Functional Interfaces
### Interface _Consumer_
Esta interface genérica deve ter o tipo especificado na lambda - Consumer<T> -
e não tem retorno, sendo úteis quando não é necessário receber valores como retorno de uma função.
No Javadoc diz que esta interface opera por efeitos colaterais (side-effects).
<br>
Seu método abstrato é o accept().

```java
// Exemplo aula DIO com método accept()

import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args) {
        
        Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);
        imprimirUmaFrase.accept("Hello Worudo!");
        
//        Outra forma de implementar com sintaxe diferente e omitindo a variável
//        (method reference)
        Consumer<String> imprimirUmaFrase = System.out::println;
        
    }
}
```

```java
// Java Program to demonstrate
// Consumer's accept() method
// https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/
  
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
  
public class Main {
    public static void main(String args[])
    {
        // Consumer to display a number
        Consumer<Integer> display = a -> System.out.println(a);
  
        // Implement display using accept()
        display.accept(10);
  
        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer>> modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };
  
        // Consumer to display a list of numbers
        Consumer<List<Integer>>
            dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
  
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
  
        // Implement modify using accept()
        modify.accept(list);
  
        // Implement dispList using accept()
        dispList.accept(list);
    }
}
```
Exemplo de aplicação do método não abstrato andThen():
```java
// Java Program to demonstrate
// Consumer's andThen() method
// https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/
  
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
  
public class Main {
    public static void main(String args[])
    {
  
        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };
  
        // Consumer to display a list of integers
        Consumer<List<Integer> >
            dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
  
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
  
        // using addThen()
        modify.andThen(dispList).accept(list);
        ;
    }
}
```

### Interface _Function_
Pede o tipo da entrada e o tipo do retorno. Seu método abstrato é o apply().
```java
import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {
        Function<String, String> retornaNomeContrario = texto -> new StringBuilder(texto).reverse().toString();
        System.out.println(retornaNomeContrario.apply("Tales"));

        Function<Integer, String> stringInteiro = string -> Integer.valueOf(string) * 2;
        System.out.println(stringInteiro.apply(20));
    }
}
```

### Interface _Predicate_
Pede a definição de um tipo de entrada e retorna um tipo boolean.
Seu método abstrato é test().

```java
import java.util.function.Predicate;

public class Predicado {
    public static void main(String[] args) {
        Predicate<String> estaVazio = valor -> valor.isEmpty();
        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("Tales"));

    }
}
```
### Interface _Supplier_
Não recebe parâmetro e retorna o tipo especificado no generics.
Seu método abstrato é o get().

```java
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
```
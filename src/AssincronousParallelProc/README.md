# Processamento Assíncrono e Paralelo

## Thread

Um pequeno programa que trabalha como subsistema, sendo uma forma
de um processo se autodividir em duas ou mais tarefas. Essas tarefas
múltiplas podem ser executadas simultaneamente para rodar mais rápido
do que um programa em um único bloco ou praticamente juntas.

## Processamento Síncrono e Assíncrono

- _**Síncrono**_ -> processamentos que ocorrem em sequência (fila) e um processo só
pode ser executado quando o outro terminar.
- _**Assíncrono**_ -> dois ou mais processos executados simultaneamente.

### Interface Runnable

Esta interface deve ser implementada por toda classe cuja instância 
seja executada por uma thread. Classes que implementam Runnable podem
se manter ativas sem a necessidade de se tornarem subclasses de Thread,
bastando apenas sobrescrever o método run(), que não requer argumentos.

```java
class BarraDeCarregamento implements Runnable {
    @Override
    public void run() {
        System.out.println("Loading...");
    }
}
```
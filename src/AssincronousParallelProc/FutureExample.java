package AssincronousParallelProc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FutureExample {
    private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        Casa casa = new Casa(new Quarto());
        List<Future<String>> futuros =
                new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
                        .map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
                                    try {
                                        return atividade.realizar();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                })
                        )
                        .collect(Collectors.toList()));

        while (true) {
            int numeroDeAtividadesNaoRealizadas = 0;
            for (Future<?> futuro:futuros) {
                if (futuro.isDone()) {
                    try {
                        System.out.println("Parabéns, você terminou de " + futuro.get());
                        futuros.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    numeroDeAtividadesNaoRealizadas++;
                }
            }
            if (futuros.stream().allMatch(Future::isDone)) {
                break;
            }
            System.out.println("Número de atividades não finalizadas: " + numeroDeAtividadesNaoRealizadas);
            Thread.sleep(500);
            }
        pessoasParaExecutarAtividade.shutdown();

    }
}

class Casa {
    private List<Comodo> comodos;

    Casa(Comodo... comodos) {
        this.comodos = Arrays.asList(comodos);
    }

//  Instrutor não explica os detalhes do método, pois não é o foco
//    Pelo que entendi, o stream percorre a list de atividades, retornando
//    o resultado do método obterAfazeresDoComodo() para cada atividade e
//    eliminando cada atividade com o método reduce()
    List<Atividade> obterAfazeresDaCasa() {
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<>(), (pivo, atividades) -> {
                pivo.addAll(atividades);
                return pivo;
                });
    }

}

interface Atividade {
    String realizar() throws InterruptedException;
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {
    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
            this::arrumarACama,
            this::varrerOQuarto,
            this::arrumarGuardaRoupas
        );
    }

    private String arrumarGuardaRoupas() throws InterruptedException {
        Thread.sleep(5000);
        String arrumar_o_guarda_roupas = "Arrumar o guarda roupas";
        System.out.println(arrumar_o_guarda_roupas);
        return arrumar_o_guarda_roupas;
    }

    private String varrerOQuarto() throws InterruptedException {
        Thread.sleep(7000);
        String varrer_o_quarto = "Varrer o quarto";
        System.out.println(varrer_o_quarto);
        return varrer_o_quarto;
    }

    private String arrumarACama() throws InterruptedException {
        Thread.sleep(10000);
        String arrumar_a_cama = "Arrumar a cama";
        System.out.println(arrumar_a_cama);
        return arrumar_a_cama;
    }
}
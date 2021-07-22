package AssincronousParallelProc;

import java.util.Arrays;

public class ThreadsExample {
    public static void main(String[] args) {
//        Implementação com implementação de Runnable
        Thread thread = new Thread(new BarraDeCarregamento2());
        Thread thread2 = new Thread(new BarraDeCarregamento3());

        thread.run();
        thread2.run();
        System.out.println("Nome da thread: " + thread.getName());
        System.out.println("Nome da thread: " + thread2.getName());



//        Implementação com subclasse de Thread
//        BarraDeCarregamento2 bc2 = new BarraDeCarregamento2();
//        BarraDeCarregamento2 bc3 = new BarraDeCarregamento2();
//
//        bc2.start();
//        bc3.start();
    }

}

class GerarPDF2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Gerar PDF");
    }
}


// Classes abaixo criadas para exemplificar o processamento assíncrono

//  Mesmas classes, mas utilizando a interface Runnable
class BarraDeCarregamento2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("rodei Barra2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento3 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("rodei Barra 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

//  Utilizando subclasses de Thread

//class BarraDeCarregamento2 extends Thread {
//    @Override
//    public void run() {
//        super.run();
//
//        try {
//            Thread.sleep(1000);
//            System.out.println("rodei -> " + this.getName());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
//
//class BarraDeCarregamento3 extends Thread {
//    @Override
//    public void run() {
//        super.run();
//
//        try {
//            Thread.sleep(10000);
//            System.out.println("rodei -> " + this.getName());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}

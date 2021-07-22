package AssincronousParallelProc;

public class PDFLoading {
    public static void main(String[] args) {
        GeradorPDF iniciarGeradorPDF = new GeradorPDF();
        BarraDeCarregamento iniciarBarradeCarregamento = new BarraDeCarregamento(iniciarGeradorPDF);

        iniciarGeradorPDF.start();
        iniciarBarradeCarregamento.start();
    }
}

class GeradorPDF extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Iniciar geração do PDF");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF gerado");
    }
}

class BarraDeCarregamento extends Thread {
    private Thread iniciarGeradorPDF;

    public BarraDeCarregamento(Thread iniciarGeradorPDF) {
        this.iniciarGeradorPDF = iniciarGeradorPDF;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                if (!iniciarGeradorPDF.isAlive()) {
                    break;
                }
                System.out.println("Loading...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

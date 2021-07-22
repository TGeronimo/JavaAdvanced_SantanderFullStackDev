public class ExInicial {
    public static void main(String[] args) {
//          Apenas um parâmetro
        Funcao funcao = colocaSr -> "Sr. " + colocaSr;
        System.out.println(funcao.gerar("Thiago"));

//        Dois parâmetros (o mesmo 2x)
        Funcao funcao1 = colocaSr -> {
            System.out.println("Sr. " + colocaSr);
            System.out.println("Mr. " + colocaSr);
            return colocaSr; // Caso o método abstrato retorne void, não é necessário inserir o retorno.
        };
        System.out.println(funcao1.gerar("Thiago"));
    }
}

package compra;
import java.util.Scanner;

public class Cupom {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        float valorProduto, cupomDesconto, valorCarrinho, valorFinal;
        int qtdProduto;
        String idProduto;
        String nomeCliente = "";
        int opcao;
        valorCarrinho = 0.0f;

        // Construção do "carrinho"
        System.out.println("Para onde deseja prosseguir: \n [1] - Adicionar novo produto \n [2] - Posseguir com a compra");
        opcao = leitor.nextInt();
        leitor.nextLine();
        

        switch (opcao) {
            case 1:
                //Utilizar função Marcos
                break;

            case 2:
                // Calculando elegibilidade para Cupom
                if (valorCarrinho >= 50.00) {
                    cupomDesconto = 0.75f;
                    valorFinal = valorCarrinho * cupomDesconto;
                } else {
                    if (valorCarrinho >= 150.00) {
                        cupomDesconto = 0.60f;
                        valorFinal = valorCarrinho * cupomDesconto;
                    }
                }
            default:
                System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");

        }
    }
}

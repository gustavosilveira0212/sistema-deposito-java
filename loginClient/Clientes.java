package loginClient;

import funcionarios.Staff;
import estoque.Carrinho;
import dao.CarrinhoDAO;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import dao.ProdutoDAO;
import estoque.Produto;

public class Clientes {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        boolean escolhaId = false;
        int idUsuarioLogado = 1;

        int escolhaMenu;
        System.out.println("Seja bem vindo");
        System.out.println("Voce deseja:");
        System.out.printf("[1] - ver produtos disponiveis%n[2] - Ver meu carrinho.%n[0] - Voltar ao menu inicial%n");
        System.out.print("Selecione :");
        escolhaMenu = sc.nextInt();

        ProdutoDAO dao;

        switch (escolhaMenu) {
            case 1:
                dao = new ProdutoDAO();
                int menuIdProduto;
                int menuQuantidadeProduto;
                Produto produtoEscolhido = null;
                List<Produto> produtos = dao.listarProdutos();

                for (Produto p : produtos) { 
                    System.out.println("ID - " 
                            + p.getId() 
                            + " | Nome - "
                            + p.getNomeProduto() 
                            + " | Quantidade - " 
                            + p.getQuantidadeProduto() 
                            + " | Valor - "
                            + p.getValorProduto());
                }

                while (!escolhaId) {
                    System.out.print("Selecione o id do produto que deseja: ");
                    menuIdProduto = sc.nextInt();
                    sc.nextLine();
                    boolean produtoEncontrado = false;
                    for (Produto p : produtos) {
                        if (p.getId() == menuIdProduto) {
                            produtoEscolhido = p;
                            System.out.println("Produto encontrado: " + p.getNomeProduto());
                            produtoEncontrado = true;
                            escolhaId = true;   
                        }
                    }
                    if (produtoEncontrado == false) {
                        System.out.println("Id invalido! Digite novamente.");
                        escolhaId = false;
                    }
                }

                do {
                    System.out.print("Qual a quantidade de produto que voce deseja pegar: ");
                    menuQuantidadeProduto = sc.nextInt();
                
                if ( menuQuantidadeProduto >= 0 && menuQuantidadeProduto <= produtoEscolhido.getQuantidadeProduto()) {
                     CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
                     Carrinho carrinho = new Carrinho();

                    carrinho.setIdUsuario(idUsuarioLogado);
                    carrinho.setIdProduto(produtoEscolhido.getId());
                    carrinho.setQuantidadeCarrinho(menuQuantidadeProduto);

                    carrinhoDAO.adicionarAoCarrinho(carrinho);

                    
                    loop = false;
                } else {
                    System.out.println("Quantidade inválida!");
                    loop = true;
                }
                } while (loop);

                break;
            case 2:
                CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
                List<Carrinho> itensCarrinho = carrinhoDAO.listarCarrinhoUsuario(idUsuarioLogado);

                if (itensCarrinho.isEmpty()) {
                    System.out.println("Carrinho vazio!");
                } else {
                    for (Carrinho c : itensCarrinho) {
                        System.out.println("ID Carrinho: " + c.getIdCarrinho()
                            + " | ID Produto: " + c.getIdProduto()
                            + " | Quantidade: " + c.getQuantidadeCarrinho());
                    }
                }
                loop = true;
                break;
            case 0:
                System.out.println("Voltando para o menu.");
                loop = false;
                break;
            default:
                System.out.println("Opção invalida. tente novamente");
                loop = true;
                break;
        }

        sc.close();

    }
}
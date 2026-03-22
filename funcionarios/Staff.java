package funcionarios;

import loginClient.Clientes;
import java.util.Scanner;
import java.util.List;
import dao.ProdutoDAO;
import estoque.Produto;

import java.util.Locale;

public class Staff {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        Produto dados;
        Locale.setDefault(Locale.US);

        boolean idValido = false;
        boolean escolhaId = false;

        System.out.printf("Modo Staff: %n[1] - Adicionar produto no estoque: %n[2] - Editar produto em estoque: %nSelecionar: ");

        int escolha = leitor.nextInt();
        leitor.nextLine();

        String nomeProduto;
        double valorProduto;
        int quantidadeProduto;
        ProdutoDAO dao;

        String novoNome;
        Produto produto;
        int escolhaMudanca;
        int novaQuantidade;
        double novoValor;

        Produto atualizacaoPedido;

        switch (escolha) {
            case 1: // Adicionar produto
                idValido = false;
                System.out.println("Adicionando produto, informe:");
                System.out.print("Nome do produto: ");
                nomeProduto = leitor.nextLine().trim();
                
                System.out.print("Quantidade: ");
                quantidadeProduto = leitor.nextInt();

                System.out.print("Valor unitário do produto: ");
                valorProduto = leitor.nextDouble();
                
                produto = new Produto(nomeProduto, valorProduto, quantidadeProduto);

                System.out.println("Produto cadastrado com sucesso!");

                new ProdutoDAO().cadastrarProduto(produto);
                
                break;
            case 2:
                int menuIdProduto;
                Produto produtoEscolhido = null;
                dao = new ProdutoDAO();
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
                    menuIdProduto = leitor.nextInt();

                    leitor.nextLine();
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

                System.out.printf("O que deseja editar?%n[1] - Nome do produto%n[2] - Quantidade do produto%n[3] - Valor do produto%nSelecionar: ");
                int escolhaEdicao = leitor.nextInt();
                leitor.nextLine();

                if(escolhaEdicao == 1) {
                    System.out.print("Digite o novo nome do produto: ");
                    novoNome = leitor.nextLine();
                    dao.atualizarNomeProduto(novoNome);

                } else if (escolhaEdicao == 2) {

                    System.out.print("Digite a nova quantidade do produto: ");
                    novaQuantidade = leitor.nextInt();
                    dao.atualizarQuantidadeProduto(novaQuantidade);

                    

                } else if (escolhaEdicao == 3) {
                    
                    System.out.print("Digite o novo valor do produto: ");
                    novoValor = leitor.nextDouble();
                    dao.atualizarValorProduto(novoValor);

                } else {
                    System.out.println("Opção inválida! Nenhuma alteração feita.");
                }


                break;    
        }

        leitor.close();
    }
}
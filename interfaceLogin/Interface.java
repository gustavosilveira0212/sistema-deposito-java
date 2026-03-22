package interfaceLogin;

import sistemaInterface.Usuario;
import sistemaInterface.UsuarioStaff;

import java.util.Scanner;

import dao.UsuarioDAO;
import dao.StaffDAO;

import java.util.Locale;

public class Interface {
    public static void main(String[] args) {
        System.out.println("Seja bem vindo ao Departamento de Operações e Vendas!");

        final String SENHACADASTROSTAFF = "gustavaodamassa";

        Scanner leitor = new Scanner(System.in);

        Locale.setDefault(Locale.US);

        String nomeCliente = "";
        boolean nomeValido = false;
        boolean cpfValido = false;
        String emailCliente = "";
        String cpfCliente = "";
        boolean emailValido = false;
        String senhaCliente = "";
        String nomeStaff = "";
        String cpfStaff = "";
        String emailStaff = "";
        String senhaStaff = "";
        String senhaRegistroStaff = "";
        Usuario interfaceUsuario;
        UsuarioStaff registroStaff;
        boolean senhaRegistroStaffValida = false;
        int codigoStaff;
        String palavraChave;

        System.out
                .printf("Menu:%n[1] - Registrar%n[2] - Fazer Login%n[3] - Registrar novo STAFF%nQual a sua escolha? ");
        int escolhaMenu = leitor.nextInt();
        leitor.nextLine();

        switch (escolhaMenu) {
            case 1:

                while (!nomeValido) {
                    System.out.print("Digite o seu nome completo: ");
                    nomeCliente = leitor.nextLine().trim();

                    if (nomeCliente.matches("\\p{L}+( \\p{L}+)+")) {
                        nomeValido = true;

                    } else {
                        System.out.println("Inválido! Digite apenas letras e acentos.");
                    }
                }

                while (!cpfValido) {
                    System.out.print("Digite o seu CPF (sem pontos e traços): ");
                    cpfCliente = leitor.nextLine().trim();

                    if (cpfCliente.length() == 11 && cpfCliente.matches("\\d{11}")) {
                        cpfValido = true;
                    } else {
                        System.out.println("Formato inválido! Digite apenas números, sendo 11 dígitos no total.");
                    }
                }

                while (!emailValido) {
                    System.out.print("Digite o seu e-mail no formato nome@email.com.br: ");
                    emailCliente = leitor.nextLine().trim();

                    if (emailCliente.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                        emailValido = true;
                    } else {
                        System.out.println("Formato inválido! Digite da forma correta.");
                    }
                }

                System.out.print("Digite a sua senha: ");
                senhaCliente = leitor.nextLine().trim();

                interfaceUsuario = new Usuario(nomeCliente, cpfCliente, emailCliente, senhaCliente);

                new UsuarioDAO().cadastrarUsuario(interfaceUsuario);

                break;

            case 2:

                UsuarioDAO dao = new UsuarioDAO();

                System.out.println("Seja bem vindo!");
                System.out.print("Digite o seu CPF: ");
                cpfCliente = leitor.nextLine().trim();

                System.out.print("Digite a senha: ");
                senhaCliente = leitor.nextLine();

                if (dao.login(cpfCliente, senhaCliente)) {
                    System.out.print("Login realizado com sucesso!");
                } else {
                    System.out.println("CPF ou senha incorreta!");
                }

                break;

            case 3:

                while (!senhaRegistroStaffValida) {
                    System.out.print("Digite a senha para registro de um novo STAFF: ");
                    senhaRegistroStaff = leitor.nextLine().trim();

                    if (senhaRegistroStaff.equals(SENHACADASTROSTAFF)) {
                        do {System.out.print("Digite o ID do Staff: ");
                        codigoStaff = leitor.nextInt();
                        leitor.nextLine();
                        if (codigoStaff == 1) {
                            System.out.printf("Digite a palavra chave :%nPalavra-Chave: ");
                            palavraChave = leitor.nextLine().trim();
                            if ( palavraChave.equals("Admin123")) {
                                System.out.println("Permissão liberada para vincular.");
                                senhaRegistroStaffValida = true;
                            } else {
                                System.out.println("Palavra-chave incorreta. Tente novamente!");
                            }
                        }
                        } while(!senhaRegistroStaffValida);

                        System.out.print("Digite o nome completo do STAFF: ");
                        nomeStaff = leitor.nextLine();

                        System.out.print("Digite o CPF do STAFF: ");
                        cpfStaff = leitor.nextLine();

                        System.out.print("Digite o e-mail do STAFF: ");
                        emailStaff = leitor.nextLine();

                        System.out.print("Digite a senha do STAFF: ");
                        senhaStaff = leitor.nextLine();

                        registroStaff = new UsuarioStaff(nomeStaff, emailStaff, codigoStaff, cpfStaff, senhaStaff);

                        new StaffDAO().cadastrarStaff(registroStaff);

                        System.out.println("Cadastrado com sucesso!");

                        senhaRegistroStaffValida = true;
                    } else {
                        System.out.println("Senha errada. Tente novamente.");
                    }
                }
                break;

        }

        leitor.close();
    }
}

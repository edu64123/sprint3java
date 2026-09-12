package br.com.fiap.soulup.tests;

import br.com.fiap.soulup.dao.BilheteUnicoDAO;
import br.com.fiap.soulup.dao.MissaoDAO;
import br.com.fiap.soulup.dao.PostagemDAO;
import br.com.fiap.soulup.dao.UsuarioDAO;

import br.com.fiap.soulup.models.BilheteUnico;
import br.com.fiap.soulup.models.Missao;
import br.com.fiap.soulup.models.Postagem;
import br.com.fiap.soulup.models.Usuario;

import java.util.List;
import java.util.Scanner;

public class TesteSoulUp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PostagemDAO postagemDAO = new PostagemDAO();
        BilheteUnicoDAO bilheteDAO = new BilheteUnicoDAO();
        MissaoDAO missaoDAO = new MissaoDAO();

        int opcao;

        do {

            System.out.println(" SOULUP ");

            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Cadastrar Postagem");
            System.out.println("3 - Cadastrar Bilhete Único");
            System.out.println("4 - Listar Missões");
            System.out.println("5 - Listar Usuários");
            System.out.println("6 - Buscar Postagem");
            System.out.println("7 - Buscar Bilhete Único");
            System.out.println("8 - Buscar Missão");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n--- CADASTRAR USUÁRIO ---");

                    System.out.print("Username: ");
                    String username = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    System.out.print("ID do usuário: ");
                    int idUsuario = scanner.nextInt();

                    Usuario usuario = new Usuario(username, senha);

                    usuario.setId(idUsuario);

                    usuarioDAO.cadastrar(usuario);

                    System.out.println("Usuário cadastrado com sucesso!");

                    break;

                case 2:

                    System.out.println("\n CADASTRAR POSTAGEM ");

                    System.out.print("ID da postagem: ");
                    int idPostagem = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("ID do usuário: ");
                    int idUsuarioPostagem = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Conteúdo da postagem: ");
                    String conteudo = scanner.nextLine();

                    Postagem postagem =
                            new Postagem(conteudo, idUsuarioPostagem);

                    postagem.setId(idPostagem);

                    postagemDAO.cadastrar(postagem);

                    System.out.println("Postagem cadastrada com sucesso!");

                    break;

                case 3:

                    System.out.println("\n CADASTRAR BILHETE ÚNICO ");

                    System.out.print("ID do bilhete: ");
                    int idBilhete = scanner.nextInt();

                    System.out.print("ID do usuário: ");
                    int idUsuarioBilhete = scanner.nextInt();

                    BilheteUnico bilhete =
                            new BilheteUnico(idUsuarioBilhete);

                    bilhete.setId(idBilhete);

                    System.out.print("Saldo inicial: ");
                    double saldo = scanner.nextDouble();

                    bilhete.adicionarSaldo(saldo);

                    bilheteDAO.cadastrar(bilhete);

                    System.out.println("Bilhete cadastrado com sucesso!");

                    break;

                case 4:

                    System.out.println("\n MISSÕES DISPONÍVEIS ");

                    Missao missao1 = new Missao(
                            1,
                            "Participar de uma ação sustentável",
                            500
                    );

                    Missao missao2 = new Missao(
                            2,
                            "Usar transporte público durante a semana",
                            300
                    );

                    Missao missao3 = new Missao(
                            3,
                            "Reciclar materiais em casa",
                            200
                    );

                    Missao missao4 = new Missao(
                            4,
                            "Plantar uma árvore",
                            700
                    );

                    Missao missao5 = new Missao(
                            5,
                            "Participar de uma campanha ambiental",
                            600
                    );

                    System.out.println(missao1);
                    System.out.println(missao2);
                    System.out.println(missao3);
                    System.out.println(missao4);
                    System.out.println(missao5);

                    break;

                case 5:

                    System.out.println("\n--- LISTA DE USUÁRIOS ---");

                    try {

                        List<Usuario> usuarios = usuarioDAO.listar();

                        if (usuarios.isEmpty()) {

                            System.out.println("Nenhum usuário cadastrado.");

                        } else {

                            for (Usuario u : usuarios) {

                                System.out.println(u);

                            }
                        }

                    } catch (Exception e) {

                        System.out.println("Erro ao listar usuários.");

                    }

                    break;

                case 6:

                    System.out.println("\n BUSCAR POSTAGEM ");

                    try {

                        System.out.print("ID da postagem: ");

                        int idBuscaPostagem = scanner.nextInt();

                        Postagem postagemBusca =
                                postagemDAO.buscarPorId(idBuscaPostagem);

                        if (postagemBusca != null) {

                            System.out.println(postagemBusca);

                        } else {

                            System.out.println("Postagem não encontrada.");

                        }

                    } catch (Exception e) {

                        System.out.println("ID inválido.");

                        scanner.nextLine();

                    }

                    break;

                case 7:

                    System.out.println("\n--- BUSCAR BILHETE ---");

                    try {

                        System.out.print("ID do usuário: ");

                        int idBuscaBilhete = scanner.nextInt();

                        BilheteUnico bilheteBusca =
                                bilheteDAO.buscarPorUsuario(idBuscaBilhete);

                        if (bilheteBusca != null) {

                            System.out.println(bilheteBusca);

                        } else {

                            System.out.println("Bilhete Único não encontrado.");

                        }

                    } catch (Exception e) {

                        System.out.println("ID inválido.");

                        scanner.nextLine();

                    }

                    break;

                case 8:

                    System.out.println("\n BUSCAR MISSÃO ");

                    try {

                        System.out.print("ID da missão: ");

                        int idBuscaMissao = scanner.nextInt();

                        Missao missaoBusca =
                                missaoDAO.buscarPorId(idBuscaMissao);

                        if (missaoBusca != null) {

                            System.out.println(missaoBusca);

                        } else {

                            System.out.println("Missão não encontrada.");

                        }

                    } catch (Exception e) {

                        System.out.println("ID inválido.");

                        scanner.nextLine();

                    }

                    break;

                case 0:

                    System.out.println("Encerrando o sistema...");

                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
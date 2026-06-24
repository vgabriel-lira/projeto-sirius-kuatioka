package br.edu.ifpb.ui;

import br.edu.ifpb.controlador.BibliotecaController;
import br.edu.ifpb.modelo.Item;
import br.edu.ifpb.excecao.*;
import java.util.List;
import java.util.Scanner;

public class BibliotecaView {
    private BibliotecaController controller;
    private Scanner scanner;

    public BibliotecaView(BibliotecaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n=================================");
            System.out.println("   PROJETO SIRIUS - BIBLIOTECA KUATIAOKA ");
            System.out.println("=================================");
            System.out.println("1. Cadastros");
            System.out.println("2. Operações (Empréstimos, Devoluções e Vendas)");
            System.out.println("3. Consultas e Relatórios");
            System.out.println("0. Sair do Sistema");
            System.out.println("---------------------------------");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1: submenuCadastros(); break;
                    case 2: submenuOperacoes(); break;
                    case 3: submenuConsultas(); break;
                    case 0: System.out.println("\nEncerrando o sistema Sirius..."); break;
                    default: System.out.println("Opção inválida."); pausar();
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] Erro: Digite apenas números.");
                pausar();
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private void submenuCadastros() {
        int opcao;
        do {
            System.out.println("\n--- [ SUBMENU DE CADASTROS ] ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Cadastrar Editora");
            System.out.println("3. Cadastrar Autor");
            System.out.println("4. Cadastrar Item (Livro/Revista/CD)");
            System.out.println("5. Cadastrar Jogo de Tabuleiro");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("--------------------------------");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1: cadastrarUsuario(); break;
                    case 2: cadastrarEditora(); break;
                    case 3: cadastrarAutor(); break;
                    case 4: cadastrarItem(); break;
                    case 5: cadastrarJogo(); break;
                    case 0: break;
                    default: System.out.println("Opção inválida."); pausar();
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] Erro: Digite apenas números.");
                pausar();
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private void submenuOperacoes() {
        int opcao;
        do {
            System.out.println("\n--- [ SUBMENU DE OPERAÇÕES ] ---");
            System.out.println("1. Realizar Empréstimo");
            System.out.println("2. Realizar Devolução");
            System.out.println("3. Vender Jogo de Tabuleiro");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("--------------------------------");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1: realizarEmprestimo(); break;
                    case 2: realizarDevolucao(); break;
                    case 3: venderJogo(); break;
                    case 0: break;
                    default: System.out.println("Opção inválida."); pausar();
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] Erro: Digite apenas números.");
                pausar();
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private void submenuConsultas() {
        int opcao;
        do {
            System.out.println("\n--- [ SUBMENU DE CONSULTAS E RELATÓRIOS ] ---");
            System.out.println("1. Listar/Buscar Itens por Título");
            System.out.println("2. Histórico de Empréstimos");
            System.out.println("3. Consultar Vendas de Jogos");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("---------------------------------------------");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1: consultarItens(); break;
                    case 2: historicoEmprestimos(); break;
                    case 3: consultarVendas(); break;
                    case 0: break;
                    default: System.out.println("Opção inválida."); pausar();
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] Erro: Digite apenas números.");
                pausar();
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private void pausar() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private void cadastrarUsuario() {
        System.out.println("\n--- Cadastrar Usuário ---");
        System.out.println("Escolha o tipo de usuário:");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.print("Digite o número: ");
        int tipo = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula/ID: ");
        String matricula = scanner.nextLine();

        try {
            boolean sucesso = controller.cadastrarUsuario(tipo, nome, matricula);
            exibirResultado(sucesso);
        } catch (UsuarioDuplicadoException e) {
            System.out.println("Erro: " + e.getMessage());
            pausar();
        }
    }

    private void cadastrarEditora() {
        System.out.println("\n--- Cadastrar Editora ---");
        System.out.print("Nome da Editora: ");
        String nome = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        boolean sucesso = controller.cadastrarEditora(nome, cnpj);
        exibirResultado(sucesso);
    }

    private void cadastrarAutor() {
        System.out.println("\n--- Cadastrar Autor ---");
        System.out.print("ID do Autor: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Biografia: ");
        String biografia = scanner.nextLine();

        boolean sucesso = controller.cadastrarAutor(id, nome, biografia);
        exibirResultado(sucesso);
    }

    private void cadastrarItem() {
        System.out.println("\n--- Cadastrar Item ---");
        System.out.println("Escolha o tipo do item:");
        System.out.println("1 - Livro Físico");
        System.out.println("2 - Áudio-livro");
        System.out.println("3 - Revista");
        System.out.println("4 - CD");
        System.out.print("Digite o número: ");
        int tipo = Integer.parseInt(scanner.nextLine());
        
        System.out.print("ID do Item: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Nome do Autor: ");
        String autor = scanner.nextLine();

        try {
            boolean sucesso = false;
            if (tipo == 1) {
                System.out.print("Nome da Editora: ");
                String nomeEditora = scanner.nextLine();
                System.out.print("Páginas: ");
                int paginas = Integer.parseInt(scanner.nextLine());
                sucesso = controller.cadastrarLivroFisico(id, titulo, autor, nomeEditora, paginas);
            } else if (tipo == 2) {
                System.out.print("Nome da Editora: ");
                String nomeEditora = scanner.nextLine();
                System.out.print("Duração (min): ");
                int duracao = Integer.parseInt(scanner.nextLine());
                sucesso = controller.cadastrarAudioLivro(id, titulo, autor, nomeEditora, duracao);
            } else if (tipo == 3) {
                System.out.print("Edição da Revista: ");
                int edicao = Integer.parseInt(scanner.nextLine());
                sucesso = controller.cadastrarRevista(id, titulo, autor, edicao);
            } else if (tipo == 4) {
                System.out.print("Quantidade de Faixas: ");
                int faixas = Integer.parseInt(scanner.nextLine());
                sucesso = controller.cadastrarCD(id, titulo, autor, faixas);
            }
            exibirResultado(sucesso);
        } catch (ItemDuplicadoException e) {
            System.out.println("Erro: " + e.getMessage());
            pausar();
        }
    }

    private void cadastrarJogo() {
        System.out.println("\n--- Cadastrar Jogo ---");
        System.out.print("ID do Jogo: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome do Jogo: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());

        try {
            boolean sucesso = controller.cadastrarBoardgame(id, nome, preco);
            exibirResultado(sucesso);
        } catch (ItemDuplicadoException e) {
            System.out.println("Erro: " + e.getMessage());
            pausar();
        }
    }

    private void realizarEmprestimo() {
        System.out.println("\n--- Realizar Empréstimo ---");
        System.out.print("Matrícula/ID do Usuário: ");
        String matricula = scanner.nextLine();
        System.out.print("ID do Item: ");
        int idItem = Integer.parseInt(scanner.nextLine());

        try {
            boolean sucesso = controller.registrarEmprestimo(matricula, idItem);
            exibirResultado(sucesso);
        } catch (UsuarioNaoEncontradoException | ItemNaoEmprestavelException | ItemNaoDisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
            pausar();
        }
    }

    private void realizarDevolucao() {
        System.out.println("\n--- Realizar Devolução ---");
        System.out.print("ID do Item: ");
        int idItem = Integer.parseInt(scanner.nextLine());
        System.out.print("Dias de atraso (0 se no prazo): ");
        int atraso = Integer.parseInt(scanner.nextLine());

        try {
            boolean sucesso = controller.registrarDevolucao(idItem, atraso);
            exibirResultado(sucesso);
        } catch (ItemNaoDisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
            pausar();
        }
    }

    private void venderJogo() {
        System.out.println("\n--- Venda de Jogo ---");
        System.out.print("Matrícula/ID do Usuário: ");
        String matricula = scanner.nextLine();
        System.out.print("ID do Jogo: ");
        int idJogo = Integer.parseInt(scanner.nextLine());

        try {
            boolean sucesso = controller.venderJogo(matricula, idJogo);
            exibirResultado(sucesso);
        } catch (UsuarioNaoEncontradoException | ItemNaoDisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
            pausar();
        }
    }

private void consultarItens() {
        System.out.println("Como deseja consultar os itens?");
        System.out.println("1 - Listar todos os itens");
        System.out.println("2 - Buscar por título");
        System.out.print("Escolha (1/2): ");
        String resp = scanner.nextLine();
        
        if (resp.equals("1")) {
            if (controller.listarItens().isEmpty()) System.out.println("Nenhum item cadastrado.");
            else controller.listarItens().forEach(System.out::println);
        } else if (resp.equals("2")) {
            System.out.print("Digite o título para busca: ");
            String busca = scanner.nextLine();
            List<Item> resultados = controller.buscarItemPorTitulo(busca);
            if (resultados.isEmpty()) System.out.println("Nenhum item localizado.");
            else resultados.forEach(System.out::println);
        } else {
            System.out.println("Opção inválida.");
        }
        pausar();
    }

    private void historicoEmprestimos() {
        if (controller.listarEmprestimos().isEmpty()) System.out.println("Nenhum empréstimo registrado.");
        else controller.listarEmprestimos().forEach(System.out::println);
        pausar();
    }

    private void consultarVendas() {
        if (controller.consultarVendasJogos().isEmpty()) System.out.println("Nenhuma venda registrada.");
        else controller.consultarVendasJogos().forEach(System.out::println);
        pausar();
    }

    private void exibirResultado(boolean sucesso) {
        if (sucesso) System.out.println("Operação concluída com sucesso!");
        else System.out.println("Falha na operação.");
        pausar();
    }
}


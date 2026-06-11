package br.edu.ifpb.kuatiaoka.aplicacao;

import br.edu.ifpb.kuatiaoka.modelo.*;
import br.edu.ifpb.kuatiaoka.servico.GerenciadorBiblioteca;
import java.util.*;

public class Main {
    private static GerenciadorBiblioteca sistema = new GerenciadorBiblioteca();
    private static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializa com alguns dados para a apresentação não ser vazia
        povoarDadosIniciais();
        
        int opcao = 0;
        do {
            try {
                exibirMenuPrincipal();
                opcao = leitor.nextInt();
                leitor.nextLine(); // Limpa o buffer

                switch (opcao) {
                    case 1: menuGerenciarItens(); break;
                    case 2: menuGerenciarUsuarios(); break;
                    case 3: menuOperacoes(); break;
                    case 4: menuConsultas(); break;
                    case 5: System.out.println("\nA encerrar o Projeto Sirius... Até logo!"); break;
                    default: System.out.println("\n[!] Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Erro: Digite apenas números, parceiro.");
                leitor.nextLine(); // Limpa o erro do scanner
                opcao = 0;
            }
        } while (opcao != 5);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("        PROJETO SIRIUS - BIBLIOTECA    ");
        System.out.println("========================================");
        System.out.println(" [1] Gerenciar Itens");
        System.out.println(" [2] Gerenciar Usuários");
        System.out.println(" [3] Operações (Empréstimo/Devolução)");
        System.out.println(" [4] Consultas e Históricos");
        System.out.println(" [5] Sair");
        System.out.println("========================================");
        System.out.print("Escolha uma opção: ");
    }

    private static void menuGerenciarItens() {
        System.out.println("\n--- GERENCIAR ITENS ---");
        System.out.println(" [1] Listar Acervo Completo");
        System.out.println(" [2] Cadastrar Novo Livro");
        System.out.println(" [3] Cadastrar Novo CD");
        System.out.println(" [4] Cadastrar Novo DVD");
        System.out.println(" [5] Voltar");
        System.out.print("Escolha: ");
        
        int op = leitor.nextInt(); leitor.nextLine();

        switch (op) {
            case 1:
                sistema.mostrarTudo();
                break;
            case 2:
                System.out.println("\n-- Novo Livro --");
                System.out.print("Título: "); String t = leitor.nextLine();
                System.out.print("Editora: "); String ed = leitor.nextLine();
                System.out.print("Autor: "); String au = leitor.nextLine();
                System.out.print("ISBN: "); String isbn = leitor.nextLine();
                System.out.print("Ano: "); int ano = leitor.nextInt();
                System.out.print("Edição: "); int edic = leitor.nextInt(); leitor.nextLine();
                System.out.print("Gênero: "); String gen = leitor.nextLine();
                System.out.print("Páginas: "); int pag = leitor.nextInt(); leitor.nextLine();
                System.out.print("Sinopse: "); String sin = leitor.nextLine();
                sistema.cadastrarNovoItem(new Livro(t, ed, isbn, au, ano, edic, gen, pag, sin));
                System.out.println("[!] Livro cadastrado!");
                break;
            case 3:
                System.out.println("\n-- Novo CD --");
                System.out.print("Título: "); String tc = leitor.nextLine();
                System.out.print("Editora: "); String edc = leitor.nextLine();
                System.out.print("Artista: "); String art = leitor.nextLine();
                List<String> faixas = new ArrayList<>();
                faixas.add("Faixa Bónus"); 
                sistema.cadastrarNovoItem(new CD(tc, edc, art, faixas));
                System.out.println("[!] CD cadastrado!");
                break;
            case 4:
                System.out.println("\n-- Novo DVD --");
                System.out.print("Título: "); String td = leitor.nextLine();
                System.out.print("Editora: "); String edd = leitor.nextLine();
                System.out.print("Diretor: "); String dir = leitor.nextLine();
                System.out.print("Duração (min): "); int dur = leitor.nextInt(); leitor.nextLine();
                System.out.print("Classificação: "); String cl = leitor.nextLine();
                sistema.cadastrarNovoItem(new DVD(td, edd, dir, dur, cl));
                System.out.println("[!] DVD cadastrado!");
                break;
        }
    }

    private static void menuGerenciarUsuarios() {
        System.out.println("\n--- GERENCIAR USUÁRIOS ---");
        System.out.println(" [1] Listar Todos");
        System.out.println(" [2] Novo Aluno");
        System.out.println(" [3] Novo Professor");
        System.out.println(" [4] Voltar");
        System.out.print("Escolha: ");
        
        int op = leitor.nextInt(); leitor.nextLine();
        if (op == 1) sistema.listarUsuarios();
        else if (op == 2 || op == 3) {
            System.out.print("Nome: "); String n = leitor.nextLine();
            System.out.print("Matrícula: "); String m = leitor.nextLine();
            if (op == 2) sistema.registrarPessoa(new Aluno(n, m));
            else sistema.registrarPessoa(new Professor(n, m));
            System.out.println("[!] Usuário registado!");
        }
    }

    private static void menuOperacoes() {
        System.out.println("\n--- OPERAÇÕES ---");
        System.out.println(" [1] Empréstimo");
        System.out.println(" [2] Devolução");
        System.out.print("Escolha: ");
        int op = leitor.nextInt(); leitor.nextLine();
        
        System.out.print("Matrícula do Usuário: "); String mat = leitor.nextLine();
        System.out.print("Título do Item: "); String tit = leitor.nextLine();
        
        Usuario u = sistema.buscarPorMatricula(mat);
        Item i = sistema.buscarPorTitulo(tit);
        
        if (op == 1) sistema.fazerEmprestimo(u, i);
        else sistema.devolverItem(u, i);
    }

    private static void menuConsultas() {
        System.out.println("\n--- CONSULTAS ---");
        System.out.println(" [1] Ver Histórico de Item");
        System.out.println(" [2] Buscar por Editora");
        System.out.println(" [3] Voltar");
        System.out.print("Escolha: ");
        
        int op = leitor.nextInt(); leitor.nextLine();
        if (op == 1) {
            System.out.print("Título: "); String t = leitor.nextLine();
            Item i = sistema.buscarPorTitulo(t);
            if (i != null) i.exibirHistorico();
            else System.out.println("[!] Item não encontrado.");
        } else if (op == 2) {
            System.out.print("Editora: "); String ed = leitor.nextLine();
            sistema.buscarPorEditora(ed);
        }
    }

    private static void povoarDadosIniciais() {
        sistema.registrarPessoa(new Aluno("Joao Silva", "123"));
        sistema.registrarPessoa(new Professor("Fred", "456"));
        sistema.cadastrarNovoItem(new Livro("Java POO", "ifpb", "123", "ifpb", 2026, 1, "TI", 500, "Ensinar Java"));
    }
}
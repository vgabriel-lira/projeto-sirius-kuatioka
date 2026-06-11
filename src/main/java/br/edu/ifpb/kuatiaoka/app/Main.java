package br.edu.ifpb.kuatiaoka.aplicacao;

import br.edu.ifpb.kuatiaoka.modelo.*;
import br.edu.ifpb.kuatiaoka.servico.GerenciadorBiblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorBiblioteca gerenciador = new GerenciadorBiblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- KUATIAOKA PARTE 1 (EM CAMADAS) ---");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Acervo");
            System.out.println("3. Emprestar Livro");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Título: "); String t = scanner.nextLine();
                System.out.print("Autor: "); String a = scanner.nextLine();
                System.out.print("Editora: "); String ed = scanner.nextLine();
                System.out.print("Páginas: "); int p = scanner.nextInt();
                gerenciador.cadastrarLivro(new Livro(id, t, a, ed, p));
            } else if (opcao == 2) {
                gerenciador.listarAcervo();
            } else if (opcao == 3) {
                System.out.print("ID do Livro: "); int id = scanner.nextInt();
                if (gerenciador.emprestarLivro(id)) {
                    System.out.println("Sucesso!");
                } else {
                    System.out.println("Não disponível ou não encontrado.");
                }
            }
        }
        scanner.close();
    }
}
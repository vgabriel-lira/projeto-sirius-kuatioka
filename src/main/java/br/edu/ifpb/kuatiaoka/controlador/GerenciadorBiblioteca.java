package br.edu.ifpb.kuatiaoka.servico;

import br.edu.ifpb.kuatiaoka.modelo.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorBiblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Revista> revistas = new ArrayList<>();
    private List<CD> cds = new ArrayList<>();

    public void cadastrarLivro(Livro l) { livros.add(l); }
    public void cadastrarRevista(Revista r) { revistas.add(r); }
    public void cadastrarCD(CD c) { cds.add(c); }

    public boolean emprestarLivro(int id) {
        for (Livro l : livros) {
            if (l.getId() == id && !l.isEmprestado()) {
                l.setEmprestado(true);
                return true;
            }
        }
        return false;
    }

    public boolean devolverLivro(int id) {
        for (Livro l : livros) {
            if (l.getId() == id && l.isEmprestado()) {
                l.setEmprestado(false);
                return true;
            }
        }
        return false;
    }

    public void listarAcervo() {
        System.out.println("\n--- LIVROS ---");
        for (Livro l : livros) System.out.println(l.getId() + " - " + l.getTitulo() + " (Emprestado: " + l.isEmprestado() + ")");
        System.out.println("\n--- REVISTAS ---");
        for (Revista r : revistas) System.out.println(r.getId() + " - " + r.getTitulo());
        System.out.println("\n--- CDs ---");
        for (CD c : cds) System.out.println(c.getId() + " - " + c.getTitulo());
    }
}
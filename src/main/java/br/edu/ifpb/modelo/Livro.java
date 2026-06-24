package br.edu.ifpb.modelo;

public class Livro extends Item implements Emprestavel {
    private String autor;

    public Livro(int codigo, String titulo, String autor) {
        super(codigo, titulo);
        this.autor = autor;
    }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    @Override
    public String toString() {
        String nomeEditora = (getEditora() != null) ? getEditora().getNome() : "Sem Editora";
        return "[LIVRO] ID: " + getCodigo() + " | Título: " + getTitulo() + " | Autor: " + this.autor + " | Editora: " + nomeEditora;
    }
}
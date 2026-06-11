package br.edu.ifpb.kuatiaoka.modelo;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String editora; // Na parte 1 ainda era uma String simples
    private int numeroPaginas;
    private boolean emprestado;

    public Livro(int id, String titulo, String autor, String editora, int numeroPaginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.numeroPaginas = numeroPaginas;
        this.emprestado = false;
    }

    // Getters e Setters básicos...
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getEditora() { return editora; }
    public int getNumeroPaginas() { return numeroPaginas; }
    public boolean isEmprestado() { return emprestado; }
    public void setEmprestado(boolean emprestado) { this.emprestado = emprestado; }
}

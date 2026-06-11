package br.edu.ifpb.kuatiaoka.modelo;

public class Revista {
    private int id;
    private String titulo;
    private String organizacao;
    private int numeroPaginas;
    private boolean emprestada;

    public Revista(int id, String titulo, String organizacao, int numeroPaginas) {
        this.id = id;
        this.titulo = titulo;
        this.organizacao = organizacao;
        this.numeroPaginas = numeroPaginas;
        this.emprestada = false;
    }

    // Getters e Setters básicos...
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getOrganizacao() { return organizacao; }
    public int getNumeroPaginas() { return numeroPaginas; }
    public boolean isEmprestada() { return emprestada; }
    public void setEmprestada(boolean emprestada) { this.emprestada = emprestada; }
}

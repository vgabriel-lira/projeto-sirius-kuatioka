package br.edu.ifpb.modelo;

public abstract class Item {
    private int codigo;
    private String titulo;
    private Editora editora;

    public Item(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Editora getEditora() { return editora; }
    public void setEditora(Editora editora) { this.editora = editora; }
}
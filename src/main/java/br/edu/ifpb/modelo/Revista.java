package br.edu.ifpb.modelo;

public class Revista extends Item implements Emprestavel {
    private int edicao;

    public Revista(int codigo, String titulo, int edicao) {
        super(codigo, titulo);
        this.edicao = edicao;
    }

    public int getEdicao() { return edicao; }
    public void setEdicao(int edicao) { this.edicao = edicao; }

    @Override
    public String toString() {
        return "[REVISTA] ID: " + getCodigo() + " | Título: " + getTitulo() + " | Edição: " + edicao;
    }
}
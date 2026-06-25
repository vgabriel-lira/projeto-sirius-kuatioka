package br.edu.ifpb.modelo;

public class LivroFisico extends Livro {
    private int paginas;

    public LivroFisico(int codigo, String titulo, String autor, int paginas) {
        super(codigo, titulo, autor);
        this.paginas = paginas;
    }

    public int getPaginas() { return this.paginas; }
    public void setPaginas(int paginas) { this.paginas = paginas; }
}
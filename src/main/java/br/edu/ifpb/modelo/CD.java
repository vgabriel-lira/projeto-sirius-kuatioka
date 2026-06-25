package br.edu.ifpb.modelo;

public class CD extends Item {
    private String artista;
    private int quantidadeFaixas;

    public CD(int codigo, String titulo, String artista, int quantidadeFaixas) {
        super(codigo, titulo);
        this.artista = artista;
        this.quantidadeFaixas = quantidadeFaixas;
    }

    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }

    public int getQuantidadeFaixas() { return quantidadeFaixas; }
    public void setQuantidadeFaixas(int quantidadeFaixas) { this.quantidadeFaixas = quantidadeFaixas; }

    @Override
    public String toString() {
        return "[CD] ID: " + getCodigo() + " | Título: " + getTitulo() + " | Artista: " + artista + " | Faixas: " + quantidadeFaixas;
    }
}
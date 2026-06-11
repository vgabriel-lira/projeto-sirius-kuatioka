package br.edu.ifpb.kuatiaoka.modelo;

public class CD {
    private int id;
    private String titulo;
    private String artista;
    private int numeroFaixas;

    public CD(int id, String titulo, String artista, int numeroFaixas) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.numeroFaixas = numeroFaixas;
    }

    // Getters básicos...
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public int getNumeroFaixas() { return numeroFaixas; }
}
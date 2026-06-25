package br.edu.ifpb.modelo;

public class JogoTabuleiro {
    private int codigo;
    private String titulo;
    private int qtdJogadores;
    private String estilo;
    private double preco;

    public JogoTabuleiro(int codigo, String titulo, int qtdJogadores, String estilo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.qtdJogadores = qtdJogadores;
        this.estilo = estilo;
        this.preco = 0.0; // Inicializado por padrão
    }

    // Getters e Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getQtdJogadores() { return qtdJogadores; }
    public void setQtdJogadores(int qtdJogadores) { this.qtdJogadores = qtdJogadores; }

    public String getEstilo() { return estilo; }
    public void setEstilo(String estilo) { this.estilo = estilo; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    // Método toString para a listagem funcionar corretamente no UC09/UC11
    @Override
    public String toString() {
        return "[JOGO] ID: " + codigo + 
               " | Título: " + titulo + 
               " | Jogadores: " + qtdJogadores + 
               " | Estilo: " + estilo;
    }
}
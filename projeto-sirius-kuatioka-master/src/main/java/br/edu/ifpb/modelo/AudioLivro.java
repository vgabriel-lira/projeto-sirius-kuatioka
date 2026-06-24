package br.edu.ifpb.modelo;

public class AudioLivro extends Livro {
    private double duracaoHoras;
    private String formatoAudio;

    public AudioLivro(int codigo, String titulo, String autor, double duracaoHoras, String formatoAudio) {
        super(codigo, titulo, autor);
        this.duracaoHoras = duracaoHoras;
        this.formatoAudio = formatoAudio;
    }

    public double getDuracaoHoras() { return duracaoHoras; }
    public void setDuracaoHoras(double duracaoHoras) { this.duracaoHoras = duracaoHoras; }

    public String getFormatoAudio() { return formatoAudio; }
    public void setFormatoAudio(String formatoAudio) { this.formatoAudio = formatoAudio; }
}
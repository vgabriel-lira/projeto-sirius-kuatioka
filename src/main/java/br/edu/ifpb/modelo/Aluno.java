package br.edu.ifpb.modelo;

public class Aluno extends Usuario {
    private String matricula;

    public Aluno(int id, String nome, String email, String telefone, String endereco, String matricula) {
        super(id, nome, email, telefone, endereco);
        this.matricula = matricula;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
}
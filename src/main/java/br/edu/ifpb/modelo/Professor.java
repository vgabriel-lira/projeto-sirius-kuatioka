package br.edu.ifpb.modelo;

public class Professor extends Usuario {
    private String departmento;

    public Professor(int id, String nome, String email, String telefone, String endereco, String departamento) {
        super(id, nome, email, telefone, endereco);
        this.departmento = departamento;
    }

    public String getDepartamento() { return departmento; }
    public void setDepartamento(String departamento) { this.departmento = departamento; }
}
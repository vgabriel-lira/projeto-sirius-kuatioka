package br.edu.ifpb.modelo;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    public Usuario(int id, String nome, String email, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getId() { return this.id; }
    public String getNome() { return this.nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }
}
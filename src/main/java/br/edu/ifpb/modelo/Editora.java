package br.edu.ifpb.modelo;

public class Editora {
    private String nome;
    private String cnpj;

    public Editora(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() { 
        return nome; 
    }
    
    public String getCnpj() { 
        return cnpj; 
    }

    @Override
    public String toString() {
        return "Editora: " + nome + " | CNPJ: " + cnpj;
    }
}
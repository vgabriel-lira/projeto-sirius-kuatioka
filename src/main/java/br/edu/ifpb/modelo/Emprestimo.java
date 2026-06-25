package br.edu.ifpb.modelo;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Item item;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(Usuario usuario, Item item) {
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = LocalDate.now();
        this.ativo = true;
    }

    public Usuario getUsuario() { return usuario; }
    public Item getItem() { return item; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    @Override
    public String toString() {
        String status = ativo ? "ATIVO" : "DEVOLVIDO em " + dataDevolucao;
        return "Empréstimo -> Usuário: " + usuario.getNome() + " | Item: " + item.getTitulo() + " | Status: " + status;
    }
}
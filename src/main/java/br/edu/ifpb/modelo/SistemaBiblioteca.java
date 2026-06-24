package br.edu.ifpb.modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {
    private List<Usuario> usuarios;
    private List<Item> itens;
    private List<Emprestimo> emprestimos;
    private List<JogoTabuleiro> jogos;
    private List<String> vendasJogos; // esse p guardar o histórico das vendas formatado

    public SistemaBiblioteca() {
        this.usuarios = new ArrayList<>();
        this.itens = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.jogos = new ArrayList<>();
        this.vendasJogos = new ArrayList<>();
    }

    // aqui é os métodos p adicionar
    public void adicionarUsuario(Usuario u) { usuarios.add(u); }
    public void adicionarItem(Item i) { itens.add(i); }
    public void adicionarEmprestimo(Emprestimo e) { emprestimos.add(e); }
    public void adicionarJogo(JogoTabuleiro j) { jogos.add(j); }
    public void registrarVenda(String relatorioVenda) { vendasJogos.add(relatorioVenda); }

    // getters das listas pra as buscas do controlador
    public List<Usuario> getUsuarios() { return usuarios; }
    public List<Item> getItens() { return itens; }
    public List<Emprestimo> getEmprestimos() { return emprestimos; }
    public List<JogoTabuleiro> getJogos() { return jogos; }
    public List<String> getVendasJogos() { return vendasJogos; }
}
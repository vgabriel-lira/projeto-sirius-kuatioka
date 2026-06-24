package br.edu.ifpb.controlador;

import br.edu.ifpb.modelo.*;
import br.edu.ifpb.excecao.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
    private SistemaBiblioteca sistema;
    private List<Editora> editoras; 

    public BibliotecaController(SistemaBiblioteca sistema) {
        this.sistema = sistema;
        this.editoras = new ArrayList<>();
    }

    public boolean cadastrarUsuario(int tipo, String nome, String matricula) throws UsuarioDuplicadoException {
        for (Usuario u : sistema.getUsuarios()) {
            if (u instanceof Aluno && ((Aluno) u).getMatricula().equals(matricula)) {
                throw new UsuarioDuplicadoException("Já existe um usuário cadastrado com a matrícula: " + matricula);
            }
        }
        
        Usuario novo;
        int proximoId = sistema.getUsuarios().size() + 1;
        if (tipo == 1) {
            novo = new Aluno(proximoId, nome, "aluno@ifpb.edu.br", "8399999", "IFPB", matricula);
        } else {
            novo = new Professor(proximoId, nome, "prof@ifpb.edu.br", "8398888", "IFPB", "Tecnologia");
        }
        sistema.adicionarUsuario(novo);
        return true;
    }

    public boolean cadastrarEditora(String nome, String cnpj) {
        Editora ed = new Editora(nome, cnpj);
        editoras.add(ed);
        return true;
    }

    public boolean cadastrarAutor(int id, String nome, String biografia) {
        return true;
    }

    public boolean cadastrarLivroFisico(int id, String titulo, String autor, String nomeEditora, int paginas) throws ItemDuplicadoException {
        validarIdItemUnico(id);
        LivroFisico livro = new LivroFisico(id, titulo, autor, paginas);
        livro.setEditora(new Editora(nomeEditora, "N/A"));
        sistema.adicionarItem(livro);
        return true;
    }

    public boolean cadastrarAudioLivro(int id, String titulo, String autor, String nomeEditora, int duracao) throws ItemDuplicadoException {
        validarIdItemUnico(id);
        AudioLivro audio = new AudioLivro(id, titulo, autor, duracao / 60.0, "MP3");
        audio.setEditora(new Editora(nomeEditora, "N/A"));
        sistema.adicionarItem(audio);
        return true;
    }

    public boolean cadastrarRevista(int id, String titulo, String autor, int edicao) throws ItemDuplicadoException {
        validarIdItemUnico(id);
        Revista revista = new Revista(id, titulo, edicao);
        sistema.adicionarItem(revista);
        return true;
    }

    public boolean cadastrarCD(int id, String titulo, String autor, int faixas) throws ItemDuplicadoException {
        validarIdItemUnico(id);
        CD cd = new CD(id, titulo, autor, faixas);
        sistema.adicionarItem(cd);
        return true;
    }

    public boolean cadastrarBoardgame(int id, String nome, double preco) throws ItemDuplicadoException {
        for (JogoTabuleiro j : sistema.getJogos()) {
            if (j.getCodigo() == id) {
                throw new ItemDuplicadoException("Já existe um jogo de tabuleiro com o ID: " + id);
            }
        }
        JogoTabuleiro jogo = new JogoTabuleiro(id, nome, 4, "Estratégia");
        jogo.setPreco(preco);
        sistema.adicionarJogo(jogo);
        return true;
    }

    public boolean registrarEmprestimo(String matricula, int idItem) throws UsuarioNaoEncontradoException, ItemNaoEmprestavelException, ItemNaoDisponivelException {
        Usuario usuario = buscarUsuarioPorMatricula(matricula);
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException("Nenhum usuário localizado com a matrícula: " + matricula);
        }

        Item item = buscarItemPorId(idItem);
        if (item == null) {
            throw new ItemNaoDisponivelException("Item com ID " + idItem + " não foi encontrado no acervo.");
        }

        if (!(item instanceof Emprestavel)) {
            throw new ItemNaoEmprestavelException("O item '" + item.getTitulo() + "' não permite empréstimos (Ex: CDs).");
        }

        for (Emprestimo emp : sistema.getEmprestimos()) {
            if (emp.getItem().getCodigo() == idItem && emp.isAtivo()) {
                throw new ItemNaoDisponivelException("O item '" + item.getTitulo() + "' já se encontra emprestado.");
            }
        }

        Emprestimo novoEmprestimo = new Emprestimo(usuario, item);
        sistema.adicionarEmprestimo(novoEmprestimo);
        return true;
    }

    public boolean registrarDevolucao(int idItem, int diasAtraso) throws ItemNaoDisponivelException {
        for (Emprestimo emp : sistema.getEmprestimos()) {
            if (emp.getItem().getCodigo() == idItem && emp.isAtivo()) {
                emp.setAtivo(false);
                emp.setDataDevolucao(LocalDate.now());
                if (diasAtraso > 0) {
                    double multa = diasAtraso * 2.50; 
                    System.out.println("⚠️ Item entregue com atraso! Multa calculada: R$ " + multa);
                }
                return true;
            }
        }
        throw new ItemNaoDisponivelException("Não foi encontrado nenhum empréstimo ativo para o item de ID: " + idItem);
    }

    public boolean venderJogo(String matricula, int idJogo) throws UsuarioNaoEncontradoException, ItemNaoDisponivelException {
        Usuario usuario = buscarUsuarioPorMatricula(matricula);
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException("Matrícula de comprador inválida.");
        }

        JogoTabuleiro jogoProcurado = null;
        for (JogoTabuleiro j : sistema.getJogos()) {
            if (j.getCodigo() == idJogo) {
                jogoProcurado = j;
                break;
            }
        }

        if (jogoProcurado == null) {
            throw new ItemNaoDisponivelException("Jogo de tabuleiro não cadastrado.");
        }

        String recibo = "Venda -> Comprador: " + usuario.getNome() + " | Jogo: " + jogoProcurado.getTitulo() + " | Valor: R$ " + jogoProcurado.getPreco();
        sistema.registrarVenda(recibo);
        return true;
    }

    public List<Item> listarItens() { return sistema.getItens(); }
    public List<Emprestimo> listarEmprestimos() { return sistema.getEmprestimos(); }
    public List<String> consultarVendasJogos() { return sistema.getVendasJogos(); }

    public List<Item> buscarItemPorTitulo(String titulo) {
        List<Item> filtrados = new ArrayList<>();
        for (Item i : sistema.getItens()) {
            if (i.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                filtrados.add(i);
            }
        }
        return filtrados;
    }

    private Usuario buscarUsuarioPorMatricula(String matricula) {
        for (Usuario u : sistema.getUsuarios()) {
            if (u instanceof Aluno && ((Aluno) u).getMatricula().equals(matricula)) {
                return u;
            }
        }
        try {
            int id = Integer.parseInt(matricula);
            for (Usuario u : sistema.getUsuarios()) {
                if (u.getId() == id) return u;
            }
        } catch (NumberFormatException e) { }
        return null;
    }

    private Item buscarItemPorId(int id) {
        for (Item i : sistema.getItens()) {
            if (i.getCodigo() == id) return i;
        }
        return null;
    }

    private void validarIdItemUnico(int id) throws ItemDuplicadoException {
        if (buscarItemPorId(id) != null) {
            throw new ItemDuplicadoException("Já existe um item cadastrado com o ID: " + id);
        }
    }
}

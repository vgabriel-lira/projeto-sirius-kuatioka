package br.edu.ifpb.excecao;

public class UsuarioDuplicadoException extends Exception {
    public UsuarioDuplicadoException(String mensagem) {
        super(mensagem);
    }
}
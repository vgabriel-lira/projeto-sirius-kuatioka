package br.edu.ifpb.excecao;

public class ItemNaoEmprestavelException extends Exception {
    public ItemNaoEmprestavelException(String mensagem) {
        super(mensagem);
    }
}
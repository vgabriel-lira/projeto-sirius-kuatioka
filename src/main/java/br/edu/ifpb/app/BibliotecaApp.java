package br.edu.ifpb.app;

import br.edu.ifpb.controlador.BibliotecaController;
import br.edu.ifpb.modelo.SistemaBiblioteca;
import br.edu.ifpb.ui.BibliotecaView;

public class BibliotecaApp {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        
        BibliotecaController controller = new BibliotecaController(sistema);
        
        BibliotecaView view = new BibliotecaView(controller);
        
        view.iniciar();
    }
}
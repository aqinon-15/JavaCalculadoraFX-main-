package org.andresaquino.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.andresaquino.view.CalculadoraView; // Importación corregida con punto

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        // Instanciamos la vista
        CalculadoraView calculadora = new CalculadoraView();

        // Escena con la vista de la calculadora
        Scene escena = new Scene(calculadora.getView(), 280, 360);

        // Configuración de la ventana principal
        escenarioPrincipal.setTitle("Calculadora de Andres");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.setResizable(false);
        escenarioPrincipal.show();
    }
}
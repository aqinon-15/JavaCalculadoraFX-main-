package org.andresaquino.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.andresaquino.view.CalculadoraView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        CalculadoraView calculadora = new CalculadoraView();

        Scene escena = new Scene(calculadora.getView(), 280, 410);

        escenarioPrincipal.setTitle("Calculadora de Andres");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.setResizable(false);
        escenarioPrincipal.show();
    }
}
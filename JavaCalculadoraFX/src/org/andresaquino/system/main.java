package org.andresaquino.system;

import JavaCalculadoraFX [main].application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
 public class main extends Application{

   public static void main(String[] args) {

        System.out.println("hola mundo");
        launch(args);

    }

    private static void launch(args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {

       //nodos
        VBox raiz = new VBox();
        //escena
        Scene escena = new Scene(raiz, 300, 400);
        //cargar escena y mostrar escenario principal
        escenarioPrincipal.setTitle("Caliculadora de Andres");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();

    }

}
 
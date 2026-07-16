package org.andresaquino.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CalculadoraView {

    private final VBox view;
    private final Label pantalla;
    private final GridPane cuadroBotones;

    public CalculadoraView() {
        view = new VBox(15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);

        // Fondo gris oscuro para la vista principal
        view.setStyle("-fx-background-color: #2B2B2B;");

        // Pantalla de la calculadora
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(235, 50);
        pantalla.setStyle("-fx-background-color: #3C3F41; -fx-text-fill: #FFFFFF; -fx-padding: 5px; -fx-background-radius: 5px;");

        // Cuadrícula de botones
        cuadroBotones = new GridPane();
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);

        // Creación de botones
        Button btnCero = new Button("0");
        Button btnUno = new Button("1");
        Button btnDos = new Button("2");
        Button btnTres = new Button("3");
        Button btnCuatro = new Button("4");
        Button btnCinco = new Button("5");
        Button btnSeis = new Button("6");
        Button btnSiete = new Button("7");
        Button btnOcho = new Button("8");
        Button btnNueve = new Button("9");

        Button btnMas = new Button("+");
        Button btnMenos = new Button("-");
        Button btnPor = new Button("*");

        // Aplicar estilos
        estilarBoton(btnCero, "#555555", "#3C3C3C");
        estilarBoton(btnUno, "#555555", "#3C3C3C");
        estilarBoton(btnDos, "#555555", "#3C3C3C");
        estilarBoton(btnTres, "#555555", "#3C3C3C");
        estilarBoton(btnCuatro, "#555555", "#3C3C3C");
        estilarBoton(btnCinco, "#555555", "#3C3C3C");
        estilarBoton(btnSeis, "#555555", "#3C3C3C");
        estilarBoton(btnSiete, "#555555", "#3C3C3C");
        estilarBoton(btnOcho, "#555555", "#3C3C3C");
        estilarBoton(btnNueve, "#555555", "#3C3C3C");

        estilarBoton(btnMas, "#777777", "#4A4A4A");
        estilarBoton(btnMenos, "#777777", "#4A4A4A");
        estilarBoton(btnPor, "#777777", "#4A4A4A");

        // Ubicación en la cuadrícula
        cuadroBotones.add(btnSiete, 0, 1);
        cuadroBotones.add(btnOcho, 1, 1);
        cuadroBotones.add(btnNueve, 2, 1);
        cuadroBotones.add(btnPor, 3, 1);

        cuadroBotones.add(btnCuatro, 0, 2);
        cuadroBotones.add(btnCinco, 1, 2);
        cuadroBotones.add(btnSeis, 2, 2);
        cuadroBotones.add(btnMenos, 3, 2);

        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMas, 3, 3);

        cuadroBotones.add(btnCero, 0, 4);

        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    private void estilarBoton(Button btn, String colorNormal, String colorPresionado) {
        btn.setPrefSize(50, 50);
        btn.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));

        String estiloBase = "-fx-text-fill: white; -fx-background-radius: 5px; -fx-cursor: hand; -fx-background-color: ";

        btn.setStyle(estiloBase + colorNormal + ";");

        btn.setOnMousePressed(e -> {
            btn.setStyle(estiloBase + colorPresionado + ";");
            btn.setTranslateY(2);
        });

        btn.setOnMouseReleased(e -> {
            btn.setStyle(estiloBase + colorNormal + ";");
            btn.setTranslateY(0);
        });
    }

    public VBox getView() {
        return view;
    }
}
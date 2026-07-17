package org.andresaquino.view;

import org.andresaquino.controller.CalculadoraController;
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
    private final CalculadoraController controlador; // 1. Referencia al controlador

    public CalculadoraView() {
        controlador = new CalculadoraController(); // Inicializamos el controlador

        view = new VBox(15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
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

        // Creación de botones numéricos
        Button btnCero = crearBoton("0", "#555555", "#3C3C3C");
        Button btnUno = crearBoton("1", "#555555", "#3C3C3C");
        Button btnDos = crearBoton("2", "#555555", "#3C3C3C");
        Button btnTres = crearBoton("3", "#555555", "#3C3C3C");
        Button btnCuatro = crearBoton("4", "#555555", "#3C3C3C");
        Button btnCinco = crearBoton("5", "#555555", "#3C3C3C");
        Button btnSeis = crearBoton("6", "#555555", "#3C3C3C");
        Button btnSiete = crearBoton("7", "#555555", "#3C3C3C");
        Button btnOcho = crearBoton("8", "#555555", "#3C3C3C");
        Button btnNueve = crearBoton("9", "#555555", "#3C3C3C");
        Button btnPunto = crearBoton(".", "#555555", "#3C3C3C");

        // Creación de botones de operación
        Button btnMas = crearBoton("+", "#777777", "#4A4A4A");
        Button btnMenos = crearBoton("-", "#777777", "#4A4A4A");
        Button btnPor = crearBoton("*", "#777777", "#4A4A4A");
        Button btnDiv = crearBoton("/", "#777777", "#4A4A4A");
        Button btnClear = crearBoton("C", "#D9534F", "#C9302C"); // Rojo para Limpiar
        Button btnIgual = crearBoton("=", "#5CB85C", "#4CAE4C"); // Verde para Igual

        // --- Ubicación en la cuadrícula (Columna, Fila) ---
        // Fila 0: Limpiar y División
        cuadroBotones.add(btnClear, 0, 0);
        cuadroBotones.add(btnDiv, 3, 0);

        // Fila 1: 7, 8, 9, *
        cuadroBotones.add(btnSiete, 0, 1);
        cuadroBotones.add(btnOcho, 1, 1);
        cuadroBotones.add(btnNueve, 2, 1);
        cuadroBotones.add(btnPor, 3, 1);

        // Fila 2: 4, 5, 6, -
        cuadroBotones.add(btnCuatro, 0, 2);
        cuadroBotones.add(btnCinco, 1, 2);
        cuadroBotones.add(btnSeis, 2, 2);
        cuadroBotones.add(btnMenos, 3, 2);

        // Fila 3: 1, 2, 3, +
        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMas, 3, 3);

        // Fila 4: 0, ., = (el = ocupa 2 columnas)
        cuadroBotones.add(btnCero, 0, 4);
        cuadroBotones.add(btnPunto, 1, 4);
        cuadroBotones.add(btnIgual, 2, 4, 2, 1);
        btnIgual.setPrefSize(112, 50); // Ajuste de tamaño para abarcar 2 espacios

        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    // Método auxiliar para crear, estilar y conectar los botones
    private Button crearBoton(String texto, String colorNormal, String colorPresionado) {
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setFont(Font.font("Consolas", FontWeight.BOLD, 20));

        String estiloBase = "-fx-text-fill: white; -fx-background-radius: 5px; -fx-cursor: hand; -fx-background-color: ";
        btn.setStyle(estiloBase + colorNormal + ";");

        // Animación al presionar
        btn.setOnMousePressed(e -> {
            btn.setStyle(estiloBase + colorPresionado + ";");
            btn.setTranslateY(2);
        });

        btn.setOnMouseReleased(e -> {
            btn.setStyle(estiloBase + colorNormal + ";");
            btn.setTranslateY(0);
        });

        // 2. CONEXIÓN CLAVE: Enviar el clic del botón al controlador
        btn.setOnAction(e -> controlador.procesoDeEntrada(texto, pantalla));

        return btn;
    }

    public VBox getView() {
        return view;
    }
}
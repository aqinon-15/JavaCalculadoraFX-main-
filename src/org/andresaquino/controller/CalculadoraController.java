package org.andresaquino.controller;

import javafx.scene.control.Label;

public class CalculadoraController {

    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = false;

    public CalculadoraController() {

    }

    public void procesoDeEntrada(String entrada, Label pantalla) {
        // Botón de Limpiar (C)
        if (entrada.equals("C")) {
            resetear();
            pantalla.setText("0");
            return;
        }

        // Si se acaba de presionar '=' y el usuario presiona un número o punto, se inicia una nueva operación
        if (calculoTerminado && (entrada.matches("[0-9]") || entrada.equals("."))) {
            resetear();
        }
        calculoTerminado = false;

        // Manejo de Números y Punto Decimal
        if (entrada.matches("[0-9]") || entrada.equals(".")) {
            if (operador.isEmpty()) {
                // Evitamos colocar dos puntos decimales en el mismo número
                if (entrada.equals(".") && opcion1.contains(".")) return;
                opcion1 += entrada;
            } else {
                if (entrada.equals(".") && opcion2.contains(".")) return;
                opcion2 += entrada;
            }
            actualizarPantalla(pantalla);
        } 
        // Manejo de Operadores (+, -, *, /)
        else if (entrada.matches("[+\\-*/]")) {
            if (!opcion1.isEmpty()) {
                // Permite encadenar operaciones (ejemplo: 5 + 3 * 2)
                if (!opcion2.isEmpty()) {
                    opcion1 = calcularResultado();
                    opcion2 = "";
                }
                operador = entrada;
                actualizarPantalla(pantalla);
            }
        } 
        // Manejo del Botón Igual (=)
        else if (entrada.equals("=")) {
            if (!opcion1.isEmpty() && !operador.isEmpty() && !opcion2.isEmpty()) {
                opcion1 = calcularResultado();
                operador = "";
                opcion2 = "";
                calculoTerminado = true;
                actualizarPantalla(pantalla);
            }
        }
    }

    private void actualizarPantalla(Label pantalla) {
        if (opcion1.isEmpty()) {
            pantalla.setText("0");
        } else if (operador.isEmpty()) {
            pantalla.setText(opcion1);
        } else {
            pantalla.setText(opcion1 + " " + operador + " " + opcion2);
        }
    }

    private String calcularResultado() {
        try {
            double datoUno = Double.parseDouble(opcion1);
            double datoDos = Double.parseDouble(opcion2);
            double resultado = 0;

            switch (operador) {
                case "+": resultado = datoUno + datoDos; break;
                case "-": resultado = datoUno - datoDos; break;
                case "*": resultado = datoUno * datoDos; break;
                case "/": 
                    if (datoDos == 0) return "Error"; // Validación de división por cero
                    resultado = datoUno / datoDos; 
                    break;
            }

            // Si el resultado no tiene decimales (ej. 10.0), lo formateamos como entero (10)
            if (resultado % 1 == 0) {
                return String.valueOf((long) resultado);
            } else {
                return String.valueOf(resultado);
            }
        } catch (NumberFormatException e) {
            return "Error";
        }
    }

    private void resetear() {
        opcion1 = "";
        operador = "";
        opcion2 = "";
        calculoTerminado = false;
    }
}

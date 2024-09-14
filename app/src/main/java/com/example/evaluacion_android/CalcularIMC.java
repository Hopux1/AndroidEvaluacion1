package com.example.evaluacion_android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalcularIMC extends AppCompatActivity {

    // Elementos de la interfaz de usuario
    private EditText weightInput;
    private EditText heightInput;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcular_imc);  // Es para asociar el layout con la actividad

        // Inicializar los elementos de la interfaz de usuario
        weightInput = findViewById(R.id.weight_input);
        heightInput = findViewById(R.id.height_input);
        calculateButton = findViewById(R.id.calculate_button);
        resultText = findViewById(R.id.result_text);

        // Asignar la acción de click al botón para calcular
        calculateButton.setOnClickListener(view -> {
            calculateIMC();  // Llamar al método que calcula el IMC cuando se presiona el botón
        });
    }

    // Método para calcular el IMC
    private void calculateIMC() {
        // Obtener los valores ingresados por el usuario como cadenas de texto
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();

        // Verificar si los campos de peso y altura no están vacíos
        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            // Convertir las cadenas de texto a números decimales (double)
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);

            // Calcular el IMC usando la fórmula: peso / (altura * altura)
            double imc = weight / (height * height);

            // Obtener la clasificación del IMC
            String classification = classifyIMC(imc);

            // Mostrar el resultado del IMC y la clasificación en el campo de texto
            resultText.setText("IMC: " + String.format("%.2f", imc) + " - " + classification);
        } else {
            // Mostrar un mensaje si los campos están vacíos
            resultText.setText("Por favor, ingrese peso y altura válidos.");
        }
    }

    // Método para clasificar el IMC en diferentes categorías
    private String classifyIMC(double imc) {
        // Devolver la categoría basada en el valor del IMC
        if (imc < 18.5) {
            return "Bajo peso";  // IMC menor de 18.5
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Saludable";  // IMC entre 18.5 y 24.9
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";  // IMC entre 25 y 29.9
        } else {
            return "Obesidad";   // IMC mayor o igual a 30
        }
    }
}

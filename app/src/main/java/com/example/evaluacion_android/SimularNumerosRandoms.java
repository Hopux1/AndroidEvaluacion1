package com.example.evaluacion_android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class SimularNumerosRandoms extends AppCompatActivity {

    // Elementos de la interfaz de usuario
    private EditText minInput;
    private EditText maxInput;
    private Button generateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simular_randoms);  // Asociar el layout con la actividad

        // Inicializar los elementos de la interfaz de usuario
        minInput = findViewById(R.id.min_input);
        maxInput = findViewById(R.id.max_input);
        generateButton = findViewById(R.id.generate_button);
        resultText = findViewById(R.id.result_text);

        // Configurar el botón para generar un número aleatorio
        generateButton.setOnClickListener(view -> {
            generateRandomNumber();  // Llamada al método para generar el número aleatorio
        });
    }

    // Método que genera un número aleatorio en el rango que se le especifica
    private void generateRandomNumber() {
        // Obtener los valores ingresados como cadenas de texto
        String minStr = minInput.getText().toString();
        String maxStr = maxInput.getText().toString();

        // Verifica si los campos no están vacíos
        if (!minStr.isEmpty() && !maxStr.isEmpty()) {
            // Convierte las cadenas de texto en números enteros
            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);

            // Verifica que el valor mínimo sea menor que el máximo
            if (min < max) {
                // Genera un número aleatorio dentro del rango [min, max]
                Random random = new Random();
                int randomNumber = random.nextInt(max - min + 1) + min;

                // Muestra el número aleatorio generado en el campo de texto
                resultText.setText("Número aleatorio: " + randomNumber);
            } else {
                // Muiestra un mensaje de error si el mínimo no es menor que el máximo
                resultText.setText("El valor mínimo debe ser menor que el valor máximo.");
            }
        } else {
            // Muestra un mensaje de error si los campos están vacíos
            resultText.setText("Por favor, ingrese valores válidos.");
        }
    }
}

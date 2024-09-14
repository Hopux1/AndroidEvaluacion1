package com.example.evaluacion_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declaración de los botones
    private Button imcButton;           // Botón para ir al activity de Calcular IMC
    private Button randomNumberButton;  // Botón para ir al activity de Simular Números Aleatorios

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Es para asociar el layout de la actividad principal

        // Inicializar los botones del layout
        imcButton = findViewById(R.id.imc_button);
        randomNumberButton = findViewById(R.id.random_number_button);

        // Configurar el botón para ir a la actividad CalcularIMC
        imcButton.setOnClickListener(view -> {
            // Crear un Intent para cambiar de MainActivity a CalcularIMC
            Intent intent = new Intent(MainActivity.this, CalcularIMC.class);
            startActivity(intent);  // Iniciar la nueva actividad
        });

        // Configurar el botón para ir al activity de SimularRandoms
        randomNumberButton.setOnClickListener(view -> {
            // Crear un Intent para cambiar de MainActivity a SimularRandoms
            Intent intent = new Intent(MainActivity.this, SimularNumerosRandoms.class);
            startActivity(intent);  // Iniciar la nueva actividad
        });
    }
}

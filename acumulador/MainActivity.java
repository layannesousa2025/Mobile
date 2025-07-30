package com.example.acumulador;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView resultado;
    Button btAmentar,brReduzir;

   int acumulador =0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultado = findViewById(R.id.resultado);
        btAmentar = findViewById(R.id.btAumenta);
        brReduzir = findViewById(R.id.btReduzir);

        btAmentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acumulador = acumulador +10;
                resultado.setText("resultado: "+acumulador);
            }
        });
        brReduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acumulador = acumulador -10;
                resultado.setText("resultado: "+acumulador);
            }
        });




    }
}
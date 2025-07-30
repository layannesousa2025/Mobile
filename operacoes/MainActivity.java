package com.example.operacoes;

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
    EditText numero1,numero2;
    Button btSoma,btDiv,btMult,btSub;
    TextView resultado;

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

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        resultado = findViewById(R.id.resultado);
        btDiv =findViewById(R. id.btDiv);
        btMult = findViewById(R.id.btMult);
        btSoma = findViewById(R.id.btSoma);
        btSub = findViewById(R.id.btSub);

        btMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(numero1.getText().toString());
                double num2 = Double.parseDouble(numero2.getText().toString());
                double mult = num1*num2;
                resultado.setText("resultado: "+mult);
                numero1.setText(null);
                numero2.setText(null);
            }


        });

         numero1 = findViewById(R.id.numero1);
         numero2 = findViewById(R.id.numero2);
         resultado = findViewById(R.id.resultado);
         btDiv = findViewById(R.id.btDiv);
         btMult = findViewById(R.id.btMult);
         btSoma = findViewById(R.id.btSoma);
         btSub = findViewById(R.id.btSub);

         btSoma.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 double num1 = Double.parseDouble(numero1.getText().toString());
                 double num2 = Double.parseDouble(numero2.getText().toString());
                 double soma = num1+num2;
                 resultado.setText("resultado: "+soma);
                 numero1.setText(null);
                 numero2.setText(null);
             }
         });

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        resultado = findViewById(R.id.resultado);
        btDiv = findViewById(R.id.btDiv);
        btMult = findViewById(R.id.btMult);
        btSoma = findViewById(R.id.btSoma);
        btSub = findViewById(R.id.btSub);

        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(numero1.getText().toString());
                double num2 = Double.parseDouble(numero2.getText().toString());
                double sub = num1-num2;
                resultado.setText("resultado: "+sub);
                numero1.setText(null);
                numero2.setText(null);
            }
        });

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        resultado = findViewById(R.id.resultado);
        btDiv = findViewById(R.id.btDiv);
        btMult = findViewById(R.id.btMult);
        btSoma = findViewById(R.id.btSoma);
        btSub = findViewById(R.id.btSub);

        btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(numero1.getText().toString());
                double num2 = Double.parseDouble(numero2.getText().toString());
                double div = num1/num2;
                resultado.setText("resultado: "+div);
                numero1.setText(null);
                numero2.setText(null);
            }
        });

    }
}
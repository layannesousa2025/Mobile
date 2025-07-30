package com.example.exeraquete;

import static android.widget.Toast.LENGTH_LONG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText bateria,statusLigado,statusBateria,statusUltilizado;
    Button btCarregar,btUsar,btLigar;
     int acumulador = 0;


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

        bateria = findViewById(R.id.bateria);
        statusLigado = findViewById(R.id.statusLigado);
        statusBateria = findViewById(R.id.statusBateria);
        statusUltilizado = findViewById(R. id.statusUltilizado);
        btCarregar = findViewById(R.id.btCarregar);
        btUsar = findViewById(R.id.btUsar);
        btLigar = findViewById(R.id.btLigar);

        bateria.setEnabled(false);
        statusLigado.setEnabled(false);
        statusUltilizado.setEnabled(false);
        statusBateria.setEnabled(false);


        btCarregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acumulador = 100;
                bateria.setText(acumulador+ "%");
                statusBateria.setText(acumulador+ "%");


            }
        });

        btUsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (statusLigado.getText().toString().equals("ligado")&&acumulador>0){
                    acumulador =acumulador -10;
                    bateria.setText(acumulador+ "%");
                    statusBateria.setText(acumulador+ "%");
                    statusUltilizado.setText(acumulador+ "%");

                }else{
                    statusLigado.setText("desligado");
                    btLigar.setText("ligar");
                    statusUltilizado.setText("nao utiliado");
                    Toast.makeText(getApplication(),"voce precisa carregar e ligar a raquete",LENGTH_LONG).show();
                }

            }
        });

        btLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (acumulador > 0 && statusLigado.getText().toString().equals("desligado")){
                  statusLigado.setText("ligado");
                  btLigar.setText("desligador");
              }else {
                  Toast.makeText(getApplication(),"Sem Carga",LENGTH_LONG).show();
              }


            }
        });



    }
}
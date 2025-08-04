package com.example.exepostogasolina;

import static android.widget.Toast.LENGTH_LONG;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
 Button btcalcular;
 EditText statusGasolina,statusEtanol;

 MultiAutoCompleteTextView resultado;

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

          btcalcular = findViewById(R.id.btCalcular);
          statusGasolina = findViewById(R.id.statusGasolina);
          statusEtanol = findViewById(R.id.statusEtanol);
          resultado = findViewById(R.id.resultado);

        resultado.setEnabled(false);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double gasolina = Double.parseDouble(statusGasolina.getText().toString());
                double etanol = Double.parseDouble(statusEtanol.getText().toString());
                double preco = etanol/gasolina;
                DecimalFormat formatPreco = new DecimalFormat("###,##0.00");
                resultado.setText(resultado.getText()+"O valor do resultado: "+formatPreco.format((preco)));

                if (preco <= 0.7){
                    resultado.setText("Preco da Gasolina: " +statusGasolina.getText()+
                            "\n Preco da Etanol: "+statusEtanol.getText()+
                            "\n Diferença entre eles :"+formatPreco.format(preco)+
                            "\n"+"O etanol é mais vantajoso do que a Gasolina.");
               }else if (preco >0.7){
                    resultado.setText("Preco da Gasolina: " +statusGasolina.getText()+
                            "\n Preco da Etanol: "+statusEtanol.getText()+
                            "\n Diferença entre eles :"+formatPreco.format(preco)+
                            "\n"+"A Gasolina é mais vantajoso do que o Etanol.");
                }


            }
        });
    }


}
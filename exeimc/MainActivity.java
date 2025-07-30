package com.example.exeimc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText nome,idade,peso,altura;
    Button btResultado;

    MultiAutoCompleteTextView resultado;


    @SuppressLint({"MissingInflatedId", "CutPasteId"})
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

          nome = findViewById(R.id.nome);
          idade = findViewById(R.id.idade);
          peso = findViewById(R.id.peso);
          altura = findViewById(R.id.altura);
          btResultado = findViewById(R.id.brResultado);
          resultado = findViewById(R.id.Resultado);


          resultado.setEnabled(false);

             btResultado.setOnClickListener(new View.OnClickListener() {
                 @SuppressLint("SetTextI18n")
                 @Override
                 public void onClick(View v) {
                     double pes = Double.parseDouble(peso.getText().toString());
                     double alt = Double.parseDouble(altura.getText().toString());
                     double imc = pes/(alt*alt);
                     resultado.setText("Seu imc é: "+imc);
                     DecimalFormat formatIMC = new DecimalFormat("###,##0.00");
                     resultado.setText(nome.getText()+"seu Peso é: "+formatIMC.format((imc)));
                     if( imc<18.5){
                         resultado.setText(nome.getText()+"voce tem "+idade.getText()+"anos e o calculo do seu imc é: "+formatIMC.format(imc)+ "\n"+"voce esta abaixo do peso");

                     }else if (imc >= 18.5 && imc <24.9){
                         resultado.setText(nome.getText()+"voce tem "+idade.getText()+"anos e o calculo do seu IMC é: "+formatIMC.format(imc)+ "\n"+"voce esta com peso normal");
                     }


                     else if (imc >= 24.9 && imc < 29.9){
                         resultado.setText(nome.getText()+"\n"+
                                 "voce tem "+idade.getText()+" anos "+"\n"+
                                 " o calculo do seu IMC é: "+formatIMC.format(imc)+"\n"+"sobrepeso");
                     }

                     else if (imc >= 29.9 && imc < 34.9){
                         resultado.setText(nome.getText()+"\n"+
                                 "voce tem "+idade.getText()+"anos "+"\n" +
                                 " o calculo do seu IMC é: "+formatIMC.format(imc)+"obesidade grau I");
                     }

                     else if (imc >= 34.9 && imc < 39.9){
                         resultado.setText(nome.getText()+"voce tem "+idade.getText()+"anos "+"\n" +
                                 "o calculo do seu IMC é: "+formatIMC.format(imc)+"obesidade grau II");
                     }

                     else if (imc >= 39.9 && imc < 49.9){
                         resultado.setText(nome.getText()+"voce tem "+idade.getText()+"anos e " +"\n"+
                                 "o calculo do seu IMC é: "+formatIMC.format(imc)+"obesidade grau III");
                     }

                     else if (imc >= 49.9 && imc < 59.9){
                         resultado.setText(nome.getText()+"voce tem "+idade.getText()+"anos e " +"\n"+
                                 "o calculo do seu IMC é: "+formatIMC.format(imc)+"obesidade grau IV");
                     }

                     else if (imc >= 60){
                         resultado.setText(nome.getText()+"voce tem "+idade.getText()+"anos e " +"\n"+
                                 "o calculo do seu IMC é: "+formatIMC.format(imc)+"obesidade grau V");
                     }

                 }

             });




    }
}
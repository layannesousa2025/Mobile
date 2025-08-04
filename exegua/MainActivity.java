package com.example.exegua;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btCalcular;
     EditText statusNome,statusIdade,statusPeso,statusTemperatura;

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

        btCalcular = findViewById(R.id.btCalcular);
        statusNome = findViewById(R.id.statusNome);
        statusIdade = findViewById(R.id.statusIdade);
        statusPeso = findViewById(R.id.statusPeso);
        statusTemperatura = findViewById(R.id.statusTemperatura);
        resultado = findViewById(R.id.resultado);


         btCalcular.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 double pes = Double.parseDouble(statusPeso.getText().toString());
                 double te = Double.parseDouble(statusTemperatura.getText().toString());
                 double agua = (pes*te)/1000;
                 DecimalFormat formatagua = new DecimalFormat("#,##0.00");
                 resultado.setText("Seu Nome: "+ statusNome.getText().toString()+"Sua idade: "+statusIdade.getText().toString()+"Você Deve Bebe: "+formatagua.format((agua))+"\n"+" Litros De Água");

                 if(te <=32){
                    agua = (pes*35)/1000;
                     resultado.setText("Seu Nome: "+ statusNome.getText().toString()+"\n"+"Sua idade: "+statusIdade.getText().toString()+" Você Deve Bebe: "+formatagua.format((agua))+"\n"+" Litros De Água");
                 }else if (te>=32 &&  te<=37){
                 agua = (pes*45)/1000;
                 resultado.setText("Seu Nome: "+ statusNome.getText().toString()+"\n"+"Sua idade: "+statusIdade.getText().toString()+" Você Deve Bebe: "+formatagua.format((agua))+"\n"+" Litros De Água");
                 }else{
                    agua =  (pes*65)/1000;
                     resultado.setText("Seu Nome: "+ statusNome.getText().toString()+"\n"+"Sua idade: "+statusIdade.getText().toString()+" Você Deve Bebe: "+formatagua.format((agua))+"\n"+" Litros De Água");
                 }
             }
         });


}
}
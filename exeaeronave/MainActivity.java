package com.example.exeaeronave;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

import android.annotation.SuppressLint;
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

public class MainActivity extends AppCompatActivity {
   Button btligar,btCheckList,btAutorizar,btSubir,btDescer,btAutoDescer;
   EditText statusLigar,statusCheckList,statusAutorizar,statusSubir,statusDescer,statusAutoDescer;

   MultiAutoCompleteTextView resultado;
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

         btligar= findViewById(R.id.btLigar);
         btCheckList = findViewById(R.id.btCheckList);
         btAutorizar= findViewById(R.id.btAutorizar);
         btSubir = findViewById(R.id.btSubir);
         btDescer = findViewById(R.id.btDescer);
         btAutoDescer = findViewById(R.id.AutoDescer);
         statusLigar = findViewById(R.id.statusLigar);
         statusCheckList = findViewById(R.id.statusCheckList);
         statusAutorizar = findViewById(R.id.statusAutorizar);
         statusSubir = findViewById(R.id.statusSubir);
         statusDescer = findViewById(R.id.statusDescer);
         statusAutoDescer = findViewById(R.id.statusAutoDescer);
         resultado = findViewById(R.id.resultado);

         statusLigar.setEnabled(false);
         statusCheckList.setEnabled(false);
         statusAutorizar.setEnabled(false);
         statusSubir.setEnabled(false);
         statusDescer.setEnabled(false);
         statusAutoDescer.setEnabled(false);
         resultado.setEnabled(false);

         statusAeronave();

         btligar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (statusCheckList.getText().toString().equals("Feito!!!")
                 && statusLigar.getText().toString().equals("Desligado")){
                     statusLigar.setText("Ligado");
                     statusAeronave();
                 }else{
                     Toast.makeText(getApplication(),"Voce Precisa Fazer CheckList",LENGTH_LONG).show();
                 }
             }
         });

         btCheckList.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                     statusCheckList.setText("Feito!!!");
                     statusAeronave();
                 }

         });

           btAutorizar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                if (statusCheckList.getText().toString().equals("Feito!!!")
                    && statusLigar.getText().toString().equals("Ligado")){
                    statusAutorizar.setText("Autorizado");
                    statusAeronave();
                }else{
                    Toast.makeText(getApplication(),"Você Precisa Fazer o CheckList",LENGTH_LONG).show();
                }
                   }

           });
              btSubir.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      if(statusAutorizar.getText().toString().equals("Autorizado")
                      && acumulador<40){
                          acumulador = acumulador +10;
                          statusSubir.setText(acumulador+" Mil Pes");
                          statusAeronave();
                      }else{
                          Toast.makeText(getApplication(),"Você precisa de autorizacao",LENGTH_LONG).show();
                      }


                  }
              });

              btAutoDescer.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                       if (acumulador >0){
                           statusAutoDescer.setText("Autorizado");
                           statusAeronave();
                       }else{
                           Toast.makeText(getApplication(),"voce presisa de autorizacao para descer",LENGTH_LONG).show();
                       }
                  }
              });

              btDescer.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      if (statusAutoDescer.getText().toString().equals("Autorizado")
                      && acumulador >0){
                          acumulador = acumulador -10;
                          statusAeronave();
                          statusDescer.setText(acumulador+"pés");
                      }else if(acumulador == 0){
                          Toast.makeText(getApplication()," A Aeronave Está Em Solo",LENGTH_LONG).show();
                          statusLigar.setText("Desligado");
                          statusAutorizar.setText("Não Autorizado");
                          statusDescer.setText("Não Autorizado");
                          statusSubir.setText("0 Pés");
                          statusCheckList.setText("Não Feito");

                      }else{
                          Toast.makeText(getApplication(),"Voce não tem Atualizacao para Descer",LENGTH_LONG).show();
                      }
                  }


              });

    }
    public  void statusAeronave(){
        resultado.setText("status ligado: "+statusLigar.getText().toString()+" \n"+
                "statusCheckList: "+statusCheckList.getText().toString()+" \n"+
                 "Autorizar:"+statusAutorizar.getText().toString()+" \n"+
                "Altitude Subir:"+statusSubir.getText().toString()+" \n"+
                "Autorizar Pouso:"+statusAutoDescer.getText().toString()+" \n"+
                "Altitude Descer:"+statusDescer.getText().toString());

    }
}
package com.example.aulamenu3;

import static android.icu.text.ListFormatter.Type.AND;
import static android.icu.text.MessagePattern.ArgType.SELECT;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends AppCompatActivity {
    EditText usuario, senha;
    Button btEntra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usuario = findViewById(R.id.usuario);
        senha = findViewById(R.id.senha);
        btEntra = findViewById(R.id.btEntra);


        ConexaoMysl ConexaoMysql = null;
        Connection conexao = ConexaoMysql.conectar();
        if (conexao != null) {
            Log.d("Conexão", "Conexão estabelecida com sucesso!");
         // Faça suas operações de banco de dados aqui
            ConexaoMysql.fecharConexao(conexao);
        } else {
            Log.d("Conexão", "Erro ao conectar ao banco de dados!");
        }


        btEntra .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection con = ConexaoMysl.conectar();
                String sql = "SELECT * FROM login WHERE usuario = ? AND senha = UPPER(MD5(?))";
                try {
                    PreparedStatement stmt =con.prepareStatement(sql);
                    stmt.setString(1, usuario.getText().toString());
                    stmt.setString(2, senha.getText().toString());
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()){
                        Intent menu = new Intent(Login.this, MainActivity.class);
                        startActivity(menu);
                        finish();
                    }else {
                        new AlertDialog.Builder(Login.this).setMessage("Usuario ou Senha Incorretos").show();
                    }

                    rs.close();
                    stmt.close();
                    con.close();



                    ConexaoMysl.fecharConexao(con);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });







    }
}
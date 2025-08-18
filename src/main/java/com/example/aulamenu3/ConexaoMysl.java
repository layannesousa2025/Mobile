package com.example.aulamenu3;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysl {

    private static final String URL = "jdbc:mysql://10.160.215.14:3306/banco_android";
    private static final String USUARIO = "senac"; //super usuario do banco de dados
    private static final String SENHA = "123";

    public static Connection conectar() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                StrictMode.ThreadPolicy policy = new
                        StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;

        }
    }

    public static void fecharConexao(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}

package com.example.aulamenu3.ui.cadastroPessoa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.aulamenu3.ConexaoMysl;
import com.example.aulamenu3.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroPessoaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroPessoaFragment extends Fragment {
    EditText nome, cpf, telefone, email;
    Button btCadastra;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CadastroPessoaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroPessoaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroPessoaFragment newInstance(String param1, String param2) {
        CadastroPessoaFragment fragment = new CadastroPessoaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cadastro_pessoa, container, false);

        nome = view.findViewById(R.id.nome);
        cpf = view.findViewById(R.id.cpf);
        telefone = view.findViewById(R.id.telefone);
        email = view.findViewById(R.id.email);
        btCadastra = view.findViewById(R.id.btCadastra);


        btCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection con= ConexaoMysl.conectar();
                String sql="insert into pessoa(nome,cpf,telefone,email) values(?,?,?,?)";
                try {
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1,nome.getText().toString());
                    stmt.setString(2,cpf.getText().toString());
                    stmt.setString(3,telefone.getText().toString());
                    stmt.setString(4,email.getText().toString());
                    stmt.execute();

                    stmt.close();
                    con.close();

                    nome.setText("");
                    cpf.setText("");
                    telefone.setText("");
                    email.setText("");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });



        return  view;





    }
}
package com.example.jacksonsilva.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarUsuario extends AppCompatActivity {

    private Button btnCadSalvar;
    private Button btnCadCancelar;

    private EditText edtCadLogin;
    private EditText edtCadSenha;
    private EditText edtConfsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        btnCadSalvar = (Button) findViewById(R.id.btnCadsalvar);
        btnCadCancelar = (Button) findViewById(R.id.btnCadCancelar);


        edtCadLogin= (EditText) findViewById(R.id.edtcadLogin);
        edtCadSenha= (EditText) findViewById(R.id.edtCadSenha);
        edtConfsenha= (EditText) findViewById(R.id.edtConfSenha);


        btnCadSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtCadSenha.getText().toString().equals(edtConfsenha.getText().toString())){

                    Dao dao=new Dao(CadastrarUsuario.this,"AulaAndroid",null,1);
                    dao.inserirUsuario(edtCadLogin.getText().toString(),edtCadSenha.getText().toString());
                    Toast.makeText(CadastrarUsuario.this, "Dados Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(CadastrarUsuario.this,MainActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(CadastrarUsuario.this, "Verifique a confirmação de senha!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCadCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });


    }
}

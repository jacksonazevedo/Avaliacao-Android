package com.example.jacksonsilva.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button btnLogin;
    private Button btnCadUser;
    private EditText edtLogin;
    private EditText edtsenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtLogin= (EditText) findViewById(R.id.edtLogin);
        edtsenha= (EditText) findViewById(R.id.edtSenha);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dao dao=new Dao(MainActivity.this,"AulaAndroid",null,1);

                if(dao.autenticar(edtLogin.getText().toString(),edtsenha.getText().toString())) {
                    Intent intent = new Intent(MainActivity.this,TelaInicial.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nome", edtLogin.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Usuario e/ou Senha Invalida!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCadUser= (Button) findViewById(R.id.btnCadUser);
        btnCadUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,CadastrarUsuario.class);
                startActivity(intent);
            }
        });



    }
}

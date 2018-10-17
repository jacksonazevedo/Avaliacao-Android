package com.example.jacksonsilva.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private Button btnLogin;
private EditText edtLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtLogin= (EditText) findViewById(R.id.edtLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TelaInicial.class);
                Bundle bundle = new Bundle();
                bundle.putString("nome", edtLogin.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}

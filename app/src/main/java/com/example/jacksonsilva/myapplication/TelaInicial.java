package com.example.jacksonsilva.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaInicial extends AppCompatActivity {
    private TextView txtInicial;
    private Button btnToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        txtInicial =(TextView) findViewById(R.id.txtInicial);
        btnToast = (Button) findViewById(R.id.btnToast);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String chegouaqui = bundle.getString("nome");
        txtInicial.setText("Bem vindo usuario "+chegouaqui+" a aula de android");

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TelaInicial.this, "Mensagem Toast", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.telaTabs:
                Intent intent = new Intent(TelaInicial.this,TelaTabs.class);
                //Bundle bundle = new Bundle();
                ///bundle.putString("nome", edtLogin.getText().toString());
               // intent.putExtras(bundle);
                startActivity(intent);
               // Toast.makeText(TelaInicial.this, "opção 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.op2:
                Toast.makeText(TelaInicial.this, "opção 2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

package com.usjt.guilherme.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        /*//Referência da intent da tela do menu
        /final Intent intentMenu = new Intent(this, MenuActivity.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gera o JSON quando o botão for pressionado
                //Chamar o método de integração a partir daqui
                geraJsonLogin();               //retorna o JSon
                //Sobe a intent do menu (chamar depois de logado)
                startActivity(intentMenu);
            }
        });
        */
    }
    /*
    public JSONObject geraJsonLogin(){
        JSONObject json = new JSONObject();
        //Pega texto dos elementos da View
        EditText bancoElement = (EditText) findViewById(R.id.editTextBanco);
        String banco = bancoElement.getText().toString();
        EditText agenciaElement = (EditText) findViewById(R.id.editTextAgencia);
        String agencia = agenciaElement.getText().toString();
        EditText contaElement = (EditText) findViewById(R.id.editTextConta);
        String conta = contaElement.getText().toString();
        EditText senhaElement = (EditText) findViewById(R.id.editTextSenha);
        String senha = senhaElement.getText().toString();
        try{
            json.put("banco", banco);
            json.put("agencia",agencia);
            json.put("conta", conta);
            json.put("senha", senha);
        }catch (JSONException e) {
            e.printStackTrace();
        }
        //Retorna o objeto (***usar este para integração***)
        return json;
    }
    */
}

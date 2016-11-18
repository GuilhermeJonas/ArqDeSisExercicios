package com.usjt.guilherme.caixaeletronico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by guilherme on 23/10/16.
 */
public class SaqueActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saque_activity);
        Button button = (Button) findViewById(R.id.buttonProsseguir);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gera JSON ao clicar no botão "Prosseguir"
                //Chamar o método de integração a partir daqui
                geraJsonSaque();
            }
        });
    }

    public JSONObject geraJsonSaque(){
        JSONObject json = new JSONObject();
        //Pega texto dos elementos da View
        EditText bancoElement = (EditText) findViewById(R.id.editTextBanco);
        String banco = bancoElement.getText().toString();
        EditText agenciaElement = (EditText) findViewById(R.id.editTextAgencia);
        String agencia = agenciaElement.getText().toString();
        EditText contaElement = (EditText) findViewById(R.id.editTextConta);
        String conta = contaElement.getText().toString();
        EditText valorElement = (EditText) findViewById(R.id.editTextValor);
        String valor = valorElement.getText().toString();
        try{
            json.put("banco", banco);
            json.put("agencia",agencia);
            json.put("conta", conta);
            json.put("valor", valor);
        }catch (JSONException e) {
            e.printStackTrace();
        }
        //Retorna o objeto (***usar este para integração***)
        return json;
    }
}

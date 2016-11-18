package com.usjt.guilherme.caixaeletronico.caixaeletronico.controller;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import br.usjt.arqdesis.caixaeletronico.R;
import br.usjt.arqdesis.caixaeletronico.model.Saque;
import br.usjt.arqdesis.caixaeletronico.model.SaqueRequester;
import br.usjt.arqdesis.caixaeletronico.util.APIClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by guilherme on 23/10/16.
 */
public class SaqueActivity extends AppCompatActivity{
    Map<String, Object> requestBody = null;
    SaqueRequester requester;
    //ProgressBar progressBar;
    Calendar data = Calendar.getInstance();
    Callback<Saque> callBackSaque;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saque_activity);
        Button button = (Button) findViewById(R.id.buttonProsseguir);
        configurarCallbackSaque();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gera JSON ao clicar no botão "Prosseguir"
                //Chamar o método de integração a partir daqui
                geraBodySaque();
                requester = new SaqueRequester();
                if(requester.isConnected(SaqueActivity.this)) {
                    new APIClient().getRestService().postSaque(requestBody,callBackSaque);
                } else {
                    Toast toast = Toast.makeText(SaqueActivity.this, "Rede indisponível", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    public Map geraBodySaque(){

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

            String datahoje = data.get(Calendar.YEAR) +"-" + (data.get(Calendar.MONTH)+1) +"-" + data.get(Calendar.DAY_OF_MONTH);

            requestBody = new HashMap<>();
            requestBody.put("tipoMovimento",2);
            requestBody.put("valor", valor);
            requestBody.put("numConta", conta);
            requestBody.put("numAgencia",agencia);
            requestBody.put("numBanco", banco);
            requestBody.put("data", datahoje);

        }catch (Exception e) {
            e.printStackTrace();
        }
        //Retorna o objeto (***usar este para integração***)
        return requestBody;
    }
    private void configurarCallbackSaque() {
        callBackSaque = new Callback<Saque>() {
            @Override
            public void success( Saque saque, Response
                    response) {
                if(response.getStatus()==200) {
                    Toast.makeText(SaqueActivity.this,
                            "Saque efetuado!",
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SaqueActivity.this,
                            "Falha na comunicação com o servidor!",
                            Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(SaqueActivity.this,
                        "Falha na comunicação com o servidor!",
                        Toast.LENGTH_LONG).show();
                Log.e("RETROFIT", "Error:"+error.getMessage());
            }
        };
    }
}

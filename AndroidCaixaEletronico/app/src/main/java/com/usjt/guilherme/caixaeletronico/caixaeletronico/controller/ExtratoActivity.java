package com.usjt.guilherme.caixaeletronico.caixaeletronico.controller;

/**
 * Created by guilherme on 23/10/16.
 * Modificado Jonas 07/11/2016
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.usjt.arqdesis.caixaeletronico.R;
import br.usjt.arqdesis.caixaeletronico.model.Extrato;
import br.usjt.arqdesis.caixaeletronico.model.ExtratoAdapter;
import br.usjt.arqdesis.caixaeletronico.model.ExtratoRequester;
import br.usjt.arqdesis.caixaeletronico.util.APIClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ExtratoActivity extends AppCompatActivity {
    Map<String, Object> requestBody = null;
    ExtratoRequester requester;
    Callback<List<Extrato>> callBackExtrato;
    ExtratoAdapter adapter;
    String lista[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extrato_activity);
        //Botao
        Button button = (Button) findViewById(R.id.buttonAtualizar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gera o JSON ao pressionar o botÃ£o "atualizar"
                //Chamar o mÃ©todo de integraÃ§Ã£o a partir daqui
                geraBodyExtrato();
                requester = new ExtratoRequester();
                if(requester.isConnected(ExtratoActivity.this)) {
                    new APIClient().getRestService().consultarExtraro(requestBody,callBackExtrato);
                } else {
                    Toast toast = Toast.makeText(ExtratoActivity.this, "Rede indisponível", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listViewExtrato);
        listView.setAdapter(adapter);
    }
    //Gera um lsita com 50 itens, apenas para testar a view
    //****REMOVER NA VERSÃƒO FINAL*****
    public void geraLista(String lista[]){
        for(int i=0; i<=50; i++){
            lista[i] = "Item "+ i;
        }
    }

    public void geraLista(List<Extrato> extratos){
        int i = 0;
        lista = new String[extratos.size()];
        for (Extrato item: extratos) {
            String tipo = "";
            if(item.getTipoMovimento() == 1){
                tipo = "Transferência";
            }else if(item.getTipoMovimento() == 2){
                tipo = "Saque";
            }
            lista[i] = "Efetuado "+tipo+" de $"+item.getValor()+" em "+item.getData()+"\nID: "+item.getIdMovimento();
        }
    }

    public Map geraBodyExtrato(){
        //Pega texto do elemento da View
        //DatePicker
        int conta = 99900;
        DatePicker date = (DatePicker) findViewById(R.id.datePicker);
        String dia = String.valueOf(date.getDayOfMonth());
        String mes = String.valueOf(date.getMonth());
        String ano = String.valueOf(date.getYear());
        String data = ano+"-"+mes+"-"+dia;
        String conta = (EditText)(R.id.editTextConta);
        try{
            requestBody = new HashMap<>();
            requestBody.put("numConta", conta);
            requestBody.put("data",data);
        }catch (Exception e) {
            e.printStackTrace();
        }
        //Usar este obj para integraÃ§Ã£o
        return requestBody;
    }
    private void configurarCallbackSaque() {
        callBackExtrato = new Callback<List<Extrato>>() {
            @Override
            public void success(List<Extrato> extratos, Response response) {
                adapter.updateExtratoList(extratos);
                geraLista(extratos);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ExtratoActivity.this,
                        "Falha na comunicação com o servidor!",
                        Toast.LENGTH_LONG).show();
                Log.e("RETROFIT", "Error:"+error.getMessage());
            }
        };
    }
}


package com.usjt.guilherme.caixaeletronico;

/**
 * Created by guilherme on 23/10/16.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.usjt.guilherme.caixaeletronico.caixaeletronico.model.Extrato;
import com.usjt.guilherme.caixaeletronico.caixaeletronico.model.ExtratoAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExtratoActivity extends AppCompatActivity {
    List<Extrato> lista;
    ExtratoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //String lista[] = new String[50];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extrato_activity);
        lista = new ArrayList<Extrato>();
        //Botao
        Button button = (Button) findViewById(R.id.buttonAtualizar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gera o JSON ao pressionar o botão "atualizar"
                //Chamar o método de integração a partir daqui
                geraJsonExtrato();
            }
        });
        //ArrayAdapter
        for(int i=0; i<50; i++){
            lista[i] = "Item "+ i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listViewExtrato);
        listView.setAdapter(adapter);
    }
    //Gera um lista com 50 itens, apenas para testar a view
    //****REMOVER NA VERSÃO FINAL*****
    public void geraLista(String lista[]){
        for(int i=0; i<=50; i++){
            lista[i] = "Item "+ i;
        }
    }

    public JSONObject geraJsonExtrato(){
        JSONObject json = new JSONObject();
        //Pega texto do elemento da View
        //DatePicker
        DatePicker date = (DatePicker) findViewById(R.id.datePicker);
            String dia = String.valueOf(date.getDayOfMonth());
            String mes = String.valueOf(date.getMonth());
            String ano = String.valueOf(date.getYear());
        String data = ano+"-"+mes+"-"+dia;
        try{
            json.put("data", data);
        }catch (JSONException e) {
            e.printStackTrace();
        }
        //Usar este obj para integração
        return json;
    }
}


package com.usjt.guilherme.caixaeletronico.caixaeletronico.util;

import java.util.List;
import java.util.Map;

import br.usjt.arqdesis.caixaeletronico.model.Extrato;
import br.usjt.arqdesis.caixaeletronico.model.Saque;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by jonas_000 on 05/11/2016.
 */
public class APIClient {
    private static RestAdapter REST_ADAPTER;
    private static void createAdapterIfNeeded() {
        if (REST_ADAPTER == null) {
            REST_ADAPTER = new RestAdapter.Builder() .setEndpoint( "http://192.168.1.45:8080/ArqDeSisExerciciosOk/")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setClient(new OkClient()) .build();
        }
    } public APIClient() {
        createAdapterIfNeeded();
    }
    public RestServices getRestService() {
        return REST_ADAPTER.create(RestServices.class);
    } public interface RestServices {
        @Headers("Content-Type: application/json")
        @POST("/saque")
        void postSaque(@Body Map<String, Object> body, Callback<Saque> callbackSaque);

        @Headers("Content-Type: application/json")
        @POST("/extrato")
        void consultarExtraro(@Body Map<String, Object> body, Callback<List<Extrato>> callbackExtrato);
    }
}

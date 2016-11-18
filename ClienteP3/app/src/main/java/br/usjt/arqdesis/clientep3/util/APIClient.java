package br.usjt.arqdesis.clientep3.util;

import java.util.List;
import br.usjt.arqdesis.clientep3.model.Cliente;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Path;
/**
 * Created by jonas_000 on 02/11/2016.
 */

public class APIClient {
    private static RestAdapter REST_ADAPTER;
    private static void createAdapterIfNeeded() {
        if (REST_ADAPTER == null) {
            REST_ADAPTER = new RestAdapter.Builder() .setEndpoint( "http://www.qpainformatica.com.br/exemplorest/rest")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setClient(new OkClient()) .build();
        }
    } public APIClient() {
        createAdapterIfNeeded();
    } public RestServices getRestService() {
        return REST_ADAPTER.create(RestServices.class);
    } public interface RestServices {
        @GET("/poeta/todos")
        void getAllPoetas(Callback<List<Cliente>> callbackCliente);
        @GET("/poeta/{nome}")
        void getAllPoetaLikeName(
                @Path("nome") String nome, Callback<List<Cliente>> callbackCliente);
    }

}

package dao.retrofit;

import com.squareup.moshi.Moshi;
import common.Constantes;
import dao.retrofit.llamadas.MarvelAPI;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ProducersRetrofit {

    @Produces
    @Singleton
    public Moshi getMoshi() {
        return new Moshi.Builder().build();
    }
    @Produces
    @Singleton
    public Retrofit retrofits(Moshi moshi) {
        OkHttpClient clientOK = new OkHttpClient.Builder()
                .connectionPool(new okhttp3.ConnectionPool(1, 2, java.util.concurrent.TimeUnit.SECONDS))
                .build();
        return new Retrofit.Builder()
                .baseUrl(Constantes.URLMARVEL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(clientOK)
                .build();
    }


    @Produces
    public MarvelAPI getCharactersAPI(Retrofit retrofit) {
        return retrofit.create(MarvelAPI.class);
    }


}

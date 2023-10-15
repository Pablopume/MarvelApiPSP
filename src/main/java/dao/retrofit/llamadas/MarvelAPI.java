package dao.retrofit.llamadas;

import common.Constantes;
import modelo.Response;
import modelo.Response2;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelAPI {

    @GET(Constantes.CHARACTERS)
    Call<Response> getCharacters(
            @Query(Constantes.APIKEY) String apiKey,
            @Query(Constantes.TS) String timestamp,
            @Query(Constantes.HASH) String hash

    );

    @GET(Constantes.CHARACTER_SERIES)
    Call<Response2> getSeries(
            @Path(Constantes.CHARACTER_ID) int characterId,
            @Query(Constantes.APIKEY) String apiKey,
            @Query(Constantes.TS) String timestamp,
            @Query(Constantes.HASH) String hash
    );

    @GET(Constantes.CHARACTER_FROM_CHARACTER_SERIES)
    Call<Response> getCharacterSeries(
            @Path(Constantes.SERIES_ID) int seriesId,
            @Query(Constantes.APIKEY) String apiKey,
            @Query(Constantes.TS) String timestamp,
            @Query(Constantes.HASH) String hash
    );


}

package dao.impl;

import common.Constantes;
import dao.MarvelDao;
import dao.retrofit.llamadas.MarvelAPI;
import modelo.Response;
import modelo.Character;
import modelo.Response2;
import modelo.Series;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import retrofit2.Call;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

public class MarvelDaoImpl implements MarvelDao {
    private final String publicKey = Constantes.CLAVE_PUBLICA;
    private final String privateKey = Constantes.CLAVE_PRIVADA;
    private final MarvelAPI marvelAPI;
    private final long timestamp = new Date().getTime();
    String hash = generateHash(timestamp, privateKey, publicKey);

    @Inject
    MarvelDaoImpl(MarvelAPI marvelAPI) {
        this.marvelAPI = marvelAPI;
    }

    public Either<String, List<Character>> getCharacters() {
        Call<Response> call = marvelAPI.getCharacters(publicKey, String.valueOf(timestamp), hash);

        try {
            retrofit2.Response<Response> response = call.execute();

            if (response.isSuccessful()) {
                Response apiResponse = response.body();
                List<Character> characters = apiResponse.getData().getResults();
                return Either.right(characters);
            } else {
                String errorMessage = Constantes.ERROR + response.code() + Constantes.GUION + response.message();
                Constantes.logger.error(errorMessage);
                return Either.left(errorMessage);
            }
        } catch (IOException e) {
            String errorMessage = Constantes.ERROR2 + e.getMessage();
            Constantes.logger.error(errorMessage, e);
            return Either.left(errorMessage);
        }
    }

    public Either<String, List<Series>> getSeries(int id) {
        Call<Response2> call = marvelAPI.getSeries(id, publicKey, String.valueOf(timestamp), hash);
        try {
            retrofit2.Response<Response2> response = call.execute();

            if (response.isSuccessful()) {
                Response2 apiResponse = response.body();
                List<Series> comics = apiResponse.getData().getResults();
                return Either.right(comics);
            } else {
                String errorMessage = Constantes.ERROR + response.code() + Constantes.GUION + response.message();
                Constantes.logger.error(errorMessage);
                return Either.left(errorMessage);
            }
        } catch (IOException e) {
            String errorMessage = Constantes.ERROR2 + e.getMessage();
            Constantes.logger.error(errorMessage, e);
            return Either.left(errorMessage);
        }
    }

    public Either<String, List<Character>> getCharacterSeries(int id) {
        Call<Response> call = marvelAPI.getCharacterSeries(id, publicKey, String.valueOf(timestamp), hash);
        try {
            retrofit2.Response<Response> response = call.execute();

            if (response.isSuccessful()) {
                Response apiResponse = response.body();
                List<Character> characters = apiResponse.getData().getResults();
                return Either.right(characters);
            } else {
                String errorMessage = Constantes.ERROR + response.code() + Constantes.GUION + response.message();
                Constantes.logger.error(errorMessage);
                return Either.left(errorMessage);
            }
        } catch (IOException e) {
            String errorMessage = Constantes.ERROR2 + e.getMessage();
            Constantes.logger.error(errorMessage, e);
            return Either.left(errorMessage);
        }
    }

    private static String generateHash(long timestamp, String privateKey, String publicKey) {
        String input = timestamp + privateKey + publicKey;
        try {
            MessageDigest md = MessageDigest.getInstance(Constantes.MD5);
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format(Constantes.FORMATO, b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            String errorMessage = Constantes.ERROR3 + e.getMessage();
            Constantes.logger.error(errorMessage, e);
            return Constantes.EMPTY;
        }
    }
}



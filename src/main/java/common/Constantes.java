package common;

import dao.impl.MarvelDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Constantes {

    public static final String CLAVE_PUBLICA = "11578e02d7f71b0ad16ab23cfd405927";
    public static final String CLAVE_PRIVADA = "95b6ae646b230edaa3bc2fcce0bc7816eda0c582";
    public static final String ERROR = "Error: ";
    public static final String GUION = " - ";
    public static final String ERROR2 = "Error de red o excepción: ";
    public static final String MD5 = "MD5";
    public static final String FORMATO = "%02x";
    public static final String ERROR3 = "Error al generar el hash: ";
    public static final String EMPTY = "";
    public static final Logger logger = LogManager.getLogger(MarvelDaoImpl.class);
    public static final String CHARACTERS = "v1/public/characters";
    public static final String CHARACTERSERIES = "v1/public/characters/{characterId}/series";
    public static final String CHARACTER_SERIES = CHARACTERSERIES;
    public static final String CHARACTER_FROM_CHARACTER_SERIES = "v1/public/series/{seriesId}/characters";
    public static final String APIKEY = "apikey";
    public static final String SERIES_ID = "seriesId";
    public static final String TS = "ts";
    public static final String HASH = "hash";
    public static final String CHARACTER_ID = "characterId";
    public static final String URLMARVEL = "https://gateway.marvel.com/";
    public static final String PRINCIPAL = "/fxml/principal.fxml";
    public static final String URLNAMED = "url";
    public static final String CONFIG_DB = "configDB";
    public static final String JJJ = "jjj";
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String THUMBNAIL = "thumbnail";
    public static final String TITLE = "title";
    public static final String PUNTO = ".";
}

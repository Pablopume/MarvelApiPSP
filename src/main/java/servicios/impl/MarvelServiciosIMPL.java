package servicios.impl;

import dao.MarvelDao;
import modelo.Character;
import modelo.Series;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import servicios.MarvelServicios;

import java.util.List;

public class MarvelServiciosIMPL implements MarvelServicios {
    private final MarvelDao marvelDao;

    @Inject
    public MarvelServiciosIMPL(MarvelDao marvelDao) {
        this.marvelDao = marvelDao;
    }

    @Override
    public Either<String, List<Character>> getCharacters() {
        return marvelDao.getCharacters();
    }

    @Override
    public Either<String, List<Series>> getComics(int id) {
        return marvelDao.getSeries(id);
    }

    @Override
    public Either<String, List<Character>> getCharacterSeries(int id) {
        return marvelDao.getCharacterSeries(id);
    }

}

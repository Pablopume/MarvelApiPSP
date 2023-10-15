package dao;

import modelo.Character;
import modelo.Series;
import io.vavr.control.Either;

import java.util.List;

public interface MarvelDao {
    Either<String, List<Character>> getCharacters();
    Either<String, List<Series>> getSeries(int id);
    Either<String, List<Character>> getCharacterSeries(int id);
}

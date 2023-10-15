package servicios;

import modelo.Character;
import modelo.Series;
import io.vavr.control.Either;

import java.util.List;

public interface MarvelServicios {
    Either<String, List<Character>> getCharacters();

    Either<String, List<Series>> getComics(int id);

    Either<String, List<Character>> getCharacterSeries(int id);
}

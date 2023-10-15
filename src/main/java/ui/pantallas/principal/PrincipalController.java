package ui.pantallas.principal;

import common.Constantes;
import modelo.Character;
import modelo.Thumbnail;
import modelo.Series;
import jakarta.inject.Inject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.extern.log4j.Log4j2;
import servicios.MarvelServicios;

import java.util.List;

@Log4j2
public class PrincipalController {
    @FXML
    public TableColumn<Character, String> name;
    @FXML
    public TableColumn<Character, Integer> id;
    @FXML
    public TableView<Character> characterTable;
    @FXML
    public TableColumn<Character, Thumbnail> thumbnail;
    @FXML
    public TableView<Series> seriesTable;
    @FXML
    public TableColumn<Series, String> title;
    public TableColumn<Series, String> idSerie;
    public TableColumn<Character, String> name2;
    public TableView<Character> charactersTable2;
    public TableColumn<Character, Integer> id2;
    public TableColumn<Character, Thumbnail> thumbnail2;
    private final MarvelServicios marvelServicios;

    @Inject
    public PrincipalController(MarvelServicios marvelServicios) {
        this.marvelServicios = marvelServicios;
    }

    public void initialize() {
        List<Character> resultado = marvelServicios.getCharacters().get();
        setCells();
        thumbnailsConversion();
        ObservableList<Character> data = FXCollections.observableArrayList(resultado);
        characterTable.setItems(data);
        observeTables();

    }

    private void observeTables() {
        seriesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int selectedSeriesId = Integer.parseInt(newValue.getId());
                List<Character> comicsForSelectedCharacter = marvelServicios.getCharacterSeries(selectedSeriesId).get();
                ObservableList<Character> data3 = FXCollections.observableArrayList(comicsForSelectedCharacter);
                charactersTable2.setItems(data3);
            }
        });
        characterTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int selectedCharacterId = newValue.getId();
                List<Series> comicsForSelectedCharacter = marvelServicios.getComics(selectedCharacterId).get();
                ObservableList<Series> data2 = FXCollections.observableArrayList(comicsForSelectedCharacter);
                seriesTable.setItems(data2);
            }
        });
    }

    private void setCells() {
        name.setCellValueFactory(new PropertyValueFactory<>(Constantes.NAME));
        name2.setCellValueFactory(new PropertyValueFactory<>(Constantes.NAME));
        id.setCellValueFactory(new PropertyValueFactory<>(Constantes.ID));
        id2.setCellValueFactory(new PropertyValueFactory<>(Constantes.ID));
        idSerie.setCellValueFactory(new PropertyValueFactory<>(Constantes.ID));
        thumbnail.setCellValueFactory(new PropertyValueFactory<>(Constantes.THUMBNAIL));
        thumbnail2.setCellValueFactory(new PropertyValueFactory<>(Constantes.THUMBNAIL));
        title.setCellValueFactory(new PropertyValueFactory<>(Constantes.TITLE));
    }

    private void thumbnailsConversion() {
        thumbnail.setCellFactory(column -> new TableCell<Character, Thumbnail>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Thumbnail item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    String imageUrl = item.getPath() + "." + item.getExtension();
                    Image image = new Image(imageUrl);
                    imageView.setImage(image);
                    imageView.setFitWidth(100);
                    imageView.setFitHeight(100);

                    setGraphic(imageView);
                }
            }
        });
        thumbnail2.setCellFactory(column -> new TableCell<Character, Thumbnail>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Thumbnail item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    String imageUrl = item.getPath() + Constantes.PUNTO + item.getExtension();
                    Image image = new Image(imageUrl);
                    imageView.setImage(image);
                    imageView.setFitWidth(100);
                    imageView.setFitHeight(100);
                    setGraphic(imageView);
                }
            }
        });
    }
}

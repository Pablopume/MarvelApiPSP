package ui.main;

import common.Constantes;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX {

    @Inject
    FXMLLoader fxmlLoader;

    public void start(@Observes @StartupScene Stage stage) throws IOException {
        try {
            Parent fxmlParent = fxmlLoader.load(getClass().getResourceAsStream(Constantes.PRINCIPAL));
            stage.setScene(new Scene(fxmlParent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

}

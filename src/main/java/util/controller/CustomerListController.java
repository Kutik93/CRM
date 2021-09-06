package util.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class CustomerListController {
    private SceneLoader sceneLoader;

    public CustomerListController() {
        this.sceneLoader = new SceneLoader();
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        sceneLoader.loadOnEvent("PersonRegistration.fxml", event);
    }
}
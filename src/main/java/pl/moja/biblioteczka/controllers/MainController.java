package pl.moja.biblioteczka.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    @FXML
    private void initialize() {

        topMenuButtonsController.setMainController(this);

    }

    public void setCenter(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles/messages");
        loader.setResources(bundle);
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderPane.setCenter(parent);
    }

    public void closeApplication() {
        Platform.exit();
        System.exit(0);
    }

    public void setStyleCaspian() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }

    public void setStyleModena() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }

    public void setAlwaysOnTop(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) borderPane.getScene().getWindow();
        boolean alwaysOnTopCheckMenuItemState = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
        primaryStage.setAlwaysOnTop(alwaysOnTopCheckMenuItemState);
    }

    public void aboutApplication(ActionEvent actionEvent) {
    }
}

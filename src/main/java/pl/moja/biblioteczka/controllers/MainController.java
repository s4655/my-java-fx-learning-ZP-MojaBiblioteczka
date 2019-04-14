package pl.moja.biblioteczka.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.moja.biblioteczka.utils.DialogUtils;
import pl.moja.biblioteczka.utils.FXMLUtils;

import java.io.IOException;
import java.util.Optional;
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

        borderPane.setCenter(FXMLUtils.fxmlLoader(fxmlPath));

    }

    public void closeApplication() {

        Optional<ButtonType> result = DialogUtils.showCloseApplicationConfirmationDialog();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
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

    public void aboutApplication() {
        DialogUtils.showAboutApplicationDialog();
    }
}

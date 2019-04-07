package pl.moja.biblioteczka.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TopMenuButtonsController {

    private MainController mainController;

    @FXML
    public void openLibrary() {
        System.out.println("openLibrary");
    }

    @FXML
    public void openBookList() {
        System.out.println("openBookList");
    }

    @FXML
    public void openStatistics() {
        System.out.println("openStatistics");
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

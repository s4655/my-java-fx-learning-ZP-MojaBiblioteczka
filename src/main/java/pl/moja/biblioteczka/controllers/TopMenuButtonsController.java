package pl.moja.biblioteczka.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String LIBRARY_FXML_PATH = "/fxml/Library.fxml";
    public static final String BOOK_LIST_FXML_PATH = "/fxml/BookList.fxml";
    public static final String STATISTICS_FXML_PATH = "/fxml/Statistics.fxml";
    public static final String ADD_BOOK_FXML_PATH = "/fxml/AddBook.fxml";
    public static final String SHOW_CATEGORY_DIALOG_FXML_PATH = "/fxml/CategoryDialog.fxml";

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private ToggleGroup toggleButtons;

    @FXML
    public void openLibrary() {
        mainController.setCenter(LIBRARY_FXML_PATH);
    }

    @FXML
    public void openBookList() {
        mainController.setCenter(BOOK_LIST_FXML_PATH);
    }

    @FXML
    public void openStatistics() {
        mainController.setCenter(STATISTICS_FXML_PATH);
    }

    @FXML
    public void addBook() {

        unselectToggleButtons();
        mainController.setCenter(ADD_BOOK_FXML_PATH);
    }

    @FXML
    public void showCategoryDialog(ActionEvent actionEvent) {

        unselectToggleButtons();
        mainController.setCenter(SHOW_CATEGORY_DIALOG_FXML_PATH);

    }

    private void unselectToggleButtons() {
        if (toggleButtons.getSelectedToggle() != null) {
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }
}

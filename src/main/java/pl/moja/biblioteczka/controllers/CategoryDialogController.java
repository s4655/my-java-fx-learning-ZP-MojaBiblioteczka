package pl.moja.biblioteczka.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.moja.biblioteczka.modelFx.CategoryFx;
import pl.moja.biblioteczka.modelFx.CategoryModel;

public class CategoryDialogController {

    @FXML
    private TextField addCategoryTextField;

    @FXML
    private Button addCategoryButton;

    @FXML
    private ComboBox<CategoryFx> chooseCategoryComboBox;

    private CategoryModel categoryModel;

    @FXML
    public void initialize() {
        this.categoryModel = new CategoryModel();
        initBindings();
    }

    private void initBindings() {
        addCategoryButton.disableProperty().bind(addCategoryTextField.textProperty().isEmpty());
    }

    @FXML
    public void addCategoryButtonOnAction(ActionEvent actionEvent) {

        categoryModel.saveCategoryInDatabase(addCategoryTextField.getText());
        addCategoryTextField.clear();
    }
}

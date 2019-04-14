package pl.moja.biblioteczka.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogUtils {

    static ResourceBundle resourceBundle = FXMLUtils.getResourceBundle();

    public static void showAboutApplicationDialog() {
        Alert aboutAppInformationAlert = new Alert(Alert.AlertType.INFORMATION);
        aboutAppInformationAlert.setTitle(resourceBundle.getString("aboutApplicationDialog.title"));
        aboutAppInformationAlert.setHeaderText(resourceBundle.getString("aboutApplicationDialog.header"));
        aboutAppInformationAlert.setContentText(resourceBundle.getString("aboutApplicationDialog.content"));
        aboutAppInformationAlert.showAndWait();
    }

    public static Optional<ButtonType> showCloseApplicationConfirmationDialog() {
        Alert aboutAppInformationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        aboutAppInformationAlert.setTitle(resourceBundle.getString("closeApplicationConfirmationDialog.title"));
        aboutAppInformationAlert.setHeaderText(resourceBundle.getString("closeApplicationConfirmationDialog.header"));
        Optional<ButtonType> result = aboutAppInformationAlert.showAndWait();
        return result;
    }

    public static void showErrorDialog(String errorText) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(resourceBundle.getString("errorDialog.title"));
        errorAlert.setHeaderText(resourceBundle.getString("errorDialog.header"));

        TextArea textArea = new TextArea(errorText);
        errorAlert.getDialogPane().setContent(textArea);

        errorAlert.showAndWait();
    }
}

package pl.moja.biblioteczka.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ResourceBundle;

public class FXMLUtils {

    public static final String RESOURCE_BUNDLE_BASE_NAME = "bundles/messages";

    public static Parent fxmlLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(FXMLUtils.class.getResource(fxmlPath));
        loader.setResources(getResourceBundle());
        try {
            return loader.load();
        } catch (Exception e) {
            DialogUtils.showErrorDialog(e.getMessage());
        }
        return null;
    }

    public static ResourceBundle getResourceBundle() {
        ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
        return bundle;
    }
}

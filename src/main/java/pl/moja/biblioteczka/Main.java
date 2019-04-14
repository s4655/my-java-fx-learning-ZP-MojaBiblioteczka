package pl.moja.biblioteczka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.moja.biblioteczka.utils.FXMLUtils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    public static final String FXML_PATH_BORDER_PANE_MAIN = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
//        Locale.setDefault(Locale.ENGLISH);
        Parent borderPane = FXMLUtils.fxmlLoader(FXML_PATH_BORDER_PANE_MAIN);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(FXMLUtils.getResourceBundle().getString("application.title"));
        primaryStage.show();
    }

}

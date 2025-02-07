package ee.ivkhkdev.nptv23javafx.controller;

import ee.ivkhkdev.nptv23javafx.Nptv23JavaFxApplication;
import ee.ivkhkdev.nptv23javafx.tools.SpringFXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MenuFormController {

    private final SpringFXMLLoader springFXMLLoader;

    public MenuFormController(SpringFXMLLoader springFXMLLoader) {
        this.springFXMLLoader = springFXMLLoader;
    }


    @FXML
    private void showAuthorForm() throws IOException {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/author/authorForm.fxml");
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        Stage primaryStage = getPrimaryStage();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Author Form");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    @FXML
    private void showBookForm() throws IOException {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/book/bookForm.fxml");
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        Stage primaryStage = getPrimaryStage();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Form");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }



    private Stage getPrimaryStage() {
        return Nptv23JavaFxApplication.primaryStage;
    }
}

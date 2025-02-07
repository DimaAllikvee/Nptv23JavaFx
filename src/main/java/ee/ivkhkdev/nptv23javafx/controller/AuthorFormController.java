package ee.ivkhkdev.nptv23javafx.controller;

import ee.ivkhkdev.nptv23javafx.Nptv23JavaFxApplication;
import ee.ivkhkdev.nptv23javafx.model.Author;
import ee.ivkhkdev.nptv23javafx.service.AuthorService;
import ee.ivkhkdev.nptv23javafx.tools.SpringFXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthorFormController {

    private final AuthorService authorService;
    private final SpringFXMLLoader springFXMLLoader;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    public AuthorFormController(SpringFXMLLoader springFXMLLoader, AuthorService authorService) {
        this.springFXMLLoader = springFXMLLoader;
        this.authorService = authorService;
    }

    @FXML
    private void create() throws IOException {
        Author author = new Author();
        author.setFirstName(tfFirstName.getText());
        author.setLastName(tfLastName.getText());
        authorService.add(author);
        loadMainForm();
    }

    @FXML
    private void loadMainForm() throws IOException {
        FXMLLoader fxmlLoader = springFXMLLoader.load("/main/mainForm.fxml");
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Stage stage = getPrimaryStage();
        stage.setScene(scene);
        stage.setTitle("NPTV23JavaFX");
        stage.centerOnScreen();
        stage.show();
    }

    private Stage getPrimaryStage() {
        return Nptv23JavaFxApplication.primaryStage;
    }
}

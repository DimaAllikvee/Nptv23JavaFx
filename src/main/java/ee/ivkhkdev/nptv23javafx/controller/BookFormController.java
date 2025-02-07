package ee.ivkhkdev.nptv23javafx.controller;

import ee.ivkhkdev.nptv23javafx.Nptv23JavaFxApplication;
import ee.ivkhkdev.nptv23javafx.model.Book;
import ee.ivkhkdev.nptv23javafx.service.BookService;
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
public class BookFormController  {
    private final BookService bookService;
    private final SpringFXMLLoader springFXMLLoader;

    @FXML private TextField tfTitle;
    @FXML private TextField tfAuthors;
    @FXML private TextField tfPublishedYear;
    @FXML private TextField tfQuantity;
    @FXML private TextField tfCount;

    public BookFormController(SpringFXMLLoader springFXMLLoader, BookService bookService) {
        this.springFXMLLoader = springFXMLLoader;
        this.bookService = bookService;
    }


    @FXML
    private void create() throws IOException {
        Book book = new Book();
        book.setTitle(tfTitle.getText());
        book.setQuantity(tfQuantity.getText());


        try {
            book.setPublishedYear(Integer.parseInt(tfPublishedYear.getText()));
        } catch (NumberFormatException e) {
            book.setPublishedYear(0);
        }

        try {
            book.setCount(Integer.parseInt(tfCount.getText()));
        } catch (NumberFormatException e) {
            book.setCount(0);
        }

        bookService.add(book);

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

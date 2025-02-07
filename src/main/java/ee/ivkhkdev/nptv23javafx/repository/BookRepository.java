package ee.ivkhkdev.nptv23javafx.repository;

import ee.ivkhkdev.nptv23javafx.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
}

package ee.ivkhkdev.nptv23javafx.repository;

import ee.ivkhkdev.nptv23javafx.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}

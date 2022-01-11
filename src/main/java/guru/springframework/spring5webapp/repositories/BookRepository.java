package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<book,Long> {
}

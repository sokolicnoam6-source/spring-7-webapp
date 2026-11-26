package guru.springframework.spring7webapp.repositories;

import guru.springframework.spring7webapp.domain.Author;
import guru.springframework.spring7webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<Author, Long> {
}

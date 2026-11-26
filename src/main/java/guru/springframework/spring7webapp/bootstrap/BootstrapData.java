package guru.springframework.spring7webapp.bootstrap;

import guru.springframework.spring7webapp.domain.Author;
import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.repositories.AuthorRepositories;
import guru.springframework.spring7webapp.repositories.BookRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepositories authorRepositories;
    private final BookRepositories bookRepositories;

    public BootstrapData(AuthorRepositories authorRepositories, BookRepositories bookRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepositories.save(eric);
        Book dddSaved = bookRepositories.save(ddd);

        authorRepositories.save(ericSaved);

        ericSaved.getBooks().add(dddSaved);
        System.out.println("In Bootstrap");
        System.out.println("Author Count :" + authorRepositories.count());
        System.out.println("Book Count " + bookRepositories.count());

    }


}

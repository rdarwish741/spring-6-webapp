package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evan");

        Book ddd = new Book();
        ddd.setTitle("Dmain Driven Deseign");
        ddd.setIsbn("123456");

        Author ericSaved =  authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author eric2 = new Author();
        eric2.setFirstName("Eric2");
        eric2.setLastName("Evan2");

        Book ddd2 = new Book();
        ddd2.setTitle("Dmain Driven Deseign2");
        ddd2.setIsbn("6543212");

        Author eric2Saved =  authorRepository.save(eric2);
        Book ddd2Saved = bookRepository.save(ddd2);

        ericSaved.getBooks().add(dddSaved);
        eric2Saved.getBooks().add(ddd2Saved);

        authorRepository.save(ericSaved);
        authorRepository.save(eric2Saved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}

package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublishRepository publishRepository;



    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublishRepository publishRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publishRepository=publishRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher=new Publisher();
        publisher.setName("Robert");
        publisher.setCity("Boston");
        publisher.setState("Tijuna");
        publishRepository.save(publisher);

        System.out.println("Number of publisher: "+ publishRepository.count());

    Author eric=new Author("Eric","Evans");
    book ddd=new book("Domain Driven Dising","123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    ddd.setPublisher(publisher);
    publisher.getBooks().add(ddd);

    authorRepository.save(eric);
    bookRepository.save(ddd);
    publishRepository.save(publisher);

    Author rod =new Author("Rod","Jonhson");
    book noEJB=new book("noEJB","212121");

    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);
    noEJB.setPublisher(publisher);
    publisher.getBooks().add(noEJB);

    authorRepository.save(rod);
    bookRepository.save(noEJB);
    publishRepository.save(publisher);
    System.out.println("Started in Bootstrap");

    System.out.println("Number of books :"+ bookRepository.count());
    System.out.println("Publisher Number of books :"+ publisher.getBooks().size());


    }
}

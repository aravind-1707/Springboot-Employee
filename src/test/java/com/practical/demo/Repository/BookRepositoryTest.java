package com.practical.demo.Repository;

import com.practical.demo.Entity.Book;
import com.practical.demo.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveBook()
    {
        Book book = Book.builder()
                .bookName("Wings of Fire")
                .bookAmt(200)
                .bookEdition(2022)
                .bookAuthorNum(12345677)
                .bookMailId("wings@gmail.com")
                .build();

        bookRepository.save(book);
    }

    @Test
    public void filterByBookName(){
        List<Book> books = bookRepository.findByBookName("Wings of Fire");
        System.out.println("Book Name:"+books);
    }

    @Test
    public void bookNameContaining(){
        List<Book> books = bookRepository.findByBookNameContaining("Bio");
        System.out.println("Book Name:"+books);
    }

    @Test
    public void updateBookNameByAmt(){
        bookRepository.updateBookNameByBookAmt("Fire","wings@gmail.com");
    }
}
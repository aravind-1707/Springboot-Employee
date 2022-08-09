package com.practical.demo.Repository;

import com.practical.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findByBookName(String bookName);

    public List<Book> findByBookNameContaining(String bookName);

    @Modifying
    @Transactional
    @Query(value = "update book set book_name=?1 where email_address=?2",
            nativeQuery = true)
    public int updateBookNameByBookAmt(String bookName,String bookEmailId);

}

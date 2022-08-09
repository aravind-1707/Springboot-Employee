package com.practical.demo.Entity;

import ch.qos.logback.classic.db.names.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "book",
        uniqueConstraints = @UniqueConstraint(name ="mailId_unique" ,columnNames ="email_address"))
public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_sequence")
    private int bookId;
    private String bookName;
    private int bookAmt;
    private int bookAuthorNum;
    @Column(name = "email_address",
            nullable = false)
    private String bookMailId;
    private int bookEdition;
}

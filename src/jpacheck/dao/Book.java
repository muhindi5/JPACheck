/*
 *  Bitforge Software Labs
 *  (c)2017 
 *  http://bitforge.co.ke
 *  <muhindi@bitforge.co.ke><muhindi09@gmail.com>
 */

package jpacheck.dao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @project: JPACheck
 * @author kelly
 * @date Jul 6, 2017 5:03:31 PM
 * 
 */

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(name = "BOOK_TITLE")
    private String title;
    @OneToMany(mappedBy = "authoredBook")
    private List<Author> author;
    @Temporal(TemporalType.DATE)
    private Calendar publishedOn;
    private String publisher;
    @Enumerated(EnumType.ORDINAL)
    private BookCategory category;

    public Book(int bookId, String title, List<Author> author, 
            Calendar publishedOn, String publisher, BookCategory category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishedOn = publishedOn;
        this.publisher = publisher;
        this.category = category;
    }

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public Calendar getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Calendar publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }
}

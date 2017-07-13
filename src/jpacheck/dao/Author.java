/*
 *  Bitforge Software Labs
 *  (c)2017 
 *  http://bitforge.co.ke
 *  <muhindi@bitforge.co.ke><muhindi09@gmail.com>
 */
package jpacheck.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @project: JPACheck
 * @author kelly
 * @date Jul 7, 2017 9:04:09 AM
 *
 */
@Entity
@DiscriminatorValue(value = "AUTHOR")
public class Author extends Person {
 
    @ManyToOne(optional = false)
    @JoinColumn(name = "BOOK_ID")
    private Book authoredBook;
}

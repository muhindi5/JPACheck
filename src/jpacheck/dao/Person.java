/*
 *  Bitforge Software Labs
 *  (c)2017 
 *  http://bitforge.co.ke
 *  <muhindi@bitforge.co.ke><muhindi09@gmail.com>
 */

package jpacheck.dao;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @project: JPACheck
 * @author kelly
 * @date Jul 6, 2017 12:05:52 PM
 * 
 * Notes:
 * -----------------------------------------------------------------------------
 * Enum type by default/implicitly are ordinal, if string is required then it 
 * can be explicitly specified
 * 
 * Temporal annotatations are for time-date based types. The sql util date-time 
 * types (java.sql.Date,java.sql.Time, java.sql.Timestamp) are hassle free but the 
 * util package types (java.util.Date,java.util.Time & java.util.Calendar) 
 * have to have explicit annotation: @Temporal that specifies the JDBC enumeration
 * type i.e date,time or timestamp
  */

@Entity
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PERSON_TYPE")
public abstract  class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @OneToOne
    @JoinColumn(unique = true,name = "ADDRESS_ID",nullable = false)
    private Address address;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private UserGroup userGroup;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REGISTERED_ON",nullable = false) //override default column name
    private Calendar dateRegistered;

    public Person() {
    }

    public Person(int pId, String firstName, String lastName, Address address, UserGroup group) {
        this.pId = pId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.userGroup = group;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserGroup getGroup() {
        return userGroup;
    }

    public void setGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public Calendar getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Calendar dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
    
    
    
}

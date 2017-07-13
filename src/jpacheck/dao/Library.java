/*
 *  Bitforge Software Labs
 *  (c)2017 
 *  http://bitforge.co.ke
 *  <muhindi@bitforge.co.ke><muhindi09@gmail.com>
 */

package jpacheck.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @project: JPACheck
 * @author kelly
 * @date Jul 7, 2017 8:08:59 AM
 * 
 */
@Entity
public class Library implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "LIBRARY_NAME")
    private String libName;
    @OneToOne
    @JoinColumn(unique = true, name = "LIB_ADDRESS")
    private Address adress;

    public Library(){
        
    }

    public Library(int id, String libName, Address adress) {
        this.id = id;
        this.libName = libName;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Library{" + "id=" + id + ", libName=" + libName + ", adress=" + adress;
    }
}

/*
 *  Bitforge Software Labs
 *  (c)2017 
 *  http://bitforge.co.ke
 *  <muhindi@bitforge.co.ke><muhindi09@gmail.com>
 */

package jpacheck.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @project: JPACheck
 * @author kelly
 * @date Jul 5, 2017 8:58:27 AM
 * 
 */

@Entity
@Table(name="ADDRESS") //optional. Specify differenct name than defult entiyclass name
                       //or if a database table already exists
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    @Basic(fetch = FetchType.LAZY)
    private String email;
    private String phone;
//    @Column(name = "City") override the dafault attribute name 'town' for the db column
    private String town;
    
//for bi-directional one-to-one relationships btwn adress and person, a Person attribute 
//can be added to this class with the @OneToOne annotation and a mappedBy element
//this would allow one to refer to the address attribute in the Person instance.
//The value of the @MappedBy element is the name of the Address attribute in the 
//inverse table,'Person'.
//    @OneToOne(mappedBy = "address")
//    private Person person;
//If the @mappedBy was missing on either side, the provider would treat each side 
//as an indipendent unidirectional relationship and that each side was the owner 
// and that each had a join column.
    public Address(){}
    
    //constructor 2... mainly for updates
    public Address(String email,String phone, String town){
        this.email = email;
        this.phone = phone;
        this.town = town;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "AddressId=" + addressId;
    }
    
    
    
    
}
//Notes
/*@Basic - Explicitly marks a field or property as persistent, not requred but can be 
            used for documentation purposes. The fetchType attribe of @Basic can
            be configured to specify the loading method of the attribute..if an 
            attribute is rarely used, it can be specified as LAZY (default is EAGER)
            eg. @Basic(fetch=FetchType.LAZY) in this case the provider will delay
            loading the attribute untill it is referenced.i.e if an  emamil attribute
            is marked as such it will be empty when its containig instance is returned
            it will only be loaded when a reference to it is made.

*/
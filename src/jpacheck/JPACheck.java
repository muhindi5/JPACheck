/*
 *  Bitforge Software Labs
 *  (c)2017 
 *  http://bitforge.co.ke
 *  <muhindi@bitforge.co.ke><muhindi09@gmail.com>
 */
package jpacheck;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpacheck.dao.Address;

/**
 *
 * @author kelly
 */
public class JPACheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //connect and persist entity
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPACheckPU");
        EntityManager em = emf.createEntityManager();
        
        AddressManager addrMan  = new AddressManager(em);
        
        //create an address
        //addrMan.createAddress("mwadik@gmail.com", "+254 785 333 234", "Laikipia");
        
        //update an address
        //addrMan.updateAddress(5, new Address("mwadik@gmail.com","+000 894 435 224","London"));
        
        //delete an address
        //addrMan.removeAddress(4);
        
        
    }
    
}

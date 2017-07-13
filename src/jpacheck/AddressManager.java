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
import jdk.nashorn.internal.parser.TokenType;
import jpacheck.dao.Address;

/**
 *
 * @project: JPACheck
 * @author kelly
 * @date Jul 5, 2017 9:50:13 AM
 * 
 */
public class AddressManager {

    private EntityManager em;
    private static final Logger logger = Logger.getAnonymousLogger();
    
    public AddressManager(EntityManager em){
        this.em = em;
    }
    
    public boolean createAddress(String email,String phone,String town){
        em.getTransaction().begin();
        Address addr = new Address();
        addr.setEmail(email);
        addr.setPhone(phone);
        addr.setTown(town);
        em.persist(addr);
        em.getTransaction().commit();
        logger.log(Level.INFO, "Added to database");
        em.close();
        return true;
    }
    
    public boolean updateAddress(int addressId,Address addrUpdate){
        Address address = em.find(Address.class, addressId);
        if(address == null){
            logger.log(Level.INFO, "Could not find Adress id {0}...", addressId);
            System.exit(1);
        }
        logger.log(Level.INFO, "Updating record{0}...", address);
        em.getTransaction().begin();
        address.setEmail(addrUpdate.getEmail());
        address.setPhone(addrUpdate.getPhone());
        address.setTown(addrUpdate.getTown());
        em.persist(address);
        em.getTransaction().commit();
        Logger.getAnonymousLogger().log(Level.INFO, "Update Done");
        em.close();
        return true;
    }
    
    public boolean removeAddress(int addressId){
        Address address = em.find(Address.class, addressId);
        if(address == null){
            logger.log(Level.INFO, "Delete failed\nCould not find Adress id {0}...", addressId);
            System.exit(1);
        }
        logger.log(Level.INFO, "Deleting {0}...", address);
        em.getTransaction().begin();
        em.remove(address);
        em.getTransaction().commit();
        Logger.getAnonymousLogger().log(Level.INFO, "Done");
        em.close();
        return true;
    }
}

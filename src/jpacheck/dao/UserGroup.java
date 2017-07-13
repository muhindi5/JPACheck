/*
 *  Bitforge Software Labs
 *  (c)2017 
 *  http://bitforge.co.ke
 *  <muhindi@bitforge.co.ke><muhindi09@gmail.com>
 */
package jpacheck.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author kelly
 */
public enum UserGroup {
    author,
    member,
    admin,
    guest;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class ClienteSession implements ClienteSessionLocal {
    @PersistenceContext(unitName = "EffectiveExerciseDozen-ejbPU")
    private EntityManager em;

    
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public int codCliente() {
        
        Query q = em.createNativeQuery("select max(cliente_codigo) from cliente");
        
        Integer maxCod = (Integer)q.getSingleResult();
                
        return maxCod;
    }
    
    
}

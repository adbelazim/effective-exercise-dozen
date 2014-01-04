/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.cliente.entrenador;

import cl.dozen.www.entities.Entrenador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sergio
 */
@Stateless
public class EntrenadorNegocio implements EntrenadorNegocioLocal {
    @PersistenceContext(unitName = "EffectiveExerciseDozen-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public int verificarEntrenador(Entrenador entrenador) {
        Query q = em.createNamedQuery("Entrenador.findByEntrenadorRut", Entrenador.class).setParameter("entrenadorRut",entrenador.getEntrenadorRut());
        if(q.getResultList().size() > 0){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    
    
    
}

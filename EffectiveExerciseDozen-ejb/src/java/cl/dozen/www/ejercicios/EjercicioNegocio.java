/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.ejercicios;

import cl.dozen.www.entities.Ejercicio;
import cl.dozen.www.entities.TipoEjercicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sergio
 */
@Stateless
public class EjercicioNegocio implements EjercicioNegocioLocal {
    @PersistenceContext(unitName = "EffectiveExerciseDozen-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Ejercicio> buscarEjercicioRutina(TipoEjercicio tipoEjercicio) {
        Query q = em.createNativeQuery("select * from ejercicio where tipoEjercicio_tipoEjercicioId = ?1").setParameter(1,tipoEjercicio.getTipoEjercicioId()); 
        return q.getResultList();
    }

    
}

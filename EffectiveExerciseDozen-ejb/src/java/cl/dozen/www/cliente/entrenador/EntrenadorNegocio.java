/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.cliente.entrenador;

import cl.dozen.www.entities.Ejercicio;
import cl.dozen.www.entities.Entrenador;
import cl.dozen.www.entities.RutinaEjercicioEspecializada;
import cl.dozen.www.entities.RutinaEspecializada;
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

    @Override
    public int verificarEjecicioEnRutina(RutinaEjercicioEspecializada rutinaEjercicioEspecializada,Ejercicio ejercicio, RutinaEspecializada rutinaEspecializada) {        
        Query q = em.createNativeQuery("select * from rutinaEjercicioEspecializada where rutinaEspecializada_rutinaEspecializadaId = ?1 and ejercicio_ejercicioId = ?2") 
                .setParameter(1,rutinaEspecializada.getRutinaEspecializadaId()).
                setParameter(2,ejercicio.getEjercicioId());
        if(q.getResultList().size() > 0){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    
    
    
}

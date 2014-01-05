/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.RutinaEjercicioEspecializada;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rob_sandova
 */
@Stateless
public class RutinaEjercicioEspecializadaFacade extends AbstractFacade<RutinaEjercicioEspecializada> implements RutinaEjercicioEspecializadaFacadeLocal {
    @PersistenceContext(unitName = "EffectiveExerciseDozen-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RutinaEjercicioEspecializadaFacade() {
        super(RutinaEjercicioEspecializada.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.TipoEjercicio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class TipoEjercicioFacade extends AbstractFacade<TipoEjercicio> implements TipoEjercicioFacadeLocal {
    @PersistenceContext(unitName = "EffectiveExerciseDozen-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEjercicioFacade() {
        super(TipoEjercicio.class);
    }
    
}

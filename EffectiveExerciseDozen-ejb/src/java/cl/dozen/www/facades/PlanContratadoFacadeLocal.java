/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.PlanContratado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sergio
 */
@Local
public interface PlanContratadoFacadeLocal {

    void create(PlanContratado planContratado);

    void edit(PlanContratado planContratado);

    void remove(PlanContratado planContratado);

    PlanContratado find(Object id);

    List<PlanContratado> findAll();

    List<PlanContratado> findRange(int[] range);

    int count();
    
}

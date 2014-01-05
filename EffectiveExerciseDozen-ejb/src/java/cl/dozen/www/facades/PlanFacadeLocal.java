/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.Plan;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PlanFacadeLocal {

    void create(Plan plan);

    void edit(Plan plan);

    void remove(Plan plan);

    Plan find(Object id);

    List<Plan> findAll();

    List<Plan> findRange(int[] range);

    int count();
    
}

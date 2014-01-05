/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.TablaPGC;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TablaPGCFacadeLocal {

    void create(TablaPGC tablaPGC);

    void edit(TablaPGC tablaPGC);

    void remove(TablaPGC tablaPGC);

    TablaPGC find(Object id);

    List<TablaPGC> findAll();

    List<TablaPGC> findRange(int[] range);

    int count();
    
}

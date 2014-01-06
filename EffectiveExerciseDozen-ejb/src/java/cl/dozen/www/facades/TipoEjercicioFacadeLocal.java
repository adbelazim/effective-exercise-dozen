/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.TipoEjercicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipoEjercicioFacadeLocal {

    void create(TipoEjercicio tipoEjercicio);

    void edit(TipoEjercicio tipoEjercicio);

    void remove(TipoEjercicio tipoEjercicio);

    TipoEjercicio find(Object id);

    List<TipoEjercicio> findAll();

    List<TipoEjercicio> findRange(int[] range);

    int count();
    
}

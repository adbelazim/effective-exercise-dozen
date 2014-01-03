/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.HistorialPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rob_sandova
 */
@Local
public interface HistorialPagoFacadeLocal {

    void create(HistorialPago historialPago);

    void edit(HistorialPago historialPago);

    void remove(HistorialPago historialPago);

    HistorialPago find(Object id);

    List<HistorialPago> findAll();

    List<HistorialPago> findRange(int[] range);

    int count();
    
}

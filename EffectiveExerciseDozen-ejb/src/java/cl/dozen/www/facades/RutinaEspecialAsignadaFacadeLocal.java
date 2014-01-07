/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.RutinaEspecialAsignada;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sergio
 */
@Local
public interface RutinaEspecialAsignadaFacadeLocal {

    void create(RutinaEspecialAsignada rutinaEspecialAsignada);

    void edit(RutinaEspecialAsignada rutinaEspecialAsignada);

    void remove(RutinaEspecialAsignada rutinaEspecialAsignada);

    RutinaEspecialAsignada find(Object id);

    List<RutinaEspecialAsignada> findAll();

    List<RutinaEspecialAsignada> findRange(int[] range);

    int count();
    
}

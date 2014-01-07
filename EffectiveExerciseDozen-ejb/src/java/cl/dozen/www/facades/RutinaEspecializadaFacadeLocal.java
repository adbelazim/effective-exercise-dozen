/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.RutinaEspecializada;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sergio
 */
@Local
public interface RutinaEspecializadaFacadeLocal {

    void create(RutinaEspecializada rutinaEspecializada);

    void edit(RutinaEspecializada rutinaEspecializada);

    void remove(RutinaEspecializada rutinaEspecializada);

    RutinaEspecializada find(Object id);

    List<RutinaEspecializada> findAll();

    List<RutinaEspecializada> findRange(int[] range);

    int count();
    
}

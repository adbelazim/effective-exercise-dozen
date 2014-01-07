/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.RutinaEjercicioEspecializada;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sergio
 */
@Local
public interface RutinaEjercicioEspecializadaFacadeLocal {

    void create(RutinaEjercicioEspecializada rutinaEjercicioEspecializada);

    void edit(RutinaEjercicioEspecializada rutinaEjercicioEspecializada);

    void remove(RutinaEjercicioEspecializada rutinaEjercicioEspecializada);

    RutinaEjercicioEspecializada find(Object id);

    List<RutinaEjercicioEspecializada> findAll();

    List<RutinaEjercicioEspecializada> findRange(int[] range);

    int count();
    
}

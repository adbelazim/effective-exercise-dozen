/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.facades;

import cl.dozen.www.entities.Ejercicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rob_sandova
 */
@Local
public interface EjercicioFacadeLocal {

    void create(Ejercicio ejercicio);

    void edit(Ejercicio ejercicio);

    void remove(Ejercicio ejercicio);

    Ejercicio find(Object id);

    List<Ejercicio> findAll();

    List<Ejercicio> findRange(int[] range);

    int count();
    
}

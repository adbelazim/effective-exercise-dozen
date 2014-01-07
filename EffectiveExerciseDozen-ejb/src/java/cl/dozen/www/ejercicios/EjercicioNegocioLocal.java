/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.ejercicios;

import cl.dozen.www.entities.Ejercicio;
import cl.dozen.www.entities.TipoEjercicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sergio
 */
@Local
public interface EjercicioNegocioLocal {
    List<Ejercicio> buscarEjercicioRutina(TipoEjercicio tipoEjercicio);
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.cliente.entrenador;

import cl.dozen.www.entities.Ejercicio;
import cl.dozen.www.entities.Entrenador;
import cl.dozen.www.entities.RutinaEjercicioEspecializada;
import cl.dozen.www.entities.RutinaEspecializada;
import javax.ejb.Local;

/**
 *
 * @author sergio
 */
@Local
public interface EntrenadorNegocioLocal {
    int verificarEntrenador(Entrenador entrenador);
    int verificarEjecicioEnRutina(RutinaEjercicioEspecializada rutinaEjercicioEspecializada,Ejercicio ejercicio, RutinaEspecializada rutinaEspecializada);
    
}

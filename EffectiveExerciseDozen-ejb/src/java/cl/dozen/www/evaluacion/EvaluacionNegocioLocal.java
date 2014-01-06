/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.evaluacion;
import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.Evaluacion;
import cl.dozen.www.entities.TablaPGC;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EvaluacionNegocioLocal {
    
    /**
     *
     * @param evaluacion 
     */
    void agregarEvaluacion(Evaluacion evaluacion);
    int calcularEdad(Date fechaNacimiento);
    int calcularSuma(Evaluacion evaluacion);
    float calcularIMC(Evaluacion evaluacion);
    float calcularPGC(Evaluacion evaluacion, List<TablaPGC> tablaPGCs, Cliente cliente);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.cliente;

import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.HistorialPago;
import cl.dozen.www.entities.Plan;
import cl.dozen.www.entities.PlanContratado;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ClienteNegocioLocal {

    int crearCliente(Cliente cliente, Plan plan, PlanContratado planContratado, HistorialPago historialPago);
    void realizarPago(Cliente cliente, PlanContratado planContratado,HistorialPago historialPago);
    
}

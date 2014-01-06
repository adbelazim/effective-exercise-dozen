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
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ClienteNegocioLocal {

    int crearCliente(Cliente cliente, Plan plan, PlanContratado planContratado, HistorialPago historialPago);
    void realizarPago(Cliente cliente, PlanContratado planContratado,HistorialPago historialPago);
    int comprobarBoleta(HistorialPago historialPago);
    void cambiarPlan(Cliente cliente, PlanContratado planContratado, Plan plan);
    void editarCliente(Cliente cLiente);
    List<Cliente> busquedaClienteNombre(String clienteNombre);
    List<Cliente> busquedaClienteApellidoPaterno(String clienteApellidoPaterno);
    List<Cliente> busquedaClienteApellidoMaterno(String clienteApellidoMaterno);
    List<Cliente> busquedaClienteRut(int clienteRut);
    List<Cliente> busquedaClienteCodigo(int clienteCodigo);
    List<Cliente> busquedaClientePlan(PlanContratado planContratado);
}

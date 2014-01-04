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
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class ClienteNegocio implements ClienteNegocioLocal {
    @PersistenceContext(unitName = "EffectiveExerciseDozen-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
     public void edit(Object object) {
        em.merge(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

     @Override
    public void cambiarPlan(Cliente cliente, PlanContratado planContratado, Plan plan) {
        planContratado.setClienteclienteRut(cliente.getClienteRut());
        planContratado.setPlanplanId(plan);
        planContratado.setPlanContratadoFechaInicio(new Date());
       edit(planContratado);
    }

    @Override
    public int crearCliente(Cliente cliente, Plan plan, PlanContratado planContratado, HistorialPago historialPago) {
       //verificar rutHistorialPago historialPago
        Query q = em.createNamedQuery("Cliente.findByClienteRut",Cliente.class).setParameter("clienteRut", cliente.getClienteRut());
        // el cliente existe
        if(q.getResultList().size() > 0){
            return -1;
        }

        planContratado.setClienteclienteRut(cliente.getClienteRut());
        planContratado.setPlanplanId(plan);
        planContratado.setPlanContratadoFechaInicio(new Date());
        
        System.out.println(cliente.toString());
        System.out.println(plan.toString());
        System.out.println(planContratado.toString());
        System.out.println(historialPago.toString());
        
        
        // se inserta en la BD
        persist(cliente);
        persist(planContratado);
        
        realizarPago(cliente, planContratado,  historialPago);
    
      //  Query q2 = em.createNamedQuery("Cliente.findByClienteRut",Cliente.class).setParameter("clienteRut", cliente.getClienteRut());
        
        Query q2 = em.createNativeQuery("select clienteCodigo from cliente where clienteRut = ?1").setParameter(1,cliente.getClienteRut());
        
        int cl = (int)(q2.getResultList().get(0));
        
        System.out.println("cod"+cl);
        
        return cl;
    }

    @Override
    public void realizarPago(Cliente cliente, PlanContratado planContratado, HistorialPago historialPago) {
        
        historialPago.setHistorialPagoMonto(planContratado.getPlanContratadoMonto());
        historialPago.setHistorialPagoFechaPago(new Date());
        historialPago.setClienteclienteRut(cliente);
        historialPago.setHistorialPagoObservacion(planContratado.getPlanContratadoObservacion());
        
        persist(historialPago);
        
    }
  

    @Override
    public void editarCliente(Cliente cLiente) { 
       
    }

    @Override
    public List<Cliente> busquedaClienteNombre(String clienteNombre) {
        Query q = em.createNamedQuery("Cliente.findByClienteNombre").setParameter("clienteNombre", clienteNombre);  
        return q.getResultList();
    }

    @Override
    public List<Cliente> busquedaClienteRut(int clienteRut) {
        
        Query q = em.createNamedQuery("Cliente.findByClienteRut").setParameter("clienteRut", clienteRut);  
        return q.getResultList();
    }

    @Override
    public List<Cliente> busquedaClienteCodigo(int clienteCodigo) {
        Query q = em.createNamedQuery("Cliente.findByClienteCodigo").setParameter("clienteCodigo", clienteCodigo);  
        return q.getResultList();
    }

    @Override
    public List<Cliente> busquedaClienteApellidoPaterno(String clienteApellidoPaterno) {
        Query q = em.createNamedQuery("Cliente.findByClienteApellidoPaterno").setParameter("clienteApellidoPaterno", "%"+clienteApellidoPaterno+"%");  
        return q.getResultList();
    }

    @Override
    public List<Cliente> busquedaClienteApellidoMaterno(String clienteApellidoMaterno) {
        Query q = em.createNamedQuery("Cliente.findByClienteApellidoMaterno").setParameter("clienteApellidoMaterno", clienteApellidoMaterno);  
        return q.getResultList();
    }

    @Override
    public List<Cliente> busquedaClientePlan(PlanContratado planContratado) {
        return null;
    }

   
   
    
    
    
    


}

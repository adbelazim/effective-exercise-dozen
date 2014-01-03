/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.cliente.ClienteNegocioLocal;
import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.HistorialPago;
import cl.dozen.www.entities.Plan;
import cl.dozen.www.entities.PlanContratado;
import cl.dozen.www.facades.ClienteFacadeLocal;
import cl.dozen.www.facades.HistorialPagoFacade;
import cl.dozen.www.facades.HistorialPagoFacadeLocal;
import cl.dozen.www.facades.PlanFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped
public class AgregarPago {
    @EJB
    ClienteNegocioLocal clienteNegocioLocal;
     @EJB
    private ClienteFacadeLocal clienteFacade;
    //me permite obtener todos los planes desdes la DB
    
    @EJB
    private PlanFacadeLocal planFacade;
    //manater conversacion entre datos
    private List<Plan> planes;
    private Plan planSeleccionado;
    //relacion entre plan seleccionado con cliente
    private PlanContratado planContratado;
    private HistorialPago historialPago;
    private Cliente cliente;
    private Integer clienteRut;

    public ClienteNegocioLocal getClienteNegocioLocal() {
        return clienteNegocioLocal;
    }

    public Integer getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(Integer clienteRut) {
        this.clienteRut = clienteRut;
    }

    
    
    public void setClienteNegocioLocal(ClienteNegocioLocal clienteNegocioLocal) {
        this.clienteNegocioLocal = clienteNegocioLocal;
    }

    public ClienteFacadeLocal getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacadeLocal clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public PlanFacadeLocal getPlanFacade() {
        return planFacade;
    }

    public void setPlanFacade(PlanFacadeLocal planFacade) {
        this.planFacade = planFacade;
    }

    public List<Plan> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plan> planes) {
        this.planes = planes;
    }

    public Plan getPlanSeleccionado() {
        return planSeleccionado;
    }

    public void setPlanSeleccionado(Plan planSeleccionado) {
        this.planSeleccionado = planSeleccionado;
    }

    public PlanContratado getPlanContratado() {
        return planContratado;
    }

    public void setPlanContratado(PlanContratado planContratado) {
        this.planContratado = planContratado;
    }

    public HistorialPago getHistorialPago() {
        return historialPago;
    }

    public void setHistorialPago(HistorialPago historialPago) {
        this.historialPago = historialPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
    
    
    @PostConstruct
    public void init() {

        cliente = new Cliente();
        
        planes = planFacade.findAll();

        planContratado = new PlanContratado();

        historialPago = new HistorialPago();    
    }
   
    public void agregarPago(){
        cliente.setClienteRut(clienteRut);
        
        clienteNegocioLocal.realizarPago(cliente, planContratado, historialPago);
      
        
    }
     public void onRowSelect() {
        planContratado.setPlanContratadoMonto(planSeleccionado.getPlanPrecio());
    }
    
}

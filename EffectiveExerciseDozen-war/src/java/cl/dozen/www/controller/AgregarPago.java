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
import cl.dozen.www.facades.PlanContratadoFacadeLocal;
import cl.dozen.www.facades.PlanFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class AgregarPago implements Serializable {
    @EJB
    ClienteNegocioLocal clienteNegocio;
            
    @EJB
    private PlanFacadeLocal planFacade;
    @EJB
    private PlanContratadoFacadeLocal planContratadoFacade;        
    
    private List<Cliente> clientes;
    
    private String buscado;
    
    private String opcion;
    
    private Cliente clienteSeleccionado;
    
    //datos pago
    
    
    private HistorialPago historialPago;
    
    private Plan plan;
    private PlanContratado planContratado;
    
    public AgregarPago(){
    
 
    }
    
    @PostConstruct
    public void init(){
       
        clienteSeleccionado = new Cliente();
        historialPago = new HistorialPago();
   
    }
    
    public void buscar(){
    
        
        System.out.println("opcion "+opcion+"buscado "+buscado);
        
        switch(opcion){
        
            case "codigo":
                try{
                    clientes =  clienteNegocio.busquedaClienteCodigo(Integer.parseInt(buscado));
                }
                catch(NumberFormatException ex){
                    clientes =  clienteNegocio.busquedaClienteCodigo(-1);
                     
                }
                break;
                
            case "rut":
                try{
                    clientes = clienteNegocio.busquedaClienteRut(Integer.parseInt(buscado));
                }
                catch(NumberFormatException ex){
                    clientes = clienteNegocio.busquedaClienteRut(-1);
                }
                break;
                
            case "apellido":
                clientes = clienteNegocio.busquedaClienteApellidoPaterno(buscado);
                break;
                
            default:
                
                break;
        }

    }
    
    public void agregarPago(){        
        System.out.println(clienteSeleccionado.toString());
        
        clienteNegocio.realizarPago(clienteSeleccionado, planContratado, historialPago);      
        
       FacesContext context;
       context = FacesContext.getCurrentInstance();
       context.addMessage(null , new FacesMessage("Exito", "Pago Realizado")); 
       historialPago.setHistorialPagoNumeroBoleta(0);
        
    }
    
    public void actualizarPlan(){
         planContratado = planContratadoFacade.find(clienteSeleccionado.getClienteRut());
         plan = planFacade.find(planContratado.getPlanplanId().getPlanId());
         
    }

    public ClienteNegocioLocal getClienteNegocio() {
        return clienteNegocio;
    }

    public void setClienteNegocio(ClienteNegocioLocal clienteNegocio) {
        this.clienteNegocio = clienteNegocio;
    }

    public PlanFacadeLocal getPlanFacade() {
        return planFacade;
    }

    public void setPlanFacade(PlanFacadeLocal planFacade) {
        this.planFacade = planFacade;
    }

    public PlanContratadoFacadeLocal getPlanContratadoFacade() {
        return planContratadoFacade;
    }

    public void setPlanContratadoFacade(PlanContratadoFacadeLocal planContratadoFacade) {
        this.planContratadoFacade = planContratadoFacade;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getBuscado() {
        return buscado;
    }

    public void setBuscado(String buscado) {
        this.buscado = buscado;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    public HistorialPago getHistorialPago() {
        return historialPago;
    }

    public void setHistorialPago(HistorialPago historialPago) {
        this.historialPago = historialPago;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public PlanContratado getPlanContratado() {
        return planContratado;
    }

    public void setPlanContratado(PlanContratado planContratado) {
        this.planContratado = planContratado;
    }

    
}
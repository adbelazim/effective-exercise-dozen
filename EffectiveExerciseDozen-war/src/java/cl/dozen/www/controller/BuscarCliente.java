/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.cliente.ClienteNegocioLocal;
import cl.dozen.www.entities.Asistencia;
import cl.dozen.www.entities.AsistenciaPK;
import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.HistorialPago;
import cl.dozen.www.entities.Plan;
import cl.dozen.www.entities.PlanContratado;
import cl.dozen.www.facades.AsistenciaFacadeLocal;
import cl.dozen.www.facades.ClienteFacadeLocal;
import cl.dozen.www.facades.PlanContratadoFacadeLocal;
import cl.dozen.www.facades.PlanFacadeLocal;
import java.io.Serializable;
import java.util.Date;
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
public class BuscarCliente implements Serializable{
    @EJB
    private PlanFacadeLocal planFacade;
    @EJB
    private PlanContratadoFacadeLocal planContratadoFacade;
    @EJB
    private AsistenciaFacadeLocal asistenciaFacade;
    @EJB
    private ClienteNegocioLocal clienteNegocio;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    
    private List<Cliente> clientes;
    
    private String buscado;
    
    private String opcion;
    
    private Cliente clienteSeleccionado;
    
    //Datos de la asistencia
    
    Asistencia asistencia;
    AsistenciaPK asistenciapk;
    
    private Integer clienteRut;
    private boolean maquinaAsistencia;  
    private boolean claseAsistencia; 
   
    //datos pago
    
    
    private HistorialPago historialPago;
    
    private Plan plan;
    private PlanContratado planContratado;
   

    public BuscarCliente() {
    }
    
    @PostConstruct
    public void init(){
       
        clienteSeleccionado = new Cliente();
        historialPago = new HistorialPago();
        planContratado = new PlanContratado();
        
        
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
    
    public void actualizar(){
        
        System.out.println(clienteSeleccionado.toString());
        clienteFacade.edit(clienteSeleccionado);
        FacesContext context;
        context = FacesContext.getCurrentInstance();
        context.addMessage(null , new FacesMessage("", "Datos actualizados"));

    }
    public void integrarAsistencia(){
       System.out.println(claseAsistencia); 
       
       clienteRut = clienteSeleccionado.getClienteRut();
       asistenciapk = new AsistenciaPK(clienteRut, new Date());       
       asistencia = new Asistencia(asistenciapk, maquinaAsistencia, claseAsistencia);
       asistenciaFacade.create(asistencia);
       FacesContext context;
       context = FacesContext.getCurrentInstance();
       context.addMessage(null , new FacesMessage("Exito", "Asistencia agregada con exito")); 
        
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

    public ClienteFacadeLocal getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacadeLocal clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public Integer getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(Integer clienteRut) {
        this.clienteRut = clienteRut;
    }

    public boolean isMaquinaAsistencia() {
        return maquinaAsistencia;
    }

    public void setMaquinaAsistencia(boolean maquinaAsistencia) {
        this.maquinaAsistencia = maquinaAsistencia;
    }

    public boolean isClaseAsistencia() {
        return claseAsistencia;
    }

    public void setClaseAsistencia(boolean claseAsistencia) {
        this.claseAsistencia = claseAsistencia;
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

    public PlanContratado getPlanContratado() {
        return planContratado;
    }

    public void setPlanContratado(PlanContratado planContratado) {
        this.planContratado = planContratado;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    
}

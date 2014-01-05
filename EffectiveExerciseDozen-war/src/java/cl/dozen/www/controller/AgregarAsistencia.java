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
import cl.dozen.www.facades.AsistenciaFacadeLocal;
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
public class AgregarAsistencia implements Serializable {
    @EJB
    ClienteNegocioLocal clienteNegocio;
            
    @EJB
    private AsistenciaFacadeLocal asistenciaFacade;
            
    
    
    private List<Cliente> clientes;
    
    private String buscado;
    
    private String opcion;
    
    private Cliente clienteSeleccionado;
    
    Asistencia asistencia;
    AsistenciaPK asistenciapk;
    
    private Integer clienteRut;
    private boolean maquinaAsistencia;  
    private boolean claseAsistencia; 
   
    
    
    
    public AgregarAsistencia(){
    
 
    }
    
 
     
     
    @PostConstruct
    public void init(){
       
        clienteSeleccionado = new Cliente();
        
   
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

    public ClienteNegocioLocal getClienteNegocio() {
        return clienteNegocio;
    }

    public void setClienteNegocio(ClienteNegocioLocal clienteNegocio) {
        this.clienteNegocio = clienteNegocio;
    }

    public AsistenciaFacadeLocal getAsistenciaFacade() {
        return asistenciaFacade;
    }

    public void setAsistenciaFacade(AsistenciaFacadeLocal asistenciaFacade) {
        this.asistenciaFacade = asistenciaFacade;
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

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public AsistenciaPK getAsistenciapk() {
        return asistenciapk;
    }

    public void setAsistenciapk(AsistenciaPK asistenciapk) {
        this.asistenciapk = asistenciapk;
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
     
     
}
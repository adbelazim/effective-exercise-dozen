/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;


import cl.dozen.www.cliente.ClienteNegocioLocal;
import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.RutinaEspecialAsignada;
import cl.dozen.www.entities.RutinaEspecializada;
import cl.dozen.www.facades.ClienteFacadeLocal;
import cl.dozen.www.facades.RutinaEspecialAsignadaFacadeLocal;
import cl.dozen.www.facades.RutinaEspecializadaFacadeLocal;
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
 * @author sergio
 */
@Named
@SessionScoped

public class AsignarRutinaEspecializada implements Serializable{
    @EJB
    private ClienteNegocioLocal clienteNegocio;
    @EJB
    private RutinaEspecializadaFacadeLocal rutinaEspecializadaFacade;
    @EJB
    private RutinaEspecialAsignadaFacadeLocal rutinaEspecialAsignadaFacade;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    private List<Cliente> clientes;
    private Cliente clienteSeleccionado;
    private List<RutinaEspecializada> rutinasEspecializadas;
    private String buscado;    
    private String opcion;
    private RutinaEspecializada rutinaEspecializadaSelec;
    private RutinaEspecialAsignada rutinaEspecialAsignada;
    
    private Integer clienteRut;
    private Integer rutinaEspecializadaId;
    private Date fechaInicio;
    private Date fechaTermino;
    private String comentarios;
    
    public AsignarRutinaEspecializada() {
    }
    
    @PostConstruct
    public void init(){
        rutinaEspecialAsignada = new RutinaEspecialAsignada();
        clientes = clienteFacade.findAll();
        rutinasEspecializadas = rutinaEspecializadaFacade.findAll();
    }    
    
    public void onRowSelectRutina(){        
        rutinaEspecialAsignada.setRutinaEspecializadarutinaEspecializadaId(rutinaEspecializadaSelec);
        rutinaEspecialAsignada.setClienteclienteRut(clienteSeleccionado);  
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
    public void asignarRutina(){
        rutinaEspecialAsignada.setRutinaEspecialAsignadaComentario(comentarios);
        rutinaEspecialAsignada.setRutinaEspecialAsignadaInicio(fechaInicio);
        rutinaEspecialAsignada.setRutinaEspecialAsignadaTermino(fechaTermino);
        rutinaEspecialAsignadaFacade.create(rutinaEspecialAsignada);
        FacesContext context;
        context = FacesContext.getCurrentInstance();
        context.addMessage(null , new FacesMessage("Exito", "Rutina asignada al cliente"));        
    }

    public RutinaEspecializadaFacadeLocal getRutinaEspecializadaFacade() {
        return rutinaEspecializadaFacade;
    }

    public void setRutinaEspecializadaFacade(RutinaEspecializadaFacadeLocal rutinaEspecializadaFacade) {
        this.rutinaEspecializadaFacade = rutinaEspecializadaFacade;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<RutinaEspecializada> getRutinasEspecializadas() {
        return rutinasEspecializadas;
    }

    public void setRutinasEspecializadas(List<RutinaEspecializada> rutinasEspecializadas) {
        this.rutinasEspecializadas = rutinasEspecializadas;
    }
      

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

  

    public RutinaEspecialAsignadaFacadeLocal getRutinaEspecialAsignadaFacade() {
        return rutinaEspecialAsignadaFacade;
    }

    public void setRutinaEspecialAsignadaFacade(RutinaEspecialAsignadaFacadeLocal rutinaEspecialAsignadaFacade) {
        this.rutinaEspecialAsignadaFacade = rutinaEspecialAsignadaFacade;
    }

    public ClienteFacadeLocal getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacadeLocal clienteFacade) {
        this.clienteFacade = clienteFacade;
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

    public RutinaEspecializada getRutinaEspecializadaSelec() {
        return rutinaEspecializadaSelec;
    }

    public void setRutinaEspecializadaSelec(RutinaEspecializada rutinaEspecializadaSelec) {
        this.rutinaEspecializadaSelec = rutinaEspecializadaSelec;
    }

    public RutinaEspecialAsignada getRutinaEspecialAsignada() {
        return rutinaEspecialAsignada;
    }

    public void setRutinaEspecialAsignada(RutinaEspecialAsignada rutinaEspecialAsignada) {
        this.rutinaEspecialAsignada = rutinaEspecialAsignada;
    }

    public Integer getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(Integer clienteRut) {
        this.clienteRut = clienteRut;
    }

    public Integer getRutinaEspecializadaId() {
        return rutinaEspecializadaId;
    }

    public void setRutinaEspecializadaId(Integer rutinaEspecializadaId) {
        this.rutinaEspecializadaId = rutinaEspecializadaId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
    

    
    
    
}

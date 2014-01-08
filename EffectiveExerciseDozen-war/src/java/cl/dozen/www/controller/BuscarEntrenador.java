/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//hola
package cl.dozen.www.controller;

import cl.dozen.www.cliente.entrenador.EntrenadorNegocioLocal;
import cl.dozen.www.entities.Entrenador;
import cl.dozen.www.facades.EntrenadorFacadeLocal;
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
public class BuscarEntrenador implements Serializable{
    @EJB
    private EntrenadorFacadeLocal entrenadorFacade;
    @EJB
    private EntrenadorNegocioLocal entrenadorNegocio;
    
    
    private List<Entrenador> entrenadores;
    
    private String opcion;
    
    private String buscado;
    
    private Entrenador entrenadorSeleccionado;

    public BuscarEntrenador() {
    }
    
    @PostConstruct
    public void init(){
        entrenadorSeleccionado = new Entrenador();
    }
    public void buscar(){
    
        
        System.out.println("opcion "+opcion+"buscado "+buscado);
        
        switch(opcion){
             
            case "rut":
                try{
                    entrenadores = entrenadorNegocio.buscarEntrenadorRut(Integer.parseInt(buscado));
                }
                catch(NumberFormatException ex){
                    entrenadores = entrenadorNegocio.buscarEntrenadorRut(-1);
                }
                break;
                
            case "apellido":
                entrenadores = entrenadorNegocio.buscarEntrenadorApellidoPaterno(buscado);
                break;
                
            default:
                
                break;
        }

    }
    
    public void actualizar(){
        
        System.out.println(entrenadorSeleccionado.toString());
        entrenadorFacade.edit(entrenadorSeleccionado);
        FacesContext context;
        context = FacesContext.getCurrentInstance();
        context.addMessage(null , new FacesMessage("", "Datos actualizados"));

    }

    public EntrenadorNegocioLocal getEntrenadorNegocio() {
        return entrenadorNegocio;
    }

    public void setEntrenadorNegocio(EntrenadorNegocioLocal entrenadorNegocio) {
        this.entrenadorNegocio = entrenadorNegocio;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getBuscado() {
        return buscado;
    }

    public void setBuscado(String buscado) {
        this.buscado = buscado;
    }

    public Entrenador getEntrenadorSeleccionado() {
        return entrenadorSeleccionado;
    }

    public void setEntrenadorSeleccionado(Entrenador entrenadorSeleccionado) {
        this.entrenadorSeleccionado = entrenadorSeleccionado;
    }
    
}
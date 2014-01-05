/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.entities.TipoEjercicio;
import cl.dozen.www.facades.TipoEjercicioFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@RequestScoped
public class AgregarTipoEjercicio {
    @EJB
    private TipoEjercicioFacadeLocal tipoEjercicioFacade;
    
    private TipoEjercicio tipoEjercicio;
    private String tipoEjercicioNombre;
    private String tipoEjercicioDescripcion;
    
    @PostConstruct
    
    public void init(){
        tipoEjercicio = new TipoEjercicio();
    }
    
    public void agregarTipoEjercicio(){
        tipoEjercicio.setTipoEjercicioNombre(tipoEjercicioNombre);
        tipoEjercicio.setTipoEjercicioDescripcion(tipoEjercicioDescripcion);
        tipoEjercicioFacade.create(tipoEjercicio);
        FacesContext context;
        context = FacesContext.getCurrentInstance();
        context.addMessage(null , new FacesMessage("Exito", "Ejercicio Creado"));
    
    
    }

    public String getTipoEjercicioDescripcion() {
        return tipoEjercicioDescripcion;
    }

    public void setTipoEjercicioDescripcion(String tipoEjercicioDescripcion) {
        this.tipoEjercicioDescripcion = tipoEjercicioDescripcion;
    }

    
    public TipoEjercicio getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(TipoEjercicio tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public String getTipoEjercicioNombre() {
        return tipoEjercicioNombre;
    }

    public void setTipoEjercicioNombre(String tipoEjercicioNombre) {
        this.tipoEjercicioNombre = tipoEjercicioNombre;
    }
    
    
}

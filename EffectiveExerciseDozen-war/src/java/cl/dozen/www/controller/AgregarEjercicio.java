/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.entities.Ejercicio;
import cl.dozen.www.entities.TipoEjercicio;
import cl.dozen.www.facades.EjercicioFacadeLocal;
import cl.dozen.www.facades.TipoEjercicioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
public class AgregarEjercicio implements Serializable{
    @EJB
    private EjercicioFacadeLocal ejercicioFacade;
    @EJB
    private TipoEjercicioFacadeLocal tipoEjercicioFacade;
    private String nombre;
    private String comentario;
    private TipoEjercicio tipoEjercicioSelecciondo;
    private List<TipoEjercicio> tipoEjercicios;
    private Ejercicio ejercicio;
    private String link;
    
    public AgregarEjercicio() {
    
    }
    
    @PostConstruct
    public void init(){
        ejercicio = new Ejercicio();
        tipoEjercicios = tipoEjercicioFacade.findAll();
        
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    public TipoEjercicioFacadeLocal getTipoEjercicioFacade() {
        return tipoEjercicioFacade;
    }

    public void setTipoEjercicioFacade(TipoEjercicioFacadeLocal tipoEjercicioFacade) {
        this.tipoEjercicioFacade = tipoEjercicioFacade;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public TipoEjercicio getTipoEjercicioSelecciondo() {
        return tipoEjercicioSelecciondo;
    }

    public void setTipoEjercicioSelecciondo(TipoEjercicio tipoEjercicioSelecciondo) {
        this.tipoEjercicioSelecciondo = tipoEjercicioSelecciondo;
    }

    public List<cl.dozen.www.entities.TipoEjercicio> getTipoEjercicios() {
        return tipoEjercicios;
    }

    public void setTipoEjercicios(List<cl.dozen.www.entities.TipoEjercicio> tipoEjercicios) {
        this.tipoEjercicios = tipoEjercicios;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

   
 
    public void onRowSelect(){
        ejercicio.setTipoEjerciciotipoEjercicioId(tipoEjercicioSelecciondo);
        
    }
    public void ingresarEjercicio(){
        ejercicio.setEjercicioDescripcion(comentario);
        ejercicio.setEjercicioNombre(nombre);
        ejercicio.setEjercicioLink(link);
        System.out.println(ejercicio.toString());
        ejercicioFacade.create(ejercicio);
        FacesContext context;
        context = FacesContext.getCurrentInstance();
        context.addMessage(null , new FacesMessage("Exito", "Ejercicio Creado"));
    }
    
    
}

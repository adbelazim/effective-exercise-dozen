/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.entities.Ejercicio;
import cl.dozen.www.entities.RutinaEjercicioEspecializada;
import cl.dozen.www.entities.RutinaEspecializada;
import cl.dozen.www.facades.EjercicioFacadeLocal;
import cl.dozen.www.facades.RutinaEjercicioEspecializadaFacadeLocal;
import cl.dozen.www.facades.RutinaEspecializadaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author rob_sandova
 */
@Named
@SessionScoped
public class AsignarEjercicioRutinaEsp implements Serializable{
    @EJB
    private RutinaEjercicioEspecializadaFacadeLocal rutinaEjercicioEspecializadaFacade;
    @EJB
    private RutinaEspecializadaFacadeLocal rutinaEspecializadaFacade;
    @EJB
    private EjercicioFacadeLocal ejercicioFacade;
    
    
    private int repeticion;
    private int serie;
    private Float peso;
    private String observacion;
    private RutinaEjercicioEspecializada rutinaEjercicioEspecializada;
    
    
    private Ejercicio  ejercicioSeleccionado;
    private List<Ejercicio> ejercicios;
   
    
    private RutinaEspecializada rutinaSeleccionada;
    private List<RutinaEspecializada> listaRutina;
       
    
    public AsignarEjercicioRutinaEsp() {
    }
    
    @PostConstruct
    public void init(){
        rutinaEjercicioEspecializada = new RutinaEjercicioEspecializada();
       
        ejercicios = ejercicioFacade.findAll();
        listaRutina = rutinaEspecializadaFacade.findAll();
                
    }
    
      public void onRowSelectEjercicio(){
        rutinaEjercicioEspecializada.setEjercicioejercicioId(ejercicioSeleccionado);
 
    }
      public void onRowSelectRutina(){
        rutinaEjercicioEspecializada.setRutinaEspecializadarutinaEspecializadaId(rutinaSeleccionada);
      }

      public void agregar(){
          
          rutinaEjercicioEspecializada.setRutinaEjercicioEspecializadaSerie(serie);
          rutinaEjercicioEspecializada.setRutinaEjercicioEspecializadaRepeticion(repeticion);
          rutinaEjercicioEspecializada.setRutinaEjercicioEspecializadaPeso(peso);
          rutinaEjercicioEspecializada.setRutinaEjercicioEspecializadaObservacion(observacion);
          System.out.println(rutinaEjercicioEspecializada.toString());
          rutinaEjercicioEspecializadaFacade.create(rutinaEjercicioEspecializada);
          FacesContext context;
          context = FacesContext.getCurrentInstance();
          context.addMessage(null , new FacesMessage("Exito", "Ejercicio asignado a la rutina"));
      }
    public EjercicioFacadeLocal getEjercicioFacade() {
        return ejercicioFacade;
    }

    public void setEjercicioFacade(EjercicioFacadeLocal ejercicioFacade) {
        this.ejercicioFacade = ejercicioFacade;
    }

    public Ejercicio getEjercicioSeleccionado() {
        return ejercicioSeleccionado;
    }

    public void setEjercicioSeleccionado(Ejercicio ejercicioSeleccionado) {
        this.ejercicioSeleccionado = ejercicioSeleccionado;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

   
    public RutinaEspecializadaFacadeLocal getRutinaEspecializadaFacade() {
        return rutinaEspecializadaFacade;
    }

    public void setRutinaEspecializadaFacade(RutinaEspecializadaFacadeLocal rutinaEspecializadaFacade) {
        this.rutinaEspecializadaFacade = rutinaEspecializadaFacade;
    }

    public RutinaEspecializada getRutinaSeleccionada() {
        return rutinaSeleccionada;
    }

    public void setRutinaSeleccionada(RutinaEspecializada rutinaSeleccionada) {
        this.rutinaSeleccionada = rutinaSeleccionada;
    }

    public List<RutinaEspecializada> getListaRutina() {
        return listaRutina;
    }

    public void setListaRutina(List<RutinaEspecializada> listaRutina) {
        this.listaRutina = listaRutina;
    }

    public int getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(int repeticion) {
        this.repeticion = repeticion;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public RutinaEjercicioEspecializada getRutinaEjercicioEspecializada() {
        return rutinaEjercicioEspecializada;
    }

    public void setRutinaEjercicioEspecializada(RutinaEjercicioEspecializada rutinaEjercicioEspecializada) {
        this.rutinaEjercicioEspecializada = rutinaEjercicioEspecializada;
    }

    public RutinaEjercicioEspecializadaFacadeLocal getRutinaEjercicioEspecializadaFacade() {
        return rutinaEjercicioEspecializadaFacade;
    }

    public void setRutinaEjercicioEspecializadaFacade(RutinaEjercicioEspecializadaFacadeLocal rutinaEjercicioEspecializadaFacade) {
        this.rutinaEjercicioEspecializadaFacade = rutinaEjercicioEspecializadaFacade;
    }
    
    

    
      
    
}

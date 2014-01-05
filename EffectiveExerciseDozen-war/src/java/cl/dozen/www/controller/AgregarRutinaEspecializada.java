/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.entities.Entrenador;
import cl.dozen.www.entities.RutinaEspecializada;
import cl.dozen.www.facades.RutinaEspecializadaFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author rob_sandova
 */
@Named
@RequestScoped
public class AgregarRutinaEspecializada {

    @EJB
    private RutinaEspecializadaFacadeLocal rutinaEspecializadaFacade;
    
    private int rutEntrenador;
    private RutinaEspecializada rutina;
    private Entrenador entrenador;
    private String nombreRutinaEsp;
    private String descripcionRutinaEsp;
    private String objetivoRutinaEsp;

    public int getRutEntrenador() {
        return rutEntrenador;
    }

    public void setRutEntrenador(int rutEntrenador) {
        this.rutEntrenador = rutEntrenador;
    }

    public RutinaEspecializada getRutina() {
        return rutina;
    }

    public void setRutina(RutinaEspecializada rutina) {
        this.rutina = rutina;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

  
    
    

    public RutinaEspecializadaFacadeLocal getRutinaEspecializadaFacade() {
        return rutinaEspecializadaFacade;
    }

    public void setRutinaEspecializadaFacade(RutinaEspecializadaFacadeLocal rutinaEspecializadaFacade) {
        this.rutinaEspecializadaFacade = rutinaEspecializadaFacade;
    }

    public String getNombreRutinaEsp() {
        return nombreRutinaEsp;
    }

    public void setNombreRutinaEsp(String nombreRutinaEsp) {
        this.nombreRutinaEsp = nombreRutinaEsp;
    }

    public String getDescripcionRutinaEsp() {
        return descripcionRutinaEsp;
    }

    public void setDescripcionRutinaEsp(String descripcionRutinaEsp) {
        this.descripcionRutinaEsp = descripcionRutinaEsp;
    }

    public String getObjetivoRutinaEsp() {
        return objetivoRutinaEsp;
    }

    public void setObjetivoRutinaEsp(String objetivoRutinaEsp) {
        this.objetivoRutinaEsp = objetivoRutinaEsp;
    }
    
    
    
    public AgregarRutinaEspecializada() {
    }
  
    @PostConstruct
    public void init(){
        rutina = new RutinaEspecializada();
        entrenador = new Entrenador();
                
                
    }
    public void agregarRutina(){
        entrenador.setEntrenadorRut(rutEntrenador);
        rutina.setEntrenadorentrenadorRut(entrenador);
        rutina.setRutinaEspecializadaNombre(nombreRutinaEsp);
        rutina.setRutinaEspecializadaDescripcion(descripcionRutinaEsp);
        rutina.setRutinaEspecializadaObjetivo(objetivoRutinaEsp);
        rutinaEspecializadaFacade.create(rutina);
         FacesContext context = FacesContext.getCurrentInstance();
         context.addMessage(null, new FacesMessage("Exito", "Rutina Especializada agregada con éxito"));
    
    }
   
    
    
    
    
}

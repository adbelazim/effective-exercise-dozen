/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.entities.Ejercicio;
import cl.dozen.www.facades.EjercicioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sergio
 */
@Named
@ConversationScoped
public class VerEjercicio implements Serializable{
    @EJB
    private EjercicioFacadeLocal ejercicioFacade;
    @Inject
    private Conversation conversation;
    private List<Ejercicio> ejercicios;
    private Ejercicio ejercicioSeleccionado;

    public VerEjercicio() {
    }
    
       public void beginConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    public void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
    
    @PostConstruct
    public void init(){
        ejercicios = ejercicioFacade.findAll();
        
    }
    
    public EjercicioFacadeLocal getEjercicioFacade() {
        return ejercicioFacade;
    }

    public void setEjercicioFacade(EjercicioFacadeLocal ejercicioFacade) {
        this.ejercicioFacade = ejercicioFacade;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public Ejercicio getEjercicioSeleccionado() {
        return ejercicioSeleccionado;
    }

    public void setEjercicioSeleccionado(Ejercicio ejercicioSeleccionado) {
        this.ejercicioSeleccionado = ejercicioSeleccionado;
    }
    
    
}

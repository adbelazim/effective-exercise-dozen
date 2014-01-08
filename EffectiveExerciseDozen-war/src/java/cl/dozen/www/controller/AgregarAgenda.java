/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dozen.www.controller;

import cl.dozen.www.cliente.entrenador.EntrenadorNegocioLocal;
import cl.dozen.www.entities.Agenda;
import cl.dozen.www.entities.Entrenador;
import cl.dozen.www.facades.AgendaFacadeLocal;
import cl.dozen.www.facades.EntrenadorFacadeLocal;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@RequestScoped
public class AgregarAgenda implements Serializable {

    @EJB
    private EntrenadorNegocioLocal entrenadorNegocio;
    @EJB
    private EntrenadorFacadeLocal entrenadorFacade;
    @EJB
    private AgendaFacadeLocal agendaFacade;

    private Agenda agenda;
    private Entrenador entrenador;
    private String agendaHora;
    private Date hora;
    private String agendaFecha;

    public AgregarAgenda() {
    }

    @PostConstruct
    public void init() {
        entrenador = new Entrenador();
        agenda = new Agenda();
        System.out.println("hola mama");
    }
    
    public void agregarHorario() throws ParseException {
        if (agenda.getAgendaFecha() == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage("Ingrese fecha por favor"));
        } else {
            
            agenda.setEntrenadorentrenadorRut(entrenador);
            DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            hora = sdf.parse(agendaHora);

            agenda.setAgendaHora(hora);

            System.out.println(agendaFecha);

            agenda.setAgendaDisponible(true);
            System.out.println(agenda.toString());
            if (entrenadorNegocio.verificarEntrenador(entrenador) == -1) {
                entrenadorNegocio.agregarAgenda(agenda);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("", new FacesMessage("Agenda realizada con exito"));

            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("", new FacesMessage("El entrenador no existe, ingrese rut válido"));

            }

        }

    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getAgendaHora() {
        return agendaHora;
    }

    public void setAgendaHora(String agendaHora) {
        this.agendaHora = agendaHora;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getAgendaFecha() {
        return agendaFecha;
    }

    public void setAgendaFecha(String agendaFecha) {
        this.agendaFecha = agendaFecha;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.entities.Agenda;
import cl.dozen.www.facades.AgendaFacadeLocal;
import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import java.text.SimpleDateFormat;  

import java.util.Date;  
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
  
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
  
import org.primefaces.event.SelectEvent;  
/**
 *
 * @author sergio
 */
@Named
@SessionScoped
public class CrearCalendario implements Serializable{
    @EJB
    private AgendaFacadeLocal agendaFacade;
    private String fecha;
    private Agenda agenda;
    private Date date1;
    private String horaVista;
    private Date hora;
    private int bloque;
    private int rutEntrenador; 
    private Date dia;

    public CrearCalendario() {
    }
    
    @PostConstruct
    public void init(){
        agenda = new Agenda();
       // date1=new Date();
        
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public AgendaFacadeLocal getAgendaFacade() {
        return agendaFacade;
    }

    public void setAgendaFacade(AgendaFacadeLocal agendaFacade) {
        this.agendaFacade = agendaFacade;
    }

    public int getRutEntrenador() {
        return rutEntrenador;
    }

    public void setRutEntrenador(int rutEntrenador) {
        this.rutEntrenador = rutEntrenador;
    }   

    public String getHoraVista() {
        return horaVista;
    }

    public void setHoraVista(String horaVista) {
        this.horaVista = horaVista;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    

    public int getBloque() {
        return bloque;
    }

   

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }
      
    public Date getDate1() {  
        return date1;  
    }  
  
    public void setDate1(Date date1) {  
        this.date1 = date1;  
    }  
  
//    public void handleDateSelect(SelectEvent event) {
//       
//        FacesContext facesContext = FacesContext.getCurrentInstance();  
//        SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");  
//        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
//        
//    }
    public void agregarHorario() throws ParseException{
        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        //SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");
        // date1 = format.parse(fecha);
        //String aux = format.format(event.getObject());
        //Date date;
        //date = format.parse(aux);
        
        
        hora  = sdf.parse(horaVista);
        
        
        System.out.println(date1.toString());
        
        agenda.setAgendaFecha(date1);
        
        
        
        agenda.setAgendaHora(hora);
        agenda.setAgrendaDisponible(true);
        agenda.setEntrenadorentrenadorRut(rutEntrenador);
        
        agendaFacade.create(agenda);        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito", "Agenda creada con exito"));
        
        
        
    }
    
}

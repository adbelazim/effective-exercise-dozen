/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.entities.Asistencia;
import cl.dozen.www.entities.Cliente;
import cl.dozen.www.facades.AsistenciaFacadeLocal;
import java.io.Serializable;
import java.util.Date;
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

public class AgregarAsistencia implements Serializable{
    @EJB
    private AsistenciaFacadeLocal asistenciaFacade;

    
    
    Asistencia asistencia;
    
    private Integer clienteRut;
    private boolean maquinaAsistencia;  
    private boolean claseAsistencia;  

    public Integer getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(Integer clienteRut) {
        this.clienteRut = clienteRut;
    }

    public AsistenciaFacadeLocal getAsistenciaFacade() {
        return asistenciaFacade;
    }

    public void setAsistenciaFacade(AsistenciaFacadeLocal asistenciaFacade) {
        this.asistenciaFacade = asistenciaFacade;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
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

 
    public AgregarAsistencia() {
    }
    
    public void integrarAsistencia(){
       
       asistencia = new Asistencia(clienteRut, new Date(), maquinaAsistencia, claseAsistencia);
       asistenciaFacade.create(asistencia);
       FacesContext context;
       context = FacesContext.getCurrentInstance();
       context.addMessage(null , new FacesMessage("Exito", "Asistencia agregada con exito"));  
    }
    
    
    
}

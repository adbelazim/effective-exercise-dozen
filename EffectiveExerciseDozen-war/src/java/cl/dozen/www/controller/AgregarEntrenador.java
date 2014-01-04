/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.cliente.entrenador.EntrenadorNegocioLocal;
import cl.dozen.www.entities.Entrenador;
import cl.dozen.www.facades.EntrenadorFacadeLocal;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author sergio
 */
@Named
@ConversationScoped
public class AgregarEntrenador implements Serializable{
    @EJB
    private EntrenadorNegocioLocal entrenadorNegocio;
    @EJB
    private EntrenadorFacadeLocal entrenadorFacade;
    @Inject
    private Conversation conversation;
    private Entrenador entrenador;
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String Direccion;
    private int telefono;
    private String sexo;
    private String mail;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    private static Logger logger = Logger.getLogger(AgregarCliente.class.getName());
    public AgregarEntrenador() {
    }
    
    public void ingresarEntrenador(){
        int rutEntero;
        int respuestaRut;
        String aux;
        String [] rutSeparado = rut.split("-");
        aux = rutSeparado[0];
        rutEntero = Integer.parseInt(aux);
        entrenador = new Entrenador (rutEntero, nombre, apellidoPaterno, apellidoMaterno, telefono, sexo, mail);
        entrenador.setEntrenadorDireccion(Direccion);
        respuestaRut = entrenadorNegocio.verificarEntrenador(entrenador);
        if(respuestaRut == -1){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Ojo", "El entrenador ya existe, Ingrese uno nuevo")); 
        }
        else{
            entrenadorFacade.create(entrenador);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Exito", "Entrenador agregado con exito"));  
        }
        
        
                       
    }
    

    public String onFlowProcess(FlowEvent event) {
        logger.info("Current wizard step:" + event.getOldStep());
        logger.info("Next step:" + event.getNewStep());
        

        return event.getNewStep();

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
}

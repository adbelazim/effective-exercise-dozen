/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.Plan;
import cl.dozen.www.entities.PlanContratado;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.primefaces.event.CaptureEvent;
import org.primefaces.event.FlowEvent;
import cl.dozen.www.facades.PlanFacadeLocal;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

/**
 *
 * @author sergio
 */
@Named
@ConversationScoped
public class AgregarCliente implements Serializable{
    //me permite obtener todos los planes desdes la DB
    @EJB
    private PlanFacadeLocal planFacade;
    //manater conversacion entre datos
    @Inject
    private Conversation conversation;
    //cliente de la vista, del tipo entities
    private Cliente cliente;
    //lista de planes obtenidos desde al facade
    private List<Plan> planes;
    //plan seleccionado por el cliente
    private Plan planSeleccionado;
    //relacion entre plan seleccionado con cliente
    private PlanContratado planContratado;
    //mostrar mensajes en el servidor de aplicaciones
    private static Logger logger = Logger.getLogger(AgregarCliente.class.getName());  

    public AgregarCliente() {
    }
    
    @PostConstruct
    public void init(){
        
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
     
        planes = planFacade.findAll();
        
        planContratado = new PlanContratado();
        
  
    }
    
    public void beginConversation()
   {
      if (conversation.isTransient())
      {
          conversation.begin();
      }
   }
 
   public void endConversation()
   {
      if (!conversation.isTransient())
      {
          conversation.end();
      }
   }

    public PlanContratado getPlanContratado() {
        return planContratado;
    }

    public void setPlanContratado(PlanContratado planContratado) {
        this.planContratado = planContratado;
    }

    
    
    
    public Plan getPlanSeleccionado() {
        return planSeleccionado;
    }

    public void setPlanSeleccionado(Plan planSeleccionado) {
        this.planSeleccionado = planSeleccionado;
    }
    
    public List<cl.dozen.www.entities.Plan> getPlanes() {
        return planes;
    }

    public void setPlanes(List<cl.dozen.www.entities.Plan> planes) {
        this.planes = planes;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    public void agregarCliente(){
           // agregar cliente a la BD
        
        
        endConversation();;
        
        
    }
    
   public void onRowSelect() {
        planContratado.setPlanContratadoMonto( planSeleccionado.getPlanPrecio());
    }
    
    public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep()); 
        
         logger.info(cliente.toString());
        
        return event.getNewStep();  
         
    } 
    
    
}

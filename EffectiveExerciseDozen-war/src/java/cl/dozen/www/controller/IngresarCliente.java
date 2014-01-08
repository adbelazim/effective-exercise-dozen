package cl.dozen.www.controller;

import cl.dozen.www.cliente.ClienteNegocioLocal;
import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.Evaluacion;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class IngresarCliente implements Serializable{
    @EJB
    private ClienteNegocioLocal clienteNegocio;
    
    private Cliente cliente;
   

    public IngresarCliente() {
    }
    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }
    
//   public String ingresar(){
        
       // if(clienteNegocio.verificarCliente(cliente) == -1){
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("BIENVENIDO"));
       
         //   return "/home/homeCliente?faces-redirect=true";
            
        
       // }
        //else{
//            return "error?faces-redirect=true";
//        }
//    
//    }
//    
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    
    
    
}
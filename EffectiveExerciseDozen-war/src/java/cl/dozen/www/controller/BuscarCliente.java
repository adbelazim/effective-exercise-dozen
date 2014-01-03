/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.cliente.ClienteNegocioLocal;
import cl.dozen.www.entities.Cliente;
import cl.dozen.www.facades.ClienteFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class BuscarCliente implements Serializable{
    @EJB
    private ClienteNegocioLocal clienteNegocio;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    
    private List<Cliente> clientes;
    
    private String buscado;
    
    private String opcion;
    
    private Cliente clienteSeleccionado;

    public BuscarCliente() {
    }
    
    @PostConstruct
    public void init(){
       
        clienteSeleccionado = new Cliente();
    }
    

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getBuscado() {
        return buscado;
    }

    public void setBuscado(String buscado) {
        this.buscado = buscado;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }
    
    
    public void buscar(){
    
        
        System.out.println("opcion "+opcion+"buscado "+buscado);
        
        switch(opcion){
        
            case "codigo":
                
                clientes =  clienteNegocio.busquedaClienteCodigo(Integer.parseInt(buscado));
                break;
                
            case "rut":
                clientes = clienteNegocio.busquedaClienteRut(Integer.parseInt(buscado));

                break;
                
            case "apellido":
                clientes = clienteNegocio.busquedaClienteApellidoPaterno(buscado);
                break;
                
            default:
                
                break;
        }

    }
    
    public void actualizar(){
        
        System.out.println(clienteSeleccionado.toString());
        clienteFacade.edit(clienteSeleccionado);
        
    }
    
    public void realizarPago(){
       // clienteFacade.edit(clienteSeleccionado);
        
    }
    
    
}

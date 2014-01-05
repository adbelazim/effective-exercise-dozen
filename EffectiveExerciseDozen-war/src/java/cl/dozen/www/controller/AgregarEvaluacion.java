/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.cliente.ClienteNegocioLocal;
import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.Evaluacion;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
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
public class AgregarEvaluacion implements Serializable {
    @EJB
    ClienteNegocioLocal clienteNegocio;
            
            
    
    private List<Cliente> clientes;
    
    private String buscado;
    
    private String opcion;
    
    private Cliente clienteSeleccionado;
    
    //datos evaluacion
    
    private String fecha;
    private Evaluacion evaluacion;
    private int edad;
    
    public AgregarEvaluacion(){
    
 
    }
    
    @PostConstruct
    public void init(){
       
        clienteSeleccionado = new Cliente();
        evaluacion = new Evaluacion();
   
    }
    
    public void buscar(){
    
        
        System.out.println("opcion "+opcion+"buscado "+buscado);
        
        switch(opcion){
        
            case "codigo":
                try{
                    clientes =  clienteNegocio.busquedaClienteCodigo(Integer.parseInt(buscado));
                }
                catch(NumberFormatException ex){
                    clientes =  clienteNegocio.busquedaClienteCodigo(-1);
                     
                }
                break;
                
            case "rut":
                try{
                    clientes = clienteNegocio.busquedaClienteRut(Integer.parseInt(buscado));
                }
                catch(NumberFormatException ex){
                    clientes = clienteNegocio.busquedaClienteRut(-1);
                }
                break;
                
            case "apellido":
                clientes = clienteNegocio.busquedaClienteApellidoPaterno(buscado);
                break;
                
            default:
                
                break;
        }

    }
    
    public void obtenerDatosEvaluacion(){
        DateFormat df =  DateFormat.getDateInstance();
        this.edad = calcularEdad(clienteSeleccionado.getClienteFechaNacimiento());
        String s =  df.format(clienteSeleccionado.getClienteFechaNacimiento());
        this.fecha = s;
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.
        
        
    
    
    }
    
    public int calcularEdad(Date fechaNacimiento){
      //  fechaNacimiento = clienteSeleccionado.getClienteFechaNacimiento();
        Date fechaActual;  
        int dia1,dia2;
        int mes1,mes2;
        int año1,año2;
        año1 = fechaNacimiento.getYear();
        mes1 = fechaNacimiento.getMonth();
        dia1 = fechaNacimiento.getDay();
                
        fechaActual = new Date();
        
        System.out.println("fecha actual es" + fechaActual.toString());
        año2 = fechaActual.getYear();
        mes2 = fechaActual.getMonth();
        dia2 = fechaActual.getDay();
        edad = (año2 - año1 - 1) + (mes2 == mes1 ? (dia2 >= dia1 ? 1 : 0) : mes2 >= mes1 ? 1 : 0); 
        
        return edad;
    }

    public ClienteNegocioLocal getClienteNegocio() {
        return clienteNegocio;
    }

    public void setClienteNegocio(ClienteNegocioLocal clienteNegocio) {
        this.clienteNegocio = clienteNegocio;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
}

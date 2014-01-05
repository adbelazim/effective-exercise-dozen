/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dozen.www.controller;

import cl.dozen.www.cliente.ClienteNegocioLocal;
import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.HistorialPago;
import cl.dozen.www.entities.Plan;
import cl.dozen.www.entities.PlanContratado;
import cl.dozen.www.facades.ClienteFacadeLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.context.FacesContext;

import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import cl.dozen.www.facades.PlanFacadeLocal;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;

import javax.inject.Inject;

/**
 *
 * @author sergio
 */
@Named
@ConversationScoped
public class AgregarCliente implements Serializable {

    @EJB
    private ClienteNegocioLocal clienteNegocio;

    @EJB
    private ClienteFacadeLocal clienteFacade;
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
    //lista comunas
    private List<String> comunas;
    //plan seleccionado por el cliente
    private Plan planSeleccionado;
    //relacion entre plan seleccionado con cliente
    private PlanContratado planContratado;
    //numero boleta
    private HistorialPago historialPago;
    
    private String clienteRut;

    //mostrar mensajes en el servidor de aplicaciones
    private static Logger logger = Logger.getLogger(AgregarCliente.class.getName());

    public AgregarCliente() {
    }

    @PostConstruct
    public void init() {

        cliente = new Cliente();
        clienteRut = "1-9";
        cliente.setClienteNombre("Danilo");
        cliente.setClienteApellidoPaterno("Aburto");
        cliente.setClienteApellidoMaterno("Gonzalez");
        cliente.setClienteComuna("Santiago");
        cliente.setClienteDireccion("Pasaje La luna #274");
        cliente.setClienteEstadoCivil("Soltero");
        //cliente.setClienteFechaNacimiento(new Date());
        cliente.setClienteMail("danilo@usach.cl");
        cliente.setClienteSexo("Masculino");
        cliente.setClienteTelefono(1234567);

        planes = planFacade.findAll();

        planContratado = new PlanContratado();

        historialPago = new HistorialPago();

        //comunas
        String listadoComunas = "Cerrillos-La Reina-Pudahuel-Cerro Navia-Las Condes-Quilicura-Conchalí-Lo Barnechea-Quinta Normal-El Bosque-Lo Espejo-Recoleta-Estación Central-Lo Prado-Renca-Huechuraba-Macul-San Miguel-Independencia-Maipú-San Joaquín-La Cisterna-Ñuñoa-San Ramón-La Florida-Pedro Aguirre Cerda-Santiago-La Pintana-Peñalolén-Vitacura-La Granja-Providencia-Padre Hurtado-San Bernardo-Puente Alto-Pirque-San José de Maipo";
        String[] nombresComunas = listadoComunas.split("-");
        comunas = new ArrayList<>();
        comunas.addAll(Arrays.asList(nombresComunas));
        Collections.sort(comunas);

    }

    public String getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(String clienteRut) {
        this.clienteRut = clienteRut;
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

    public HistorialPago getHistorialPago() {
        return historialPago;
    }

    public void setHistorialPago(HistorialPago historialPago) {
        this.historialPago = historialPago;
    }

    public PlanContratado getPlanContratado() {
        return planContratado;
    }

    public void setPlanContratado(PlanContratado planContratado) {
        this.planContratado = planContratado;
    }

    public List<String> getComunas() {
        return comunas;
    }

    public void setComunas(List<String> comunas) {
        this.comunas = comunas;
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
      
    public void agregarCliente() {

//agregar cliente a la BD
        int cod;
        int rut;
        String aux;
        String [] rutSeparado = clienteRut.split("-");
        aux = rutSeparado[0];
        rut = Integer.parseInt(aux);
        cliente.setClienteRut(rut);
        if ((cod = clienteNegocio.crearCliente(cliente, planSeleccionado, planContratado, historialPago)) == -1) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "Cliente con " + cliente.getClienteRut() + " ya existe"));
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Exxito", "Cliente agregado con exito, su código es:" + cod));
        }
        endConversation();

    }

    public void onRowSelect() {
        planContratado.setPlanContratadoMonto(planSeleccionado.getPlanPrecio());
    }

    public String onFlowProcess(FlowEvent event) {
        logger.info("Current wizard step:" + event.getOldStep());
        logger.info("Next step:" + event.getNewStep());
        logger.info(cliente.toString());

        return event.getNewStep();

    }

}

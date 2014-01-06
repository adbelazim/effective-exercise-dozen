/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dozen.www.controller;

import cl.dozen.www.cliente.ClienteNegocioLocal;
import cl.dozen.www.cliente.entrenador.EntrenadorNegocioLocal;
import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.Entrenador;
import cl.dozen.www.entities.Evaluacion;
import cl.dozen.www.entities.TablaPGC;
import cl.dozen.www.evaluacion.EvaluacionNegocioLocal;
import cl.dozen.www.facades.EntrenadorFacadeLocal;
import cl.dozen.www.facades.TablaPGCFacadeLocal;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class AgregarEvaluacion implements Serializable {

    @EJB
    private EntrenadorNegocioLocal entrenadorNegocio;

    @EJB
    private TablaPGCFacadeLocal tablaPGCFacade;
    @EJB
    private EvaluacionNegocioLocal evaluacionNegocio;

    @EJB
    ClienteNegocioLocal clienteNegocio;

    private List<TablaPGC> tablaPGCs;

    private List<Cliente> clientes;

    private String buscado;

    private String opcion;

    private Cliente clienteSeleccionado;

    private Entrenador entrenador;

    private int clienteRut;

    //datos evaluacion
    private String fecha;
    private Evaluacion evaluacion;
    private int edad;

    private float imc;
    private float pgc;
    private int suma;

    public AgregarEvaluacion() {

    }

    @PostConstruct
    public void init() {

        clienteSeleccionado = new Cliente();
        evaluacion = new Evaluacion();
        tablaPGCs = new ArrayList<>();
        entrenador = new Entrenador();

    }

    public void buscar() {

        System.out.println("opcion " + opcion + "buscado " + buscado);

        switch (opcion) {

            case "codigo":
                try {
                    clientes = clienteNegocio.busquedaClienteCodigo(Integer.parseInt(buscado));
                } catch (NumberFormatException ex) {
                    clientes = clienteNegocio.busquedaClienteCodigo(-1);

                }
                break;

            case "rut":
                try {
                    clientes = clienteNegocio.busquedaClienteRut(Integer.parseInt(buscado));
                } catch (NumberFormatException ex) {
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

    public void obtenerDatosEvaluacion() {
        DateFormat df = DateFormat.getDateInstance();
        this.edad = evaluacionNegocio.calcularEdad(clienteSeleccionado.getClienteFechaNacimiento());
        String s = df.format(clienteSeleccionado.getClienteFechaNacimiento());
        this.fecha = s;

    }

    public void realizarEvaluacion() {
        tablaPGCs = tablaPGCFacade.findAll();
        this.suma = evaluacionNegocio.calcularSuma(evaluacion);
        this.imc = evaluacionNegocio.calcularIMC(evaluacion);
        evaluacion.setEvaluacionSuma(suma);
        this.pgc = evaluacionNegocio.calcularPGC(evaluacion, tablaPGCs, clienteSeleccionado);

    }

    public void ingresarEvaluacion() {
        evaluacion.setEvaluacionSuma(getSuma());
        evaluacion.setEvaluacionIMC(getImc());
        evaluacion.setEvaluacionPGC(getPgc());
        evaluacion.setClienteclienteRut(clienteSeleccionado);
        evaluacion.setEvaluacionFecha(new Date());
        evaluacion.setEntrenadorentrenadorRut(entrenador);
        System.out.println("Rut: " + entrenador.getEntrenadorRut());

        if (entrenadorNegocio.verificarEntrenador(entrenador) == -1) {
            evaluacionNegocio.agregarEvaluacion(evaluacion);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage("Evaluación realizada con exito"));

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage("El entrenador no existe, ingrese rut válido"));

        }

    }

    public int getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(int clienteRut) {
        this.clienteRut = clienteRut;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public float getPgc() {
        return pgc;
    }

    public void setPgc(float pgc) {
        this.pgc = pgc;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
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

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

}

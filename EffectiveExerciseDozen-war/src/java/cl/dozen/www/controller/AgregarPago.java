/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.HistorialPago;
import cl.dozen.www.facades.HistorialPagoFacade;
import cl.dozen.www.facades.HistorialPagoFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped
public class AgregarPago {
    @EJB
    private HistorialPagoFacadeLocal historialPagoFacade;
    private HistorialPago historialPago;
    private Cliente cliente;
    private int rut;
    private int numBoleta;
    private Date fecha;
    private int monto;
    private String observaciones;
    

    public AgregarPago() {
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    

    public int getNumBoleta() {
        return numBoleta;
    }

    public void setNumBoleta(int numBoleta) {
        this.numBoleta = numBoleta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public HistorialPago getHistorialPago() {
        return historialPago;
    }

    public void setHistorialPago(HistorialPago historialPago) {
        this.historialPago = historialPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void agregarPago(){
        cliente = new Cliente(rut);
        historialPago = new HistorialPago(numBoleta, fecha, monto );
        historialPago.setHistorialPagoObservacion(observaciones);
        historialPago.setClienteclienteRut(cliente);
        historialPagoFacade.create(historialPago);
        
    }
    
}

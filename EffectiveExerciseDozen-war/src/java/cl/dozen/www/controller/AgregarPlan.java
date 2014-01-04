/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import cl.dozen.www.entities.Plan;
import cl.dozen.www.facades.PlanFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped
public class AgregarPlan {
    @EJB
    private PlanFacadeLocal planFacade;
    private String nombre;
    private int precio;
    private String descripcion;
    private Plan plan;

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @PostConstruct
    public void init(){
        plan = new Plan();
    }
    public AgregarPlan() {
    }
    
    public void insertarPlan(){
        plan.setPlanDescripcion(descripcion);
        plan.setPlanNombre(nombre);
        plan.setPlanPrecio(precio);
        planFacade.create(plan);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exito", "Nuevo plan agregado con exito")); 
        
    }
    
}

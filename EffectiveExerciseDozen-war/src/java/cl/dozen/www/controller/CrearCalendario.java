/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;  
import java.util.List;
import javax.annotation.PostConstruct;
  
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
  
import org.primefaces.event.SelectEvent;  
/**
 *
 * @author sergio
 */
@Named
@RequestScoped
public class CrearCalendario {
    
    private Date date1;
    private int bloque;
    private List<String> bloques;

    public CrearCalendario() {
    }
    
    @PostConstruct
    public void init(){
        //comunas
        String listadoBloque = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30";
        String[] nombresBloques = listadoBloque.split(",");
        bloques = new ArrayList<>();
        bloques.addAll(Arrays.asList(nombresBloques));
        
    }

    public int getBloque() {
        return bloque;
    }

    public List<String> getBloques() {
        return bloques;
    }

    public void setBloques(List<String> bloques) {
        this.bloques = bloques;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }
      
    public Date getDate1() {  
        return date1;  
    }  
  
    public void setDate1(Date date1) {  
        this.date1 = date1;  
    }  
  
    public void handleDateSelect(SelectEvent event) {  
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");  
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));  
    }  
    
}

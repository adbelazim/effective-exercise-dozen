/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped
public class HomeManagedBeans { 
    private List<String> images;
  
    

    public HomeManagedBeans() {        
    }
    @PostConstruct
    public void init(){
        images = new ArrayList<>();  
        images.add("nature1.jpg");  
        images.add("nature2.jpg");  
        images.add("nature3.jpg");  
        images.add("nature4.jpg");
        
        
    }
    
    public List<String> getImages() {  
        return images;  
    }  
}

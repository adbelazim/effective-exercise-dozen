/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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
  
        for(int i=1;i<=4;i++) {  
            images.add("dozen" + i + ".jpg");  
        }
        
        
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
    
   
}

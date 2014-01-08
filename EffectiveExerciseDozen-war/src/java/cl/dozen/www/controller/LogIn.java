/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */

@Named
@SessionScoped
public class LogIn implements Serializable{
    
    private String userName;
    private String password;

    public LogIn() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
                      
            request.login(userName, password);
            return "homeGeneral?faces-redirect=true";
        } catch (ServletException e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unknown login", null));
            return null;
        }

    }
    
    public String cerrarSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.
                getExternalContext().getSession(false);
        session.invalidate();
        return "success";
    }
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.dozen.www.validators;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Rodrigo
 */
public class ApellidoMaternoValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String apellidoMaterno = (String) o;
        
        Pattern p = Pattern.compile("^[a-zA-Z]+$");

        if(!apellidoMaterno.matches(p.pattern())) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Apellido Materno inválido");
            message.setDetail("Apellido Materno inválido");
            fc.addMessage(":formAgregar:apellidoMaterno", message);
            throw new ValidatorException(message);
        }
    }
    
}

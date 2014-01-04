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
public class ApellidoPaternoValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String apellidoPaterno = (String) o;
        
        Pattern p = Pattern.compile("^[a-zA-Z]+$");

        if(!apellidoPaterno.matches(p.pattern())) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Apellido Paterno inválido");
            message.setDetail("Apellido Paterno inválido");
            fc.addMessage(":formAgregar:apellidoPaterno", message);
            throw new ValidatorException(message);
        }
    }
    
}

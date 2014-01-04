/*
 * To change this template, choose Tools | Templates
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
public class EmailValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String email = (String) o;
        
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        if(!email.matches(p.pattern())) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Email inválido");
            message.setDetail("Email inválido");
            fc.addMessage(":formAgregar:email", message);
            throw new ValidatorException(message);
        }
    }
    
}

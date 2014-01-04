/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dozen.www.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Rodrigo
 */
public class RutValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String rut = (String)o;
              
        if(!checkRut(rut)) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Rut Inválido");
            message.setDetail("Rut Inválido");
            fc.addMessage(":formAgregar:rut", message);
            throw new ValidatorException(message);
        }
//        if(validacion.existeRut(rut)) {
//            FacesMessage message = new FacesMessage();
//            message.setSeverity(FacesMessage.SEVERITY_ERROR);
//            message.setSummary("Cliente ya Existe");
//            message.setDetail("Cliente ya Existe");
//            fc.addMessage("formAddCliente:rut", message);
//            throw new ValidatorException(message);
//        }
        
        
    }
    
    private boolean checkRut(String rutCompleto) {
        
        String rutCortado[];
        String rut;
        int rutNumero;
        String digitoInicial;
        int i = 2, suma = 0, n;
        try {
            rutCortado = rutCompleto.split("-");
            rut = rutCortado[0];
            rutNumero = Integer.parseInt(rut);
            digitoInicial = rutCortado[1];

        } catch (Exception e) {
           
            return false;
        }
        for (int j = 0; j < rut.length(); j++) {
            n = (rutNumero % 10) * i;
            suma = suma + n;
            rutNumero = rutNumero / 10;
            i = i + 1;
            if (i == 8) {
                i = 2;
            }
        }
        int d = suma % 11;
        String digitoCalculado;
        if (d == 0 || d==10) {
            digitoCalculado = "0";
        } else if (d == 1) {
            digitoCalculado = "k";
        } else {
            digitoCalculado = "" + (11 - d);
        }

        if (digitoCalculado.equals(digitoInicial)) {
            return true;
        } else {
            return false;
        }
    }
    
    
}

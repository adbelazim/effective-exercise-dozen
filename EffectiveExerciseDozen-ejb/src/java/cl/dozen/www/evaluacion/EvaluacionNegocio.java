/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dozen.www.evaluacion;

import cl.dozen.www.entities.Cliente;
import cl.dozen.www.entities.Entrenador;
import cl.dozen.www.entities.Evaluacion;
import cl.dozen.www.entities.TablaPGC;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class EvaluacionNegocio implements EvaluacionNegocioLocal {

    @PersistenceContext(unitName = "EffectiveExerciseDozen-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public int calcularEdad(Date fechaNacimiento) {
        Date fechaActual;
        int dia1, dia2;
        int mes1, mes2;
        int año1, año2;
        año1 = fechaNacimiento.getYear();
        mes1 = fechaNacimiento.getMonth();
        dia1 = fechaNacimiento.getDay();

        fechaActual = new Date();

        año2 = fechaActual.getYear();
        mes2 = fechaActual.getMonth();
        dia2 = fechaActual.getDay();
        int edad = (año2 - año1 - 1) + (mes2 == mes1 ? (dia2 >= dia1 ? 1 : 0) : mes2 >= mes1 ? 1 : 0);

        return edad;
    }

    @Override
    public int calcularSuma(Evaluacion evaluacion) {
        int suma = evaluacion.getEvaluacionBiceps() + evaluacion.getEvaluacionEscapular() + evaluacion.getEvaluacionIliaco() + evaluacion.getEvaluacionTriceps();
        return suma;
    }

    @Override
    public float calcularIMC(Evaluacion evaluacion) {

        float denominador = evaluacion.getEvaluacionEstatura() * evaluacion.getEvaluacionEstatura();
        float imc = evaluacion.getEvaluacionPeso() / denominador;

        return imc;

    }

    @Override
    public float calcularPGC(Evaluacion evaluacion, List<TablaPGC> tablaPGCs, Cliente cliente) {

        int suma, grupoEtareo = 1, edad;
        String sexoAntiguo = cliente.getClienteSexo();
        int sexo = 2;
        suma = evaluacion.getEvaluacionSuma();

        System.out.println(cliente.toString());

        edad = calcularEdad(cliente.getClienteFechaNacimiento());
        if ("masculino".equals(sexoAntiguo)) {
            sexo = 1;
        }
        if (edad <= 29) {
            grupoEtareo = 1;
        } else if (edad >= 30 && edad <= 39) {
            grupoEtareo = 2;
        } else if (edad >= 40 && edad >= 49) {
            grupoEtareo = 3;
        } else if (edad >= 50) {
            grupoEtareo = 4;
        }
        Query q = em.createNamedQuery("TabaPGC.findBySexoSumaEdad").setParameter("tablaPGCSexo", sexo).setParameter("tablaPGCSuma", suma).setParameter("tablaPGCEdad", grupoEtareo);

        System.out.println("grupo etareo " + grupoEtareo + " sexo " + sexo + " suma " + suma);

        Float pgc = (Float) q.getSingleResult();

        System.out.println(pgc);

        return pgc;

    }

    @Override
    public void agregarEvaluacion(Evaluacion evaluacion) {
        persist(evaluacion);

    }

}

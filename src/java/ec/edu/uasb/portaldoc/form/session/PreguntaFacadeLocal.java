/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.session;

import ec.edu.uasb.portaldoc.form.entities.Pregunta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface PreguntaFacadeLocal {

    void create(Pregunta pregunta);

    void edit(Pregunta pregunta);

    void remove(Pregunta pregunta);

    Pregunta find(Object id);

    List<Pregunta> findAll();

    List<Pregunta> findRange(int[] range);

    int count();

    public List<Pregunta> findByEncuesta(long encuesta);
    
}

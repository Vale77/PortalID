/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.session;

import ec.edu.uasb.portaldoc.form.entities.Encuesta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface EncuestaFacadeLocal {

    void create(Encuesta encuesta);

    void edit(Encuesta encuesta);

    void remove(Encuesta encuesta);

    Encuesta find(Object id);

    List<Encuesta> findAll();

    List<Encuesta> findRange(int[] range);

    int count();
    
}

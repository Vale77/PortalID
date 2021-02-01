/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.session;


import ec.edu.uasb.portaldoc.form.entities.EncuestaCalendario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface EncuestaCalendarioFacadeLocal {

    void create(EncuestaCalendario encuestaCalendario);

    void edit(EncuestaCalendario encuestaCalendario);

    void remove(EncuestaCalendario encuestaCalendario);

    EncuestaCalendario find(Object id);

    List<EncuestaCalendario> findAll();

    List<EncuestaCalendario> findRange(int[] range);

    int count();
    
}

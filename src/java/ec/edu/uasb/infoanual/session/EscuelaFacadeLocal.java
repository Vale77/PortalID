/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.Escuela;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface EscuelaFacadeLocal {

    void create(Escuela escuela);

    void edit(Escuela escuela);

    void remove(Escuela escuela);

    Escuela find(Object id);

    List<Escuela> findAll();

    List<Escuela> findRange(int[] range);

    int count();
    
}

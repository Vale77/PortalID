/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.Especializacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface EspecializacionFacadeLocal {

    void create(Especializacion especializacion);

    void edit(Especializacion especializacion);

    void remove(Especializacion especializacion);

    Especializacion find(Object id);

    List<Especializacion> findAll();

    List<Especializacion> findRange(int[] range);

    int count();
    
}

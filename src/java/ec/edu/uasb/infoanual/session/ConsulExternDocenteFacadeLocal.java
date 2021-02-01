/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.ConsulExternDocente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface ConsulExternDocenteFacadeLocal {

    void create(ConsulExternDocente consulExternDocente);

    void edit(ConsulExternDocente consulExternDocente);

    void remove(ConsulExternDocente consulExternDocente);

    ConsulExternDocente find(Object id);

    List<ConsulExternDocente> findAll();

    List<ConsulExternDocente> findRange(int[] range);

    int count();

    public java.util.List<ec.edu.uasb.infoanual.entities.ConsulExternDocente> findConProf(java.lang.Long codProf, java.lang.Long anio);
    
}

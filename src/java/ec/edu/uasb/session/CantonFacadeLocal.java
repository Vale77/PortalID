/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.Canton;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface CantonFacadeLocal {

    void create(Canton canton);

    void edit(Canton canton);

    void remove(Canton canton);

    Canton find(Object id);

    List<Canton> findAll();

    List<Canton> findRange(int[] range);

    int count();

    public List<Canton> findByPaisAndProv(String codPais, String codProv);
    
}

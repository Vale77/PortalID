/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.Parroquia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface ParroquiaFacadeLocal {

    void create(Parroquia parroquia);

    void edit(Parroquia parroquia);

    void remove(Parroquia parroquia);

    Parroquia find(Object id);

    List<Parroquia> findAll();

    List<Parroquia> findRange(int[] range);

    int count();

    public List<Parroquia> findByPaisAndProvAndCan(String codPais, String codProv, String codCan);
    
}

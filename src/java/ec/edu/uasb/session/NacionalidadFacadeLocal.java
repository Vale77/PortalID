/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;


import ec.edu.uasb.entities.Nacionalidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface NacionalidadFacadeLocal {

    void create(Nacionalidad nacionalidad);

    void edit(Nacionalidad nacionalidad);

    void remove(Nacionalidad nacionalidad);

    Nacionalidad find(Object id);

    List<Nacionalidad> findAll();

    List<Nacionalidad> findRange(int[] range);

    int count();

    public List<Nacionalidad> findAllOrdenados();
    
}

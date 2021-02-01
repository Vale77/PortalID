/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.TituloProfesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface TituloProfesorFacadeLocal {

    void create(TituloProfesor tituloProfesor);

    void edit(TituloProfesor tituloProfesor);

    void remove(TituloProfesor tituloProfesor);

    TituloProfesor find(Object id);

    List<TituloProfesor> findAll();

    List<TituloProfesor> findRange(int[] range);

    int count();

    public java.util.List<ec.edu.uasb.infoanual.entities.TituloProfesor> finbyProfesor(java.lang.Long profCodigo);
    
}

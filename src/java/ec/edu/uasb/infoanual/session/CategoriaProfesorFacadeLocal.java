/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.CategoriaProfesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface CategoriaProfesorFacadeLocal {

    void create(CategoriaProfesor categoriaProfesor);

    void edit(CategoriaProfesor categoriaProfesor);

    void remove(CategoriaProfesor categoriaProfesor);

    CategoriaProfesor find(Object id);

    List<CategoriaProfesor> findAll();

    List<CategoriaProfesor> findRange(int[] range);

    int count();
    
}

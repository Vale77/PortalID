/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.Titulo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface TituloFacadeLocal {

    void create(Titulo titulo);

    void edit(Titulo titulo);

    void remove(Titulo titulo);

    Titulo find(Object id);

    List<Titulo> findAll();

    List<Titulo> findRange(int[] range);

    int count();
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.Apelativo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface ApelativoFacadeLocal {

    void create(Apelativo apelativo);

    void edit(Apelativo apelativo);

    void remove(Apelativo apelativo);

    Apelativo find(Object id);

    List<Apelativo> findAll();

    List<Apelativo> findRange(int[] range);

    int count();

    public List<Apelativo> findAllOrdenados();
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.session;

import ec.edu.uasb.portaldoc.entities.SylabusBiblio;
import ec.edu.uasb.portaldoc.entities.SylabusContenidoPK;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface SylabusBiblioFacadeLocal {

    void create(SylabusBiblio sylabusBiblio);

    void edit(SylabusBiblio sylabusBiblio);

    void remove(SylabusBiblio sylabusBiblio);

    SylabusBiblio find(Object id);

    List<SylabusBiblio> findAll();

    List<SylabusBiblio> findRange(int[] range);

    int count();

    public List<SylabusBiblio> findBiblioById(SylabusContenidoPK contenidoPK);
}

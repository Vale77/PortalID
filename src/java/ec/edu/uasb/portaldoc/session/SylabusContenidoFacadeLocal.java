/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.session;

import ec.edu.uasb.bean.exceptions.TemaException;
import ec.edu.uasb.portaldoc.entities.SylabusContenido;
import ec.edu.uasb.portaldoc.entities.SylabusContenidoPK;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface SylabusContenidoFacadeLocal {

    void create(SylabusContenido sylabusContenido);

    void edit(SylabusContenido sylabusContenido);

    void remove(SylabusContenido sylabusContenido);

    SylabusContenido find(Object id);

    List<SylabusContenido> findAll();

    List<SylabusContenido> findRange(int[] range);

    int count();

    public List<SylabusContenido> findContenidoById(SylabusContenidoPK contenidoPK);

    public String findNumClaseById(SylabusContenidoPK contenidoPK);


}

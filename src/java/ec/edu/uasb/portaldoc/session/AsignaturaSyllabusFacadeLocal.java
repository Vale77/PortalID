/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.session;

import ec.edu.uasb.portaldoc.entities.AsignaturaSyllabus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface AsignaturaSyllabusFacadeLocal {

    void create(AsignaturaSyllabus asignaturaSyllabus);

    void edit(AsignaturaSyllabus asignaturaSyllabus);

    void remove(AsignaturaSyllabus asignaturaSyllabus);

    AsignaturaSyllabus find(Object id);

    List<AsignaturaSyllabus> findAll();

    List<AsignaturaSyllabus> findRange(int[] range);

    int count();

    public List<AsignaturaSyllabus> getAsignatSyllabus(Long anio, Long docente);

    public List<AsignaturaSyllabus> getCordinadosSyllabus(Long anio, Long coordinador);

    public List<AsignaturaSyllabus> getListaAcopiarSyllabus(Long anio, Long docente, Long asignatura);

}

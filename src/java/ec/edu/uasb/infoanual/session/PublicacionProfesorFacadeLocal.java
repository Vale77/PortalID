/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.PublicacionProfesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface PublicacionProfesorFacadeLocal {

    void create(PublicacionProfesor publicacionProfesor);

    void edit(PublicacionProfesor publicacionProfesor);

    void remove(PublicacionProfesor publicacionProfesor);

    PublicacionProfesor find(Object id);

    List<PublicacionProfesor> findAll();

    List<PublicacionProfesor> findRange(int[] range);

    int count();

    public java.util.List<ec.edu.uasb.infoanual.entities.PublicacionProfesor> findPublicProfesor(java.lang.Long codProf);

    public java.util.List<ec.edu.uasb.infoanual.entities.PublicacionProfesor> findPresMedProfesor(java.lang.Long codProf, java.lang.Long anio);

    public List<PublicacionProfesor> findPublicProfFormAnterior(Long codProf);
    
}

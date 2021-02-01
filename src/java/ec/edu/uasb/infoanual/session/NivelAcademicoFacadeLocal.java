/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.NivelAcademico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface NivelAcademicoFacadeLocal {

    void create(NivelAcademico nivelAcademico);

    void edit(NivelAcademico nivelAcademico);

    void remove(NivelAcademico nivelAcademico);

    NivelAcademico find(Object id);

    List<NivelAcademico> findAll();

    List<NivelAcademico> findRange(int[] range);

    int count();
    
}

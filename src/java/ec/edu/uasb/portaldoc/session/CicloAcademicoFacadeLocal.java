/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.session;

import ec.edu.uasb.portaldoc.entities.CicloAcademico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface CicloAcademicoFacadeLocal {

    void create(CicloAcademico cicloAcademico);

    void edit(CicloAcademico cicloAcademico);

    void remove(CicloAcademico cicloAcademico);

    CicloAcademico find(Object id);

    List<CicloAcademico> findAll();

    List<CicloAcademico> findRange(int[] range);

    int count();

    public List<CicloAcademico> findByEstado(char estado);

    public List<CicloAcademico> findAllActivos();
    
}

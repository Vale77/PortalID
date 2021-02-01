/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.AreaVincolectividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface AreaVincolectividadFacadeLocal {

    void create(AreaVincolectividad areaVincolectividad);

    void edit(AreaVincolectividad areaVincolectividad);

    void remove(AreaVincolectividad areaVincolectividad);

    AreaVincolectividad find(Object id);

    List<AreaVincolectividad> findAll();

    List<AreaVincolectividad> findRange(int[] range);

    int count();
    
}

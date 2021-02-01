/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.DetalleVincolectividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface DetalleVincolectividadFacadeLocal {

    void create(DetalleVincolectividad detalleVincolectividad);

    void edit(DetalleVincolectividad detalleVincolectividad);

    void remove(DetalleVincolectividad detalleVincolectividad);

    DetalleVincolectividad find(Object id);

    List<DetalleVincolectividad> findAll();

    List<DetalleVincolectividad> findRange(int[] range);

    int count();

    public java.util.List<ec.edu.uasb.infoanual.entities.DetalleVincolectividad> finbyArea(java.lang.String codArea);
    
}

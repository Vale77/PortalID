/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.AreaVincolectividad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class AreaVincolectividadFacade extends AbstractFacade<AreaVincolectividad> implements AreaVincolectividadFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreaVincolectividadFacade() {
        super(AreaVincolectividad.class);
    }
    
}

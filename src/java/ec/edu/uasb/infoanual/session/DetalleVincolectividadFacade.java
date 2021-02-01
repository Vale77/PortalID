/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.DetalleVincolectividad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class DetalleVincolectividadFacade extends AbstractFacade<DetalleVincolectividad> implements DetalleVincolectividadFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleVincolectividadFacade() {
        super(DetalleVincolectividad.class);
    }
    
     
    @Override
    public List<DetalleVincolectividad> finbyArea(String codArea){
        return em.createQuery("select object(o) from DetalleVincolectividad as o where o.areaVinculacion.avcCodigo = :codArea ").setParameter("codArea", Long.parseLong(codArea)).setHint("eclipselink.refresh", true).getResultList();
    
    }
}

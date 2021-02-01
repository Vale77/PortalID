/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.Nacionalidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class NacionalidadFacade extends AbstractFacade<Nacionalidad> implements NacionalidadFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NacionalidadFacade() {
        super(Nacionalidad.class);
    }

    @Override
    public List<Nacionalidad> findAllOrdenados() {
        Query q = em.createNamedQuery("Nacionalidad.findAll");
        return q.getResultList();
    }
}

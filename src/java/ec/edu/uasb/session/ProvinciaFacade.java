/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.Provincia;
import ec.edu.uasb.portaldoc.session.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author victor.barba
 */
@Stateless
public class ProvinciaFacade extends AbstractFacade<Provincia> implements ProvinciaFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciaFacade() {
        super(Provincia.class);
    }

    
    @Override
    public List<Provincia> findByPais(String codPais) {
        Query q = em.createNamedQuery("Provincia.findByCodigoPais");
        q.setParameter("codigoPais", codPais);
        return q.getResultList();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.Canton;
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
public class CantonFacade extends AbstractFacade<Canton> implements CantonFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CantonFacade() {
        super(Canton.class);
    }

    @Override
    public List<Canton> findByPaisAndProv(String codPais, String codProv) {
        Query q = em.createQuery("SELECT c FROM Canton c WHERE c.cantonPK.codigoPais = :codigoPais and c.cantonPK.codigoProvincia = :codigoProvincia order by c.nombreCanton");
        q.setParameter("codigoPais", codPais).setParameter("codigoProvincia", codProv);
        return q.getResultList();
    }
}

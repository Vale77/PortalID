/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.Parroquia;
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
public class ParroquiaFacade extends AbstractFacade<Parroquia> implements ParroquiaFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParroquiaFacade() {
        super(Parroquia.class);
    }


    @Override
    public List<Parroquia> findByPaisAndProvAndCan(String codPais, String codProv,String codCan) {
        Query q = em.createQuery("SELECT p FROM Parroquia p WHERE p.parroquiaPK.codigoPais = :codigoPais and "
                + "p.parroquiaPK.codigoProvincia = :codigoProvincia and p.parroquiaPK.codigoCanton = :codigoCanton "                
                + "order by p.nombreParroquia");
        q.setParameter("codigoPais", codPais).setParameter("codigoProvincia", codProv).setParameter("codigoCanton", codCan);
        return q.getResultList();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.Pais;
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
public class PaisFacade extends AbstractFacade<Pais> implements PaisFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }
    
    @Override
    public Pais finbyCodigo(String paiCodigo){
         Query q = em.createQuery("select object(o) from Pais o where o.codPais = :paiCodigo order by o.nomPais");
        q.setParameter("paiCodigo", paiCodigo);
        List<Pais> temp = q.setHint("eclipselink.refresh", true).getResultList();
        if (!temp.isEmpty()) {
            return (Pais) temp.get(0);
        } else {
            return null;
        }   
    }
    
    @Override
      public List<Pais> findAllorde(){
         Query q = em.createQuery("select object(o) from Pais o  order by o.nomPais asc");        
        List<Pais> temp = q.setHint("eclipselink.refresh", true).getResultList();
        return temp;   
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.entities.Facultad;
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
public class FacultadFacade extends AbstractFacade<Facultad> implements FacultadFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacultadFacade() {
        super(Facultad.class);
    }
    
    
    @Override
      public List<Facultad> findAllactiva(){
         Query q = em.createQuery("select object(o) from Facultad o where o.codigoFacultad in(1,3,4,5,6,7,8,17)  order by o.nombreFacultad asc");        
        List<Facultad> temp = q.setHint("eclipselink.refresh", true).getResultList();
        return temp;   
    }
    
}

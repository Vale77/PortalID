/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.ConsulExternDocente;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class ConsulExternDocenteFacade extends AbstractFacade<ConsulExternDocente> implements ConsulExternDocenteFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsulExternDocenteFacade() {
        super(ConsulExternDocente.class);
    }
    @Override
        public List<ConsulExternDocente> findConProf(Long codProf, Long anio){      
        return em.createNativeQuery("  SELECT *"
                + "    FROM CONSUL_EXTERN_DOCENTE cp "
                + "   WHERE cp.ANIO = "+anio+"  AND  "
                + "         cp.CICLO = 1  AND  "
                + "         cp.CODIGO_PROFESOR = "+codProf+" ",ec.edu.uasb.infoanual.entities.ConsulExternDocente.class).getResultList();
    }
    
}

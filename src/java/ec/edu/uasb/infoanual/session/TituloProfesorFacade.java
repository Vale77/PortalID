/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.TituloProfesor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class TituloProfesorFacade extends AbstractFacade<TituloProfesor> implements TituloProfesorFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TituloProfesorFacade() {
        super(TituloProfesor.class);
    }
    @Override
      public List<TituloProfesor> finbyProfesor(Long profCodigo){
        return em.createQuery("select object(o) from TituloProfesor as o where o.tituloProfesorPK.codigoProfesor = :profCodigo order by o.fechaTitulo desc").setParameter("profCodigo", profCodigo).setHint("eclipselink.refresh", true).getResultList();
    
    }
    
}

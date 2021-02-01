/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.session;

import ec.edu.uasb.portaldoc.entities.CicloAcademico;
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
public class CicloAcademicoFacade extends AbstractFacade<CicloAcademico> implements CicloAcademicoFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CicloAcademicoFacade() {
        super(CicloAcademico.class);
    }

    @Override
    public List<CicloAcademico> findByEstado(char estado) {
        Query q = em.createNamedQuery("CicloAcademico.findByEstadoCiclo").setParameter("estadoCiclo", estado);
        return q.getResultList();
    }

    @Override
    public List<CicloAcademico> findAll() {
        Query q = em.createNamedQuery("CicloAcademico.findAll");
        return q.getResultList();
    }

    @Override
    public List<CicloAcademico> findAllActivos() {
        Query q = em.createQuery("SELECT c FROM CicloAcademico c WHERE c.cicloAcademicoPK.anio >= 2011 and c.cicloAcademicoPK.anio <= 2014 order by c.cicloAcademicoPK.anio DESC");
        return q.getResultList();
    }

}

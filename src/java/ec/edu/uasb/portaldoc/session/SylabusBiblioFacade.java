/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.session;

import ec.edu.uasb.portaldoc.entities.SylabusBiblio;
import ec.edu.uasb.portaldoc.entities.SylabusContenidoPK;
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
public class SylabusBiblioFacade extends AbstractFacade<SylabusBiblio> implements SylabusBiblioFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SylabusBiblioFacade() {
        super(SylabusBiblio.class);
    }

    @Override
    public List<SylabusBiblio> findBiblioById(SylabusContenidoPK contenidoPK) {
        StringBuilder sb = new StringBuilder("SELECT s FROM SylabusBiblio s WHERE ");
        sb.append(" s.sylabusBiblioPK.anio = ").append(contenidoPK.getAnio())
                .append(" and s.sylabusBiblioPK.ciclo = ").append(contenidoPK.getCiclo())
                .append(" and s.sylabusBiblioPK.codigoMateria = ").append(contenidoPK.getCodigoMateria())
                .append(" and s.sylabusBiblioPK.codigoProfesor = ").append(contenidoPK.getCodigoProfesor())
                .append(" and s.sylabusBiblioPK.codigoNivel = ").append(contenidoPK.getCodigoNivel())
                .append(" and s.sylabusBiblioPK.codParalelo = ").append(contenidoPK.getCodParalelo())
                .append(" and s.sylabusBiblioPK.vacCodnum = ").append(contenidoPK.getVacCodnum())
                .append(" and s.sylabusBiblioPK.codPrograma = ").append(contenidoPK.getCodPrograma());
        Query q = em.createQuery(sb.toString());
        return q.getResultList();

    }
}

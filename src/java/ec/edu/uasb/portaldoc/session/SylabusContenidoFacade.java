/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.session;

import ec.edu.uasb.portaldoc.entities.SylabusContenido;
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
public class SylabusContenidoFacade extends AbstractFacade<SylabusContenido> implements SylabusContenidoFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SylabusContenidoFacade() {
        super(SylabusContenido.class);
    }

    @Override
    public List<SylabusContenido> findContenidoById(SylabusContenidoPK contenidoPK) {
        StringBuilder sb = new StringBuilder("SELECT s "
                + " FROM SylabusContenido s WHERE ");
        sb.append(" s.sylabusContenidoPK.anio = ").append(contenidoPK.getAnio())
                .append(" and s.sylabusContenidoPK.ciclo = ").append(contenidoPK.getCiclo())
                .append(" and s.sylabusContenidoPK.codigoMateria = ").append(contenidoPK.getCodigoMateria())
                .append(" and s.sylabusContenidoPK.codigoProfesor = ").append(contenidoPK.getCodigoProfesor())
                .append(" and s.sylabusContenidoPK.tipo = '").append(contenidoPK.getTipo()).append("'")
                .append(" and s.sylabusContenidoPK.codigoNivel = ").append(contenidoPK.getCodigoNivel())
                .append(" and s.sylabusContenidoPK.vacCodnum = ").append(contenidoPK.getVacCodnum())
                .append(" and s.sylabusContenidoPK.codParalelo = ").append(contenidoPK.getCodParalelo())
                .append(" and s.sylabusContenidoPK.codPrograma = ").append(contenidoPK.getCodPrograma());
        Query q = em.createQuery(sb.toString());
        return q.getResultList();

    }

    @Override
    public String findNumClaseById(SylabusContenidoPK contenidoPK) {
        StringBuilder sb = new StringBuilder("SELECT ISNULL(SUM(CONVERT(DECIMAL(10,0), s.clase)),0) "
                + " FROM SYLABUS_CONTENIDO s WHERE ");
        sb.append(" s.anio = ").append(contenidoPK.getAnio())
                .append(" and s.ciclo = ").append(contenidoPK.getCiclo())
                .append(" and s.codigo_Materia = ").append(contenidoPK.getCodigoMateria())
                .append(" and s.codigo_Profesor = ").append(contenidoPK.getCodigoProfesor())
                .append(" and s.tipo = '").append(contenidoPK.getTipo()).append("'")
                .append(" and s.codigo_Nivel = ").append(contenidoPK.getCodigoNivel())
                .append(" and s.vac_Codnum = ").append(contenidoPK.getVacCodnum())
                .append(" and s.cod_Paralelo = ").append(contenidoPK.getCodParalelo())
                .append(" and s.cod_Programa = ").append(contenidoPK.getCodPrograma());
        Query q = em.createNativeQuery(sb.toString());
        return q.getSingleResult().toString();
    }
}

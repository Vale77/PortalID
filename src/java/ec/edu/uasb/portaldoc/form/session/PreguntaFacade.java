/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.session;

import ec.edu.uasb.portaldoc.form.entities.Pregunta;
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
public class PreguntaFacade extends AbstractFacade<Pregunta> implements PreguntaFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntaFacade() {
        super(Pregunta.class);
    }

    @Override
    public List<Pregunta> findByEncuesta(long encuesta) {
        StringBuilder sb = new StringBuilder("WITH PREGUNTA_CTE  ( CODIGO_PREGUNTA,CODIGO_ENCUESTA,PREGUNTA_PADRE, DESCRIPCION,REFERENCIA,TIPO,PESO,FORMATO,NIVEL_NODO)AS( ");
        sb.append("SELECT CODIGO_PREGUNTA,CODIGO_ENCUESTA,isnull(PREGUNTA_PADRE,CODIGO_PREGUNTA),  DESCRIPCION,REFERENCIA,TIPO,PESO,FORMATO,0 ");
        sb.append("FROM EVALUACION.PREGUNTA WHERE CODIGO_ENCUESTA = ? and PREGUNTA_PADRE IS NULL ");
        sb.append("UNION ALL ");
        sb.append("SELECT e.CODIGO_PREGUNTA,e.CODIGO_ENCUESTA,e.PREGUNTA_PADRE, e.DESCRIPCION,e.REFERENCIA,e.TIPO,e.PESO, e.FORMATO,pcte.NIVEL_NODO+1 ");
        sb.append("FROM EVALUACION.PREGUNTA e INNER JOIN PREGUNTA_CTE pcte ON  e.PREGUNTA_PADRE =  pcte.CODIGO_PREGUNTA ");
        sb.append("WHERE e.CODIGO_ENCUESTA = ?) ");      
        sb.append("SELECT * FROM PREGUNTA_CTE  order by PREGUNTA_PADRE,CODIGO_PREGUNTA ");
        Query q = em.createNativeQuery(sb.toString(),Pregunta.class);
        q.setParameter(1, encuesta);
        q.setParameter(2, encuesta);        
        return q.getResultList();
    }
    
}

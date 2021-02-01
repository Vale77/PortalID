/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.NivelAcademico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class NivelAcademicoFacade extends AbstractFacade<NivelAcademico> implements NivelAcademicoFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelAcademicoFacade() {
        super(NivelAcademico.class);
    }
    
}

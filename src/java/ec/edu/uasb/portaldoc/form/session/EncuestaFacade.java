/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.session;

import ec.edu.uasb.portaldoc.form.entities.Encuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victor.barba
 */
@Stateless
public class EncuestaFacade extends AbstractFacade<Encuesta> implements EncuestaFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncuestaFacade() {
        super(Encuesta.class);
    }
    
}

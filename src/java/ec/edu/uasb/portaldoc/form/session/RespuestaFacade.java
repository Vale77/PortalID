/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.session;


import ec.edu.uasb.portaldoc.form.entities.Respuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victor.barba
 */
@Stateless
public class RespuestaFacade extends AbstractFacade<Respuesta> implements RespuestaFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RespuestaFacade() {
        super(Respuesta.class);
    }
    
}

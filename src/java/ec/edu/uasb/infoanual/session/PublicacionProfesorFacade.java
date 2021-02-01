/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.PublicacionProfesor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class PublicacionProfesorFacade extends AbstractFacade<PublicacionProfesor> implements PublicacionProfesorFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PublicacionProfesorFacade() {
        super(PublicacionProfesor.class);
    }
    
    /**
     *
     * @param codProf
     * @return
     */
   @Override
    public List<PublicacionProfesor> findPublicProfesor(Long codProf){      
        return em.createNativeQuery("Select * "
                + " from  PUBLICACION_PROFESOR p "
                + " where p.CODIGO_PROFESOR = " + codProf + 
                " and p.campo9 is null"+
                " and p.PUB_APELLIDO_AUTOR is not null "+                  
                " ORDER BY P.PUB_FECEDICION DESC",ec.edu.uasb.infoanual.entities.PublicacionProfesor.class).getResultList();

    }
     
    
    @Override
    public List<PublicacionProfesor> findPublicProfFormAnterior(Long codProf){      
        return em.createNativeQuery("Select * "
                + " from  PUBLICACION_PROFESOR p "
                + " where p.CODIGO_PROFESOR = " + codProf + 
                " and p.campo9 is null "+
                " and p.PUB_APELLIDO_AUTOR is null "+
                " and campo1  is not null"+
                " ORDER BY P.PUB_FECEDICION DESC",ec.edu.uasb.infoanual.entities.PublicacionProfesor.class).getResultList();
    }
    @Override
     public List<PublicacionProfesor> findPresMedProfesor(Long codProf,Long anio){      
        return em.createNativeQuery("Select * "
                + " FROM PUBLICACION_PROFESOR  p"
                + " WHERE  p.CAMPO10 ="+anio + "  AND  "
                + " p.CODIGO_PROFESOR ="+codProf+ "  AND "
                + " p.TIPO_PUBLICACION = -1 ",ec.edu.uasb.infoanual.entities.PublicacionProfesor.class).getResultList();
    }
    
}

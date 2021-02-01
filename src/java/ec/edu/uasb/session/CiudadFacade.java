/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;


import ec.edu.uasb.entities.Ciudad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> implements CiudadFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadFacade() {
        super(Ciudad.class);
    }
    @Override
    public List<Ciudad> finbyPais(String codPais){
        return em.createQuery("select object(o) from Ciudad as o where o.ciudadPK.codPais = :codPais order by o.nomCiudad asc").setParameter("codPais", codPais).setHint("eclipselink.refresh", true).getResultList();
    
    }

    @Override
    public Ciudad finbyCodigo(String codPais, Long  ciuCodigo){
         Query q = em.createQuery("select object(o) from Ciudad o where o.ciudadPK.codPais = :codPais and o.ciudadPK.codCiudad = :ciuCodigo order by o.nomCiudad desc");
         q.setParameter("codPais", codPais);
        q.setParameter("ciuCodigo", ciuCodigo);
        
        List<Ciudad> temp = q.setHint("eclipselink.refresh", true).getResultList();
        if (!temp.isEmpty()) {
            return (Ciudad) temp.get(0);
        } else {
            return null;
        }   
    }
}

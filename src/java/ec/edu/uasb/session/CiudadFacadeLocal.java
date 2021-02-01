/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;


import ec.edu.uasb.entities.Ciudad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface CiudadFacadeLocal {

    void create(Ciudad ciudad);

    void edit(Ciudad ciudad);

    void remove(Ciudad ciudad);

    Ciudad find(Object id);

    List<Ciudad> findAll();

    List<Ciudad> findRange(int[] range);

    int count();

    public java.util.List<Ciudad> finbyPais(java.lang.String codPais);

    public Ciudad finbyCodigo(java.lang.String codPais, java.lang.Long ciuCodigo);

    

    
    
}

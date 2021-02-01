/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.session;

import ec.edu.uasb.entities.Pais;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface PaisFacadeLocal {

    void create(Pais pais);

    void edit(Pais pais);

    void remove(Pais pais);

    Pais find(Object id);

    List<Pais> findAll();

    List<Pais> findRange(int[] range);

    int count();



    public ec.edu.uasb.entities.Pais finbyCodigo(java.lang.String paiCodigo);

    public java.util.List<ec.edu.uasb.entities.Pais> findAllorde();


    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.seg.session;

import ec.edu.uasb.seg.entities.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victor.barba
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public ec.edu.uasb.seg.entities.Usuario login(java.lang.String username, java.lang.String password);

    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.Profesor;
import java.util.List;
import javax.ejb.Local;
import javax.faces.context.FacesContext;

/**
 *
 * @author johana.orozco
 */
@Local
public interface ProfesorFacadeLocal {

    void create(Profesor profesor);

    void edit(Profesor profesor);

    void remove(Profesor profesor);

    Profesor find(Object id);

    List<Profesor> findAll();

    List<Profesor> findRange(int[] range);

    int count();

    public ec.edu.uasb.infoanual.entities.Profesor finbyCodigo(java.lang.Long profCodigo);

    public void enviaCorreo(String profile_name, String recipients, String copy_recipients, String blind_copy_recipients, String psubject, String pmensaje, String body_format);

    public void edit(Profesor docente, FacesContext fcontext);
    
}

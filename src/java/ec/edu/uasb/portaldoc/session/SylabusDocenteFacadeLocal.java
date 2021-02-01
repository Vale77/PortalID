/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.session;

import ec.edu.uasb.bean.exceptions.SyllabusException;
import ec.edu.uasb.portaldoc.entities.AsignaturaSyllabus;
import ec.edu.uasb.portaldoc.entities.SylabusDocente;
import ec.edu.uasb.portaldoc.entities.SylabusDocentePK;
import ec.edu.uasb.seg.entities.Usuario;
import java.util.List;
import javax.ejb.Local;
import javax.faces.context.FacesContext;

/**
 *
 * @author victor.barba
 */
@Local
public interface SylabusDocenteFacadeLocal {

    void create(SylabusDocente sylabusDocente);

    void edit(SylabusDocente sylabusDocente);

    void remove(SylabusDocente sylabusDocente);

    SylabusDocente find(Object id);

    List<SylabusDocente> findAll();

    List<SylabusDocente> findRange(int[] range);

    int count();

    public SylabusDocente findById(AsignaturaSyllabus docentePK) throws SyllabusException;

    public void enviaCorreo(String profile_name, String recipients, String copy_recipients, String blind_copy_recipients, String psubject, String pmensaje, String body_format);

    public void edit(SylabusDocente docente, Usuario usr, AsignaturaSyllabus asignaturaSelected, FacesContext context);

    public void edit(Usuario usr,  SylabusDocente sylabusDocente, AsignaturaSyllabus asignaturaSelected, FacesContext fcontext);

    public void registraMoodle(Long anio, Long codigoMateria);

    public void copy(AsignaturaSyllabus copiaSelected, AsignaturaSyllabus asignaturaSelected,Usuario usr);



    
}

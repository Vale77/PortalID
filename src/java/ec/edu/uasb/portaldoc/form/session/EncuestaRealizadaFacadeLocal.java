/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.session;


import ec.edu.uasb.portaldoc.form.datamodel.EncuEvalDocente;
import ec.edu.uasb.portaldoc.form.entities.EncuestaRealizada;
import ec.edu.uasb.portaldoc.form.entities.Respuesta;
import java.util.List;
import javax.ejb.Local;
import javax.faces.context.FacesContext;

/**
 *
 * @author victor.barba
 */
@Local
public interface EncuestaRealizadaFacadeLocal {

    void create(EncuestaRealizada encuestaRealizada);

    void edit(EncuestaRealizada encuestaRealizada);

    void remove(EncuestaRealizada encuestaRealizada);

    EncuestaRealizada find(Object id);

    List<EncuestaRealizada> findAll();

    List<EncuestaRealizada> findRange(int[] range);

    int count();

    public java.util.List encuestasDisponibles(java.lang.Long codEstud, java.lang.String tipo);

    public String createEncuesta(Long codCoordinador, EncuEvalDocente encuEvalDocente, List<Respuesta> respuestas, FacesContext context, String tipo);

    
   
}

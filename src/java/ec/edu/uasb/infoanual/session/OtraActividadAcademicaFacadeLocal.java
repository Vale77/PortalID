/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.OtraActividadAcademica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface OtraActividadAcademicaFacadeLocal {

    void create(OtraActividadAcademica otraActividadAcademica);

    void edit(OtraActividadAcademica otraActividadAcademica);

    void remove(OtraActividadAcademica otraActividadAcademica);

    OtraActividadAcademica find(Object id);

    List<OtraActividadAcademica> findAll();

    List<OtraActividadAcademica> findRange(int[] range);

    int count();

    

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findAsigexterna(java.lang.Long codProf, java.lang.Long anio);

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findCotexterna(java.lang.Long codProf, java.lang.Long anio);

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findProyInter(java.lang.Long codProf, java.lang.Long anio);

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findEducacionContinuaUasb(java.lang.Long codProf, java.lang.Long anio);

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findEducacionContinuaExterna(java.lang.Long codProf, java.lang.Long anio);

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findActEventoUasb(java.lang.Long codProf, java.lang.Long anio);

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findActEventoExt(java.lang.Long codProf, java.lang.Long anio);

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findPertOrgAcad(java.lang.Long codProf, java.lang.Long anio);

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findFunAcad(java.lang.Long codProf, java.lang.Long anio);

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findPerfDoc(java.lang.Long codProf, java.lang.Long anio);

    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findDistAcad(java.lang.Long codProf, java.lang.Long anio);
    
    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findCoorAcad(java.lang.Long codProf, java.lang.Long anio);
    
    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findComInst(java.lang.Long codProf, java.lang.Long anio);
    
    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findComiTri(java.lang.Long codProf, java.lang.Long anio);
    
    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findProgPos(java.lang.Long codProf, java.lang.Long anio);
    
    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findEduCont(java.lang.Long codProf, java.lang.Long anio);
    
    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findActVinc(java.lang.Long codProf, java.lang.Long anio);
    
    public java.util.List<ec.edu.uasb.infoanual.entities.OtraActividadAcademica> findOtrFun(java.lang.Long codProf, java.lang.Long anio);
}
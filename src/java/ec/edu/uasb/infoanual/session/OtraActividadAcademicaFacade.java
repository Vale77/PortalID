/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.OtraActividadAcademica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class OtraActividadAcademicaFacade extends AbstractFacade<OtraActividadAcademica> implements OtraActividadAcademicaFacadeLocal {
    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OtraActividadAcademicaFacade() {
        super(OtraActividadAcademica.class);
    }
    

    
    @Override
    public List<OtraActividadAcademica> findAsigexterna(Long codProf, Long anio){      
        return em.createNativeQuery("Select *"
                + " from  OTRA_ACTIVIDAD_ACADEMICA p"
                + " where"
                + " p.CODIGO_PROFESOR = " + codProf 
                + " and p.TIPO_OTRA_ACTIVIDAD in ('E','B','H','M','K')    AND "
                 + anio +"  BETWEEN"
                +" (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103) then 1992 else (select anio from CICLO_ACADEMICO where   p.FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                +" (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end)"
                + " ORDER BY p.FINICIO_ACTIVIDAD DESC",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
    public List<OtraActividadAcademica> findCotexterna(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + " where p.CODIGO_PROFESOR = " + codProf 
                + " and p.TIPO_OTRA_ACTIVIDAD = 'T'    AND "
                 + anio +"  BETWEEN"
                 + "(case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103) then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end)"
                + " ORDER BY p.FINICIO_ACTIVIDAD DESC",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    
    @Override
    public List<OtraActividadAcademica> findProyInter(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "
                + "  p.TIPO_OTRA_ACTIVIDAD = 'I'   AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103) then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end)"
                + " order by p.FINICIO_ACTIVIDAD desc ",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
      public List<OtraActividadAcademica> findEducacionContinuaUasb(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "
                +"   (p.CODIGO_FACULTAD IS NOT NULL OR "
                + " P.avc_codigo is not null)AND "         
                + "  p.TIPO_OTRA_ACTIVIDAD = 'R'      AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and "
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + "order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
          public List<OtraActividadAcademica> findEducacionContinuaExterna(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "
                +"   p.CODIGO_FACULTAD IS NOT NULL AND "         
                + "  p.TIPO_OTRA_ACTIVIDAD = 'A'      AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + " order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
         public List<OtraActividadAcademica> findActEventoUasb(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "
                +"   p.CODIGO_FACULTAD IS NOT NULL AND "         
                + "  p.TIPO_OTRA_ACTIVIDAD = 'U'     AND "
                + anio +"  BETWEEN"
                 +" (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103) then 1992 else (select anio from CICLO_ACADEMICO where   p.FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end)"
                + " order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
      public List<OtraActividadAcademica> findActEventoExt(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "
                +"   p.CODIGO_FACULTAD IS NOT NULL AND "         
                + "  p.TIPO_OTRA_ACTIVIDAD = 'S'     AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103) then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and "
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + " order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
     public List<OtraActividadAcademica> findPertOrgAcad(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'P'     AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,FINICIO_ACTIVIDAD,103)<= convert(datetime, '01/01/1993',103) then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and "
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + " order by FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
    public List<OtraActividadAcademica> findFunAcad(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'G' AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + "order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
     public List<OtraActividadAcademica> findPerfDoc(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'O'     AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + " order by FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
     public List<OtraActividadAcademica> findDistAcad(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'D'"               
                + " order by FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
    public List<OtraActividadAcademica> findCoorAcad(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'C' AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + "order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
    public List<OtraActividadAcademica> findComInst(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'F' AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + "order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
    public List<OtraActividadAcademica> findComiTri(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'J' AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + "order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
    public List<OtraActividadAcademica> findProgPos(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'L' AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + "order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
    public List<OtraActividadAcademica> findEduCont(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'Q' AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + "order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    @Override
    public List<OtraActividadAcademica> findActVinc(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'W' AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + "order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
    
    @Override
    public List<OtraActividadAcademica> findOtrFun(Long codProf, Long anio){      
        return em.createNativeQuery("Select * "
                + " from  OTRA_ACTIVIDAD_ACADEMICA p "
                + "where ( p.CODIGO_PROFESOR =  "+ codProf +" ) AND "                 
                + "  p.TIPO_OTRA_ACTIVIDAD = 'X' AND "
                + anio +"  BETWEEN"
                + " (case when convert(datetime,p.FINICIO_ACTIVIDAD,103)<= convert(datetime,'01/01/1993',103)  then 1992 else (select anio from CICLO_ACADEMICO where   FINICIO_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and FINICIO_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)  end) and"
                + " (case when  p.FFIN_ACTIVIDAD is null or (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL) is null then 2020 else (select anio from CICLO_ACADEMICO where   p.FFIN_ACTIVIDAD >= CICLO_ACADEMICO.F_INICIO and p.FFIN_ACTIVIDAD <= CICLO_ACADEMICO.F_FINAL)end) "
                + "order by p.FINICIO_ACTIVIDAD desc",ec.edu.uasb.infoanual.entities.OtraActividadAcademica.class).getResultList();
    }
}
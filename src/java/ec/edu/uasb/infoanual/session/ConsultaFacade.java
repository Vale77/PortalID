/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johana.orozco
 */
@Stateless
public class ConsultaFacade implements ConsultaFacadeLocal {

    @PersistenceContext(unitName = "academicoPU")
    private EntityManager em;

    @Override
    public Vector ejecutaSqlList(String sql) {
        return (Vector) em.createNativeQuery(sql).setParameter(1, sql).getResultList();
    }

   @Override
    public String actTesMonUasb(String[] testMon) {
        String ls_query = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        if (testMon[14].toString().equalsIgnoreCase("TU") || testMon[14].toString().equalsIgnoreCase("SM")
                || testMon[14].toString().equalsIgnoreCase("DI")) {
            ls_query = " UPDATE MATRICULA_ESTUDIANTE "
                    + "  SET NUM_CONSULTAS = " + testMon[7]
                    + ", NUM_HORAS = " + testMon[8] + ""
                    + ", MATRICULA_ESTUDIANTE.FECHA_ULTMODIFIC = convert(date, '" + formato.format(new Date()) + "', 103 )"
                    + ", MATRICULA_ESTUDIANTE.USUARIO_ULTMODIFIC =  'DOC-" + testMon[19] + "' "
                    + "	WHERE  MATRICULA_ESTUDIANTE.COD_ESTUDIANTE = " + testMon[13] + "  AND  "
                    + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[9] + " AND "
                    + " MATRICULA_ESTUDIANTE.CICLO = " + testMon[10] + " AND "
                    + " MATRICULA_ESTUDIANTE.CODIGO_ESP = " + testMon[12] + " AND "
                    + " MATRICULA_ESTUDIANTE.NUM_MATRICULA = " + testMon[11] + " and "
                    + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[18] + " and "
                    + " MATRICULA_ESTUDIANTE.codigo_profesor = " + testMon[19];

        }
        if (testMon[14].toString().equalsIgnoreCase("SL")) {
            ls_query = " UPDATE MATRICULA_ESTUDIANTE "
                    + "  SET NUM_CONSULTAS1 = " + testMon[7]
                    + ", NUM_HORAS1 = " + testMon[8] + ""
                    + ", MATRICULA_ESTUDIANTE.FECHA_ULTMODIFIC = convert(date, '" + formato.format(new Date()) + "', 103 )"
                    + ", MATRICULA_ESTUDIANTE.USUARIO_ULTMODIFIC =  'DOC-" + testMon[19] + "' "
                    + "	WHERE  MATRICULA_ESTUDIANTE.COD_ESTUDIANTE = " + testMon[13] + "  AND  "
                    + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[9] + " AND "
                    + " MATRICULA_ESTUDIANTE.CICLO = " + testMon[10] + " AND "
                    + " MATRICULA_ESTUDIANTE.CODIGO_ESP = " + testMon[12] + " AND "
                    + " MATRICULA_ESTUDIANTE.NUM_MATRICULA = " + testMon[11] + " and "
                    + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[18] + " and "
                    + " MATRICULA_ESTUDIANTE.docente1_tesmon = " + testMon[19];

        }
        if (testMon[14].toString().equalsIgnoreCase("TR")) {
            if (testMon[17].toString().equalsIgnoreCase("NUM_HORAS1")) {
                ls_query = " UPDATE MATRICULA_ESTUDIANTE "
                        + "  SET NUM_CONSULTAS1 = " + testMon[7]
                        + ", NUM_HORAS1 = " + testMon[8] + ""
                        + ", MATRICULA_ESTUDIANTE.FECHA_ULTMODIFIC = convert(date, '" + formato.format(new Date()) + "', 103 )"
                        + ", MATRICULA_ESTUDIANTE.USUARIO_ULTMODIFIC =  'DOC-" + testMon[19] + "' "
                        + "	WHERE  MATRICULA_ESTUDIANTE.COD_ESTUDIANTE = " + testMon[13] + "  AND  "
                        + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[9] + " AND "
                        + " MATRICULA_ESTUDIANTE.CICLO = " + testMon[10] + " AND "
                        + " MATRICULA_ESTUDIANTE.CODIGO_ESP = " + testMon[12] + " AND "
                        + " MATRICULA_ESTUDIANTE.NUM_MATRICULA = " + testMon[11] + "and "
                        + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[18] + " and "
                        + " MATRICULA_ESTUDIANTE.docente1_tesmon = " + testMon[19];

            }
            if (testMon[17].toString().equalsIgnoreCase("NUM_HORAS2")) {
                ls_query = " UPDATE MATRICULA_ESTUDIANTE "
                        + "  SET NUM_CONSULTAS2 = " + testMon[7]
                        + ", NUM_HORAS2 = " + testMon[8] + ""
                        + ", MATRICULA_ESTUDIANTE.FECHA_ULTMODIFIC = convert(date, '" + formato.format(new Date()) + "', 103 )"
                        + ", MATRICULA_ESTUDIANTE.USUARIO_ULTMODIFIC =  'DOC-" + testMon[19] + "' "
                        + "	WHERE  MATRICULA_ESTUDIANTE.COD_ESTUDIANTE = " + testMon[13] + "  AND  "
                        + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[9] + " AND "
                        + " MATRICULA_ESTUDIANTE.CICLO = " + testMon[10] + " AND "
                        + " MATRICULA_ESTUDIANTE.CODIGO_ESP = " + testMon[12] + " AND "
                        + " MATRICULA_ESTUDIANTE.NUM_MATRICULA = " + testMon[11] + "and "
                        + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[18] + " and "
                        + " MATRICULA_ESTUDIANTE.docente2_tesmon = " + testMon[19];

            }
            if (testMon[17].toString().equalsIgnoreCase("NUM_HORAS4")) {
                ls_query = " UPDATE MATRICULA_ESTUDIANTE "
                        + "  SET NUM_CONSULTAS4 = " + testMon[7]
                        + ", NUM_HORAS4 = " + testMon[8] + ""
                        + ", MATRICULA_ESTUDIANTE.FECHA_ULTMODIFIC = convert(date, '" + formato.format(new Date()) + "', 103 )"
                        + ", MATRICULA_ESTUDIANTE.USUARIO_ULTMODIFIC =  'DOC-" + testMon[19] + "' "
                        + "	WHERE  MATRICULA_ESTUDIANTE.COD_ESTUDIANTE = " + testMon[13] + "  AND  "
                        + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[9] + " AND "
                        + " MATRICULA_ESTUDIANTE.CICLO = " + testMon[10] + " AND "
                        + " MATRICULA_ESTUDIANTE.CODIGO_ESP = " + testMon[12] + " AND "
                        + " MATRICULA_ESTUDIANTE.NUM_MATRICULA = " + testMon[11] + "and "
                        + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[18] + " and "
                        + " MATRICULA_ESTUDIANTE.docente4_tesmon = " + testMon[19];
            }
        }
        if (testMon[14].toString().equalsIgnoreCase("LT")) {
            ls_query = " UPDATE MATRICULA_ESTUDIANTE "
                    + "  SET NUM_CONSULTAS3 = " + testMon[7]
                    + ", NUM_HORAS3 = " + testMon[8] + ""
                    + ", MATRICULA_ESTUDIANTE.FECHA_ULTMODIFIC = convert(date, '" + formato.format(new Date()) + "', 103 )"
                    + ", MATRICULA_ESTUDIANTE.USUARIO_ULTMODIFIC =  'DOC-" + testMon[19] + "' "
                    + "	WHERE  MATRICULA_ESTUDIANTE.COD_ESTUDIANTE = " + testMon[13] + "  AND  "
                    + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[9] + " AND "
                    + " MATRICULA_ESTUDIANTE.CICLO = " + testMon[10] + " AND "
                    + " MATRICULA_ESTUDIANTE.CODIGO_ESP = " + testMon[12] + " AND "
                    + " MATRICULA_ESTUDIANTE.NUM_MATRICULA = " + testMon[11] + "and "
                    + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[18] + " and "
                    + " MATRICULA_ESTUDIANTE.docente3_tesmon = " + testMon[19];
        }

        if (testMon[14].toString().equalsIgnoreCase("TP")) {
            if (testMon[17].toString().equalsIgnoreCase("NUM_HORAS5")) {
                ls_query = " UPDATE MATRICULA_ESTUDIANTE "
                        + "  SET NUM_CONSULTAS5 = " + testMon[7]
                        + ", NUM_HORAS5 = " + testMon[8] + ""
                        + ", MATRICULA_ESTUDIANTE.FECHA_ULTMODIFIC = convert(date, '" + formato.format(new Date()) + "', 103 )"
                        + ", MATRICULA_ESTUDIANTE.USUARIO_ULTMODIFIC =  'DOC-" + testMon[19] + "' "
                        + "	WHERE  MATRICULA_ESTUDIANTE.COD_ESTUDIANTE = " + testMon[13] + "  AND  "
                        + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[9] + " AND "
                        + " MATRICULA_ESTUDIANTE.CICLO = " + testMon[10] + " AND "
                        + " MATRICULA_ESTUDIANTE.CODIGO_ESP = " + testMon[12] + " AND "
                        + " MATRICULA_ESTUDIANTE.NUM_MATRICULA = " + testMon[11] + "and "
                        + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[18] + " and "
                        + " MATRICULA_ESTUDIANTE.docente5_tesmon = " + testMon[19];
            }
            if (testMon[17].toString().equalsIgnoreCase("NUM_HORAS6")) {
                ls_query = " UPDATE MATRICULA_ESTUDIANTE "
                        + "  SET NUM_CONSULTAS6 = " + testMon[7]
                        + ", NUM_HORAS6 = " + testMon[8] + ""
                        + ", MATRICULA_ESTUDIANTE.FECHA_ULTMODIFIC = convert(date, '" + formato.format(new Date()) + "', 103 )"
                        + ", MATRICULA_ESTUDIANTE.USUARIO_ULTMODIFIC =  'DOC-" + testMon[19] + "' "
                        + "	WHERE  MATRICULA_ESTUDIANTE.COD_ESTUDIANTE = " + testMon[13] + "  AND  "
                        + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[9] + " AND "
                        + " MATRICULA_ESTUDIANTE.CICLO = " + testMon[10] + " AND "
                        + " MATRICULA_ESTUDIANTE.CODIGO_ESP = " + testMon[12] + " AND "
                        + " MATRICULA_ESTUDIANTE.NUM_MATRICULA = " + testMon[11] + "and "
                        + " MATRICULA_ESTUDIANTE.ANIO = " + testMon[18] + " and "
                        + " MATRICULA_ESTUDIANTE.docente6_tesmon = " + testMon[19];
            }

        }

        em.createNativeQuery(ls_query).executeUpdate();
        return null;
    } 
}

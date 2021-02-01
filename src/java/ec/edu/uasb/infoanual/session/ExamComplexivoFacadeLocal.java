/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.infoanual.session;

import ec.edu.uasb.infoanual.entities.ExamComplexivo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johana.orozco
 */
@Local
public interface ExamComplexivoFacadeLocal {

    void create(ExamComplexivo examComplexivo);

    void edit(ExamComplexivo examComplexivo);

    void remove(ExamComplexivo examComplexivo);

    ExamComplexivo find(Object id);

    List<ExamComplexivo> findAll();

    List<ExamComplexivo> findRange(int[] range);

    int count();
    
}

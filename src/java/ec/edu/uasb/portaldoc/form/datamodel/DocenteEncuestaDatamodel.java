/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.portaldoc.form.datamodel;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author victor.barba
 */
public class DocenteEncuestaDatamodel extends ListDataModel<EncuEvalDocente> implements Serializable, SelectableDataModel<EncuEvalDocente> {

    public DocenteEncuestaDatamodel() {
    }

    public DocenteEncuestaDatamodel(List<EncuEvalDocente> list) {
        super(list);
    }

    @Override
    public Object getRowKey(EncuEvalDocente object) {
        return object.getEncuEvalDocentePK();
    }

    @Override
    public EncuEvalDocente getRowData(String rowKey) {
        List<EncuEvalDocente> objetos = (List<EncuEvalDocente>) getWrappedData();
        for (EncuEvalDocente ae : objetos) {
//            Long profesor = Long.parseLong(rowKey.substring(0, rowKey.indexOf("-")));
//            Long materia = Long.parseLong(rowKey.substring(rowKey.indexOf("-") + 1, rowKey.indexOf(";")));
//            Long esp = Long.parseLong(rowKey.substring(rowKey.indexOf(";") + 1));
            if (ae.getEncuEvalDocentePK().toString().equals(rowKey)) {
                return ae;
            }
        }
        return null;
    }

}

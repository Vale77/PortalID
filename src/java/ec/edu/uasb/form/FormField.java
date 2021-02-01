/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.form;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author victor.barba
 */
public class FormField implements Serializable {

    private static final long serialVersionUID = 20120521L;
    private Object value;
    private Object key;
    private boolean required;
    private List<SelectItem> selectItems;

    public FormField(Object key,boolean required) {
        this.required = required;
        this.key = key;
    }

    public FormField(Object value,Object key, boolean required) {
        this.value = value;
        this.key = key;
        this.required = required;
    }

    public FormField(Object value,Object key, List<SelectItem> selectItems, boolean required) {
        this.value = value;
        this.key = key;
        this.required = required;
        this.selectItems = selectItems;
    }

   
    public Object getFormattedValue() {
        if (value instanceof Date) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM yyyy");

            return simpleDateFormat.format(value);
        }

        return value;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * @return the selectItems
     */
    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    /**
     * @param selectItems the selectItems to set
     */
    public void setSelectItems(List<SelectItem> selectItems) {
        this.selectItems = selectItems;
    }

    /**
     * @return the key
     */
    public Object getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(Object key) {
        this.key = key;
    }
}

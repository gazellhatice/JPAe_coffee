package Converter;

import DAO.SuppliersDAO;
import Entity.Suppliers;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Hatice
 */
@Named
@RequestScoped
@FacesConverter(value = "suppliersConverter", managed = true)
public class SuppliersConverter implements Converter, Serializable {

    @EJB
    private SuppliersDAO dao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.isBlank()) {
            int id = Integer.parseInt(string);
            return this.getDao().findById(id);
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t != null) {
            Suppliers c = (Suppliers) t;

            return String.valueOf(c.getSupplierId());
        } else {
            return "";
        }
    }

    public SuppliersDAO getDao() {
          if(this.dao== null){
            this.dao = new SuppliersDAO();
        }
        return dao;
    }

    public void setDao(SuppliersDAO dao) {
        this.dao = dao;
    }

}

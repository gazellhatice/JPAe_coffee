package Converter;

import DAO.PermissionsDAO;
import Entity.Permissions;
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
@FacesConverter(value = "permissionsConverter", managed = true)
public class PermissionsConverter implements Converter, Serializable {
     @EJB
    private PermissionsDAO dao;

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
            Permissions a = (Permissions) t;

            return String.valueOf(a.getPermissionId());
        } else {
            return "";
        }
    }

    public PermissionsDAO getDao() {
          if(this.dao== null){
            this.dao = new PermissionsDAO();
        }
        return dao;
    }

    public void setDao(PermissionsDAO dao) {
        this.dao = dao;
    }
}

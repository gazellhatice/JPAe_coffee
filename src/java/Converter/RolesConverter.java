package Converter;

/**
 *
 * @author Hatice
 */


import DAO.RolesDAO;
import Entity.Roles;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
@FacesConverter(value = "rolesConverter", managed = true)
public class RolesConverter implements Converter, Serializable {

    @EJB
    private RolesDAO dao;

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
            Roles c = (Roles) t;

            return String.valueOf(c.getRoleId());
        } else {
            return "";
        }
    }

    public RolesDAO getDao() {
          if(this.dao== null){
            this.dao = new RolesDAO();
        }
        return dao;
    }

    public void setDao(RolesDAO dao) {
        this.dao = dao;
    }

}



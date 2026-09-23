package Converter;

/**
 *
 * @author Hatice
 */

import DAO.UserDAO;
import Entity.Users;
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
@FacesConverter(value = "usersConverter", managed = true)
public class UsersConverter implements Converter, Serializable {

    @EJB
    private UserDAO dao;

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
            Users c = (Users) t;

            return String.valueOf(c.getUserId());
        } else {
            return "";
        }
    }

    public UserDAO getDao() {
          if(this.dao== null){
            this.dao = new UserDAO();
        }
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

}


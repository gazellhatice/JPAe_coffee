package Converter;

/**
 *
 * @author Hatice
 */


import DAO.AddressesDAO;
import Entity.Addresses;
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
@FacesConverter(value = "addressesConverter", managed = true)
public class AddressesConverter implements Converter, Serializable {

    @EJB
    private AddressesDAO dao;

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
            Addresses a = (Addresses) t;

            return String.valueOf(a.getAddressId());
        } else {
            return "";
        }
    }

    public AddressesDAO getDao() {
          if(this.dao== null){
            this.dao = new AddressesDAO();
        }
        return dao;
    }

    public void setDao(AddressesDAO dao) {
        this.dao = dao;
    }

}



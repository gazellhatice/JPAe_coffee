package Converter;

import DAO.ProductcategoriesDAO;
import Entity.Productcategories;
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
@FacesConverter(value = "productcategoriesConverter", managed = true)
public class ProductcategoriesConverter implements Converter, Serializable {

    @EJB
    private ProductcategoriesDAO dao;

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
            Productcategories c = (Productcategories) t;

            return String.valueOf(c.getCategoryId());
        } else {
            return "";
        }
    }

    public ProductcategoriesDAO getDao() {
          if(this.dao== null){
            this.dao = new ProductcategoriesDAO();
        }
        return dao;
    }

    public void setDao(ProductcategoriesDAO dao) {
        this.dao = dao;
    }

}

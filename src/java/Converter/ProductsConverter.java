package Converter;

/**
 *
 * @author Hatice
 */


import DAO.ProductsDAO;
import Entity.Products;
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
@FacesConverter(value = "productsConverter", managed = true)
public class ProductsConverter implements Converter, Serializable {

    @EJB
    private ProductsDAO dao;

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
            Products c = (Products) t;

            return String.valueOf(c.getProductId());
        } else {
            return "";
        }
    }

    public ProductsDAO getDao() {
          if(this.dao== null){
            this.dao = new ProductsDAO();
        }
        return dao;
    }

    public void setDao(ProductsDAO dao) {
        this.dao = dao;
    }

}



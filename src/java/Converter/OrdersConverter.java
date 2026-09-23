package Converter;

/**
 *
 * @author Hatice
 */


import DAO.OrdersDAO;
import Entity.Orders;
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
@FacesConverter(value = "ordersConverter", managed = true)
public class OrdersConverter implements Converter, Serializable {

    @EJB
    private OrdersDAO dao;

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
            Orders c = (Orders) t;

            return String.valueOf(c.getOrderId());
        } else {
            return "";
        }
    }

    public OrdersDAO getDao() {
          if(this.dao== null){
            this.dao = new OrdersDAO();
        }
        return dao;
    }

    public void setDao(OrdersDAO dao) {
        this.dao = dao;
    }

}



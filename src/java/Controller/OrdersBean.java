/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.OrdersDAO;
import Entity.Orders;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gokce
 */
@Named(value = "ordersBean")
@SessionScoped
public class OrdersBean extends AbstractBean<Orders> implements Serializable {

    @EJB
    private OrdersDAO OrdersDAO;

    private Orders orders;

    public OrdersBean() {
        super(Orders.class);
        orders = new Orders();
    }

    @Override
    public List<Orders> getList() {
        return OrdersDAO.getList(this.hangiSayfa, this.gorunenVeri);
    }

    @Override
    public void create() {
        OrdersDAO.insert(orders);
        orders = new Orders(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int orderId) {
        OrdersDAO.delete(orderId);
    }

    @Override
    public void update(Orders orders) {
        OrdersDAO.update(orders);
    }

    @Override
    public void clearForm() {
        orders = new Orders();
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
    

    public OrdersDAO getOrdersDAO() {
          if (this.OrdersDAO == null) {
            this.OrdersDAO = new OrdersDAO();
        }
        return OrdersDAO;
    }

    public void setOrdersDAO(OrdersDAO OrdersDAO) {
        this.OrdersDAO = OrdersDAO;
    }


    protected int gorunenVeri = 5;
    protected int hangiSayfa = 1;

    public void prev() {
        hangiSayfa--;
    }

    public void next() {
        hangiSayfa++;
    }

    public int getGorunenVeri() {
        return gorunenVeri;
    }

    public void setGorunenVeri(int gorunenVeri) {
        this.gorunenVeri = gorunenVeri;
    }

    public int getHangiSayfa() {
        return hangiSayfa;
    }

    public void setHangiSyfa(int hangiSyfa) {
        this.hangiSayfa = hangiSyfa;
    }
}

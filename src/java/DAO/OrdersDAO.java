package DAO;

import Entity.Orders;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hatice
 */
@Local
@Stateless
public class OrdersDAO extends AbstractDAO<Orders> implements Serializable {

    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

   public List<Orders> getList(int hangiSayfa, int gorunenVeri) {
    String queryString = "SELECT o FROM Orders o"; // Assuming you want to select from Orders table
    Query query = em.createQuery(queryString)
                    .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                    .setMaxResults(gorunenVeri);
    List<Orders> ordersList = query.getResultList();
    
    return ordersList;
}

    @Override
    public void insert(Orders orders) {
        try {
            em.persist(orders);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Orders orders) {
        try {
            em.merge(orders);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int orderId) {
        try {
            Orders orders = em.find(Orders.class, orderId);
            if (orders != null) {
                em.remove(orders);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Orders findById(int orderId) {

        Orders pc = em.find(Orders.class, orderId);

        return pc;
    }
}

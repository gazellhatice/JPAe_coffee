package DAO;

/**
 *
 * @author Hatice
 */


import Entity.Carts;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;


@Local
@Stateless
public class CartsDAO extends AbstractDAO<Carts> implements Serializable{
    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

   public List<Carts> getList(int hangiSayfa, int gorunenVeri) {
    String queryString = "SELECT c FROM Carts c"; 
    Query query = em.createQuery(queryString)
                    .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                    .setMaxResults(gorunenVeri);
    List<Carts> cartList = query.getResultList();
    
    return cartList;
}

    @Override
    public void insert(Carts Carts) {
        try {
            em.persist(Carts);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Carts Carts) {
        try {
            em.merge(Carts);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int cartId) {
        try {
            Carts carts = em.find(Carts.class, cartId);
            if (carts != null) {
                em.remove(carts);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Carts findById(int cartId) {

        Carts pc = em.find(Carts.class, cartId);

        return pc;
    }

   
}


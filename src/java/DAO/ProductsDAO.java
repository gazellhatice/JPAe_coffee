package DAO;

import Entity.Products;
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
public class ProductsDAO extends AbstractDAO<Products> implements Serializable {

    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

    public List<Products> getList() {
        String string = "SELECT p FROM Products p";
        Query query = em.createQuery(string);
        List<Products> List = query.getResultList();

        return List;
    }

    @Override
    public void insert(Products Products) {
        try {
            em.persist(Products);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Products Products) {
        try {
            em.merge(Products);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int productId) {
        try {
            Products Products = em.find(Products.class, productId);
            if (Products != null) {
                em.remove(Products);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Products findById(int productId) {

        Products pc = em.find(Products.class, productId);

        return pc;
    }
}

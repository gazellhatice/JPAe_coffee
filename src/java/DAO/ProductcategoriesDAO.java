package DAO;

import Entity.Productcategories;
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
public class ProductcategoriesDAO extends AbstractDAO<Productcategories> implements Serializable {

    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

    public List<Productcategories> getList() {
        String string = "SELECT p FROM Productcategories p";
        Query query = em.createQuery(string);
        List<Productcategories> categoryList = query.getResultList();
       
        return categoryList;
    }

    @Override
    public void insert(Productcategories productCategory) {
        try {
            em.persist(productCategory);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Productcategories productCategory) {
        try {
            em.merge(productCategory);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int categoryId) {
        try {
            Productcategories category = em.find(Productcategories.class, categoryId);
            if (category != null) {
                em.remove(category);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Productcategories findById(int categoryId) {

        Productcategories pc = em.find(Productcategories.class, categoryId);
   
        return pc;
    }

}

package DAO;

import Entity.Suppliers;
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
public class SuppliersDAO extends AbstractDAO<Suppliers> implements Serializable{
     @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

    public List<Suppliers> getList() {
        String string = "SELECT s FROM Suppliers s";
        Query query = em.createQuery(string);
        List<Suppliers> List = query.getResultList();
       
        return List;
    }

    @Override
    public void insert(Suppliers Suppliers) {
        try {
            em.persist(Suppliers);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Suppliers Suppliers) {
        try {
            em.merge(Suppliers);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int supplier_id) {
        try {
            Suppliers Suppliers = em.find(Suppliers.class, supplier_id);
            if (Suppliers != null) {
                em.remove(Suppliers);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Suppliers findById(int supplier_id) {

        Suppliers pc = em.find(Suppliers.class, supplier_id);

        return pc;
    }
}

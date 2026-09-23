package DAO;

import Entity.Permissions;
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
public class PermissionsDAO extends AbstractDAO<Permissions> implements Serializable{
       @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

    public List<Permissions> getList() {
        String string = "SELECT p FROM Permissions p";
        Query query = em.createQuery(string);
        List<Permissions> list = query.getResultList();
       
        return list;
    }

    @Override
    public void insert(Permissions Permissions) {
        try {
            em.persist(Permissions);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Permissions permissions) {
        try {
            em.merge(permissions);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int permissionId) {
        try {
            Permissions Permissions = em.find(Permissions.class, permissionId);
            if (Permissions != null) {
                em.remove(Permissions);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Permissions findById(int permissionId) {

        Permissions pc = em.find(Permissions.class, permissionId);

    
        return pc;
    }
}

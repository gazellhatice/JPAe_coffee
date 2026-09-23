package DAO;

import Entity.Roles;
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
public class RolesDAO extends AbstractDAO<Roles> implements Serializable{
     @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

    public List<Roles> getList() {
        String string = "SELECT r FROM Roles r";
        Query query = em.createQuery(string);
        List<Roles> rolesList = query.getResultList();
       
        return rolesList;
    }

    @Override
    public void insert(Roles Roles) {
        try {
            em.persist(Roles);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Roles Roles) {
        try {
            em.merge(Roles);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int roleId) {
        try {
            Roles roles = em.find(Roles.class, roleId);
            if (roles != null) {
                em.remove(roles);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Roles findById(int roleId) {

        Roles pc = em.find(Roles.class, roleId);

      
        return pc;
    }
}

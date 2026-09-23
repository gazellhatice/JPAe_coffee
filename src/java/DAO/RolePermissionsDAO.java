package DAO;

import Entity.Rolepermissions;
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
public class RolePermissionsDAO extends AbstractDAO<Rolepermissions> implements Serializable{
    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

   public List<Rolepermissions> getList(int hangiSayfa, int gorunenVeri) {
    String queryString = "SELECT rp FROM Rolepermissions rp"; 
    Query query = em.createQuery(queryString)
                    .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                    .setMaxResults(gorunenVeri);
    List<Rolepermissions> rolepermissionsList = query.getResultList();
    
    return rolepermissionsList;
}

    @Override
    public void insert(Rolepermissions Rolepermissions) {
        try {
            em.persist(Rolepermissions);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Rolepermissions RolePermissions) {
        try {
            em.merge(RolePermissions);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int rolepermissionsId) {
        try {
            Rolepermissions rolePermissions = em.find(Rolepermissions.class, rolepermissionsId);
            if (rolePermissions != null) {
                em.remove(rolePermissions);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Rolepermissions findById(int rolepermissionsId) {

        Rolepermissions pc = em.find(Rolepermissions.class, rolepermissionsId);

        return pc;
    }
}

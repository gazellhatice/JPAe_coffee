package DAO;


import Entity.Users;
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
public class UserDAO extends AbstractDAO<Users> implements Serializable{
    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

   public List<Users> getList(int hangiSayfa, int gorunenVeri) {
    String queryString = "SELECT u FROM Users u"; // Assuming you want to select from Orders table
    Query query = em.createQuery(queryString)
                    .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                    .setMaxResults(gorunenVeri);
    List<Users> userList = query.getResultList();
    
    return userList;
}

    @Override
    public void insert(Users Users) {
        try {
            em.persist(Users);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Users Users) {
        try {
            em.merge(Users);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int userId) {
        try {
            Users users = em.find(Users.class, userId);
            if (users != null) {
                em.remove(users);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Users findById(int userId) {

        Users pc = em.find(Users.class, userId);

        return pc;
    }

   
}

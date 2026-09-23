package DAO;

/**
 *
 * @author Hatice
 */
import Entity.Addresses;
import Entity.Payments;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;


@Local
@Stateless
public class PaymentsDAO extends AbstractDAO<Payments> implements Serializable{
    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

    public List<Payments> getList(int hangiSayfa, int gorunenVeri) {
        String queryString = "SELECT p FROM Payments p"; // Assuming you want to select from Orders table
        Query query = em.createQuery(queryString)
                    .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                    .setMaxResults(gorunenVeri);
        List<Payments> paymentsList = query.getResultList();
       
        return paymentsList;
    }

    public void insert(Payments Payments) {
        try {
            em.persist(Payments);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public void update(Payments Payments) {
        try {
            em.merge(Payments);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int paymentId) {
        try {
            Payments payments = em.find(Payments.class, paymentId);
            if (payments != null) {
                em.remove(payments);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Payments findById(int paymentId) {

        Payments pc = em.find(Payments.class, paymentId);

        return pc;
    }
}


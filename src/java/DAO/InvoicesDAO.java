package DAO;

/**
 *
 * @author Hatice
 */



import Entity.Invoices;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;


@Local
@Stateless
public class InvoicesDAO extends AbstractDAO<Invoices> implements Serializable{
    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

   public List<Invoices> getList(int hangiSayfa, int gorunenVeri) {
    String queryString = "SELECT i FROM Invoices i"; 
    Query query = em.createQuery(queryString)
                    .setFirstResult((hangiSayfa - 1) * gorunenVeri)
                    .setMaxResults(gorunenVeri);
    List<Invoices> invoicesList = query.getResultList();
    
    return invoicesList;
}

    @Override
    public void insert(Invoices Invoices) {
        try {
            em.persist(Invoices);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Invoices Invoices) {
        try {
            em.merge(Invoices);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int InvoiceId) {
        try {
            Invoices invoices = em.find(Invoices.class, InvoiceId);
            if (invoices != null) {
                em.remove(invoices);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Invoices findById(int InvoiceId) {

        Invoices pc = em.find(Invoices.class, InvoiceId);

        return pc;
    }

   
}


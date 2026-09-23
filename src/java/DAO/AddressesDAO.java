package DAO;

import Entity.Addresses;
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
public class AddressesDAO extends AbstractDAO<Addresses> implements Serializable{
    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

    public List<Addresses> getList() {
        String string = "SELECT a FROM Addresses a";
        Query query = em.createQuery(string);
        List<Addresses> adresList = query.getResultList();
       
        return adresList;
    }

    @Override
    public void insert(Addresses Addresses) {
        try {
            em.persist(Addresses);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void update(Addresses Addresses) {
        try {
            em.merge(Addresses);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int addressId) {
        try {
            Addresses adres = em.find(Addresses.class, addressId);
            if (adres != null) {
                em.remove(adres);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public Addresses findById(int addressId) {

        Addresses pc = em.find(Addresses.class, addressId);

        return pc;
    }
}

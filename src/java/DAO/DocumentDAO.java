package DAO;

import Entity.Document;
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
public class DocumentDAO implements Serializable {

    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

    public void insert(Document document) {
        try {
            em.persist(document);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public List<Document> getList() {
        String queryString = "SELECT d FROM Document d";
        Query query = em.createQuery(queryString);
        List<Document> List = query.getResultList();
        return List;
    }
}

package Controller;

/**
 *
 * @author Hatice
 */



import DAO.InvoicesDAO;
import Entity.Invoices;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "invoicesBean")
@SessionScoped
public class InvoicesBean extends AbstractBean<Invoices> implements Serializable {

    @EJB
    private InvoicesDAO InvoicesDAO;

    private Invoices Invoices;

    public InvoicesBean() {
        super(Invoices.class);
        Invoices = new Invoices();
    }

    @Override
    public List<Invoices> getList() {
        return InvoicesDAO.getList(this.hangiSayfa, this.gorunenVeri);
    }

    @Override
    public void create() {
        InvoicesDAO.insert(Invoices);
        Invoices = new Invoices(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int InvoiceId) {
        InvoicesDAO.delete(InvoiceId);
    }

    @Override
    public void update(Invoices Invoices) {
        InvoicesDAO.update(Invoices);
    }

    @Override
    public void clearForm() {
        Invoices = new Invoices();
    }

    public Invoices getInvoices() {
        return Invoices;
    }

    public void setInvoices(Invoices Invoices) {
        this.Invoices = Invoices;
    }

    
    public InvoicesDAO getInvoicesDAO() {
          if (this.InvoicesDAO == null) {
            this.InvoicesDAO = new InvoicesDAO();
        }
        return InvoicesDAO;
    }

    public void setInvoicesDAO(InvoicesDAO InvoicesDAO) {
        this.InvoicesDAO = InvoicesDAO;
    }

   

    protected int gorunenVeri = 5;
    protected int hangiSayfa = 1;

    public void prev() {
        hangiSayfa--;
    }

    public void next() {
        hangiSayfa++;
    }

    public int getGorunenVeri() {
        return gorunenVeri;
    }

    public void setGorunenVeri(int gorunenVeri) {
        this.gorunenVeri = gorunenVeri;
    }

    public int getHangiSayfa() {
        return hangiSayfa;
    }

    public void setHangiSyfa(int hangiSyfa) {
        this.hangiSayfa = hangiSyfa;
    }
}


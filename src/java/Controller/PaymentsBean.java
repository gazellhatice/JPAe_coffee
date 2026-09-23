package Controller;

/**
 *
 * @author Hatice
 */

import DAO.PaymentsDAO;
import Entity.Payments;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "paymentsBean")
@SessionScoped
public class PaymentsBean extends AbstractBean<Payments> implements Serializable {

    @EJB
    private PaymentsDAO PaymentsDAO;

    private Payments Payments;

    public PaymentsBean() {
        super(Payments.class);
        Payments = new Payments();
    }

    @Override
    public List<Payments> getList() {
        return PaymentsDAO.getList(this.hangiSayfa, this.gorunenVeri);
    }

    @Override
    public void create() {
        PaymentsDAO.insert(Payments);
        Payments = new Payments(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int userId) {
        PaymentsDAO.delete(userId);
    }

    @Override
    public void update(Payments Payments) {
        PaymentsDAO.update(Payments);
    }

    @Override
    public void clearForm() {
        Payments = new Payments();
    }

    public Payments getPayments() {
        return Payments;
    }

    public void setPayments(Payments Payments) {
        this.Payments = Payments;
    }
    

    public PaymentsDAO getPaymentsDAO() {
          if (this.PaymentsDAO == null) {
            this.PaymentsDAO = new PaymentsDAO();
        }
        return PaymentsDAO;
    }

    public void setPaymentsDAO(PaymentsDAO PaymentsDAO) {
        this.PaymentsDAO = PaymentsDAO;
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


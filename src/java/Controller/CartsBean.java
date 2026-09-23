package Controller;

/**
 *
 * @author Hatice
 */


import DAO.CartsDAO;
import Entity.Carts;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "cartsBean")
@SessionScoped
public class CartsBean extends AbstractBean<Carts> implements Serializable {

    @EJB
    private CartsDAO CartsDAO;

    private Carts Carts;

    public CartsBean() {
        super(Carts.class);
        Carts = new Carts();
    }

    @Override
    public List<Carts> getList() {
        return CartsDAO.getList(this.hangiSayfa, this.gorunenVeri);
    }

    @Override
    public void create() {
        CartsDAO.insert(Carts);
        Carts = new Carts(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int cartId) {
        CartsDAO.delete(cartId);
    }

    @Override
    public void update(Carts Carts) {
        CartsDAO.update(Carts);
    }

    @Override
    public void clearForm() {
        Carts = new Carts();
    }

    public Carts getCarts() {
        return Carts;
    }

    public void setCarts(Carts Carts) {
        this.Carts = Carts;
    }

    
    public CartsDAO getCartsDAO() {
          if (this.CartsDAO == null) {
            this.CartsDAO = new CartsDAO();
        }
        return CartsDAO;
    }

    public void setCartsDAO(CartsDAO CartsDAO) {
        this.CartsDAO = CartsDAO;
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


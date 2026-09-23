package Controller;

import DAO.AddressesDAO;
import Entity.Addresses;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hatice
 */
@Named(value = "addressesBean")
@SessionScoped
public class AddressesBean extends AbstractBean<Addresses> implements Serializable {

  
    @EJB
    private AddressesDAO AddressesDAO;

    private Addresses addresses;

    public AddressesBean() {
        super(Addresses.class);
        addresses = new Addresses();
    }

    @Override
    public List<Addresses> getList() {
        return AddressesDAO.getList();
    }

    @Override
    public void create() {
        AddressesDAO.insert(addresses);
        addresses = new Addresses(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int addressId) {
        AddressesDAO.delete(addressId);
    }

    @Override
    public void update(Addresses Addresses) {
        AddressesDAO.update(addresses);
    }

    @Override
    public void clearForm() {
        addresses = new Addresses();
    }

    public AddressesDAO getAddressesDAO() {
        if (this.AddressesDAO == null) {
            this.AddressesDAO = new AddressesDAO();
        }
        return AddressesDAO;
    }

    public void setAddressesDAO(AddressesDAO AddressesDAO) {
        this.AddressesDAO = AddressesDAO;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }
    
}

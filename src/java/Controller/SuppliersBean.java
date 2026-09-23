/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.SuppliersDAO;
import Entity.Suppliers;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gokce
 */
@Named(value = "suppliersBean")
@SessionScoped
public class SuppliersBean extends AbstractBean<Suppliers> implements Serializable {

   @EJB
    private SuppliersDAO SuppliersDAO;

    private Suppliers Suppliers;

    public SuppliersBean() {
         super(Suppliers.class);
        Suppliers = new Suppliers();
    }


    @Override
    public List<Suppliers> getList() {
        return SuppliersDAO.getList();
    }

    @Override
    public void create() {
        SuppliersDAO.insert(Suppliers);
        Suppliers = new Suppliers(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int supplierId) {
        SuppliersDAO.delete(supplierId);
    }

    @Override
    public void update(Suppliers Suppliers) {
        SuppliersDAO.update(Suppliers);
    }

    @Override
    public void clearForm() {
        Suppliers = new Suppliers();
    }

    public SuppliersDAO getSuppliersDAO() {
     if (this.SuppliersDAO == null) {
            this.SuppliersDAO = new SuppliersDAO();
        }
        return SuppliersDAO;
    }

    public void setSuppliersDAO(SuppliersDAO SuppliersDAO) {
        this.SuppliersDAO = SuppliersDAO;
    }

    public Suppliers getSuppliers() {
        return Suppliers;
    }

    public void setSuppliers(Suppliers Suppliers) {
        this.Suppliers = Suppliers;
    }
    
}

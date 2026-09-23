/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.ProductcategoriesDAO;
import Entity.Productcategories;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gokce
 */
@Named(value = "categoryBean")
@SessionScoped
public class ProductcategoriesBean extends AbstractBean<Productcategories> implements Serializable {

    @EJB
    private ProductcategoriesDAO productcategoriesDAO;

    private Productcategories productCategory;

    public ProductcategoriesBean() {
        super(Productcategories.class);
        productCategory = new Productcategories();
    }

    @Override
    public List<Productcategories> getList() {
        return productcategoriesDAO.getList();
    }

    @Override
    public void create() {
        productcategoriesDAO.insert(productCategory);
        productCategory = new Productcategories(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int categoryId) {
        productcategoriesDAO.delete(categoryId);
    }

    @Override
    public void update(Productcategories productCategory) {
        productcategoriesDAO.update(productCategory);
    }

    @Override
    public void clearForm() {
        productCategory = new Productcategories();
    }

    public Productcategories getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Productcategories productCategory) {
        this.productCategory = productCategory;
    }

    public ProductcategoriesDAO getProductcategoriesDAO() {
          if (this.productcategoriesDAO == null) {
            this.productcategoriesDAO = new ProductcategoriesDAO();
        }
        return productcategoriesDAO;
    }

    public void setProductcategoriesDAO(ProductcategoriesDAO productcategoriesDAO) {
        this.productcategoriesDAO = productcategoriesDAO;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.ProductsDAO;
import Entity.Products;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gokce
 */
@Named(value = "productsBean")
@SessionScoped
public class ProductsBean  extends AbstractBean<Products> implements Serializable {

    @EJB
    private ProductsDAO ProductsDAO;

    private Products Products;

    public ProductsBean() {
        super(Products.class);
        Products = new Products();
    }

    @Override
    public List<Products> getList() {
        return ProductsDAO.getList();
    }

    @Override
    public void create() {
        ProductsDAO.insert(Products);
        Products = new Products(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int roleId) {
        ProductsDAO.delete(roleId);
    }

    @Override
    public void update(Products Products) {
        ProductsDAO.update(Products);
    }

    @Override
    public void clearForm() {
        Products = new Products();
    }

    public ProductsDAO getProductsDAO() {
    if (this.ProductsDAO == null) {
            this.ProductsDAO = new ProductsDAO();
        }
        return ProductsDAO;
    }

    public void setProductsDAO(ProductsDAO ProductsDAO) {
        this.ProductsDAO = ProductsDAO;
    }

    public Products getProducts() {
        return Products;
    }

    public void setProducts(Products Products) {
        this.Products = Products;
    }
    

}

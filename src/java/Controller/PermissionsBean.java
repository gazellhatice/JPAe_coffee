/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.PermissionsDAO;
import Entity.Permissions;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gokce
 */
@Named(value = "permissionsBean")
@SessionScoped
public class PermissionsBean extends AbstractBean<Permissions> implements Serializable {

    @EJB
    private PermissionsDAO PermissionsDAO;

    private Permissions permissions;

    public PermissionsBean() {
        super(Permissions.class);
        permissions = new Permissions();
    }

    @Override
    public List<Permissions> getList() {
        return PermissionsDAO.getList();
    }

    @Override
    public void create() {
        PermissionsDAO.insert(permissions);
        permissions = new Permissions(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int roleId) {
        PermissionsDAO.delete(roleId);
    }

    @Override
    public void update(Permissions permissions) {
        PermissionsDAO.update(permissions);
    }

    @Override
    public void clearForm() {
        permissions = new Permissions();
    }

    public PermissionsDAO getPermissionsDAO() {
        if (this.PermissionsDAO == null) {
            this.PermissionsDAO = new PermissionsDAO();
        }
        return PermissionsDAO;
    }

    public void setPermissionsDAO(PermissionsDAO PermissionsDAO) {
        this.PermissionsDAO = PermissionsDAO;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

}

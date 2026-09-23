/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import DAO.RolesDAO;
import Entity.Roles;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gokce
 */
@Named(value = "rolesBean")
@SessionScoped
public class RolesBean  extends AbstractBean<Roles> implements Serializable {

   @EJB
    private RolesDAO RolesDAO;

    private Roles roles;

    public RolesBean() {
        super(Roles.class);
        roles = new Roles();
    }

    @Override
    public List<Roles> getList() {
        return RolesDAO.getList();
    }

    @Override
    public void create() {
        RolesDAO.insert(roles);
        roles = new Roles(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int roleId) {
        RolesDAO.delete(roleId);
    }

    @Override
    public void update(Roles roles) {
        RolesDAO.update(roles);
    }

    @Override
    public void clearForm() {
        roles = new Roles();
    }

    public RolesDAO getRolesDAO() {
        if (this.RolesDAO == null) {
            this.RolesDAO = new RolesDAO();
        }
        return RolesDAO;
    }

    public void setRolesDAO(RolesDAO RolesDAO) {
        this.RolesDAO = RolesDAO;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
    
}

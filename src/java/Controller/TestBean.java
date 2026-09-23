/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controller;

import Entity.Users;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gokce
 */
@Named(value = "testBean")
@SessionScoped
public class TestBean implements Serializable {

    private String username;
    private String password;
    private static final List<Users> usersList = new ArrayList<>();

    public TestBean() {
    }

    public void validatePassword(FacesContext context, UIComponent component, Object value) {
        String password = (String) value;

        if (password == null || password.isEmpty()) {
            throw new ValidatorException(new FacesMessage("Password cannot be empty"));
        } else if (password.length() < 8) {
            throw new ValidatorException(new FacesMessage("Password must be at least 8 characters long"));
        }
    }

    public void register() {
        Users newUser = new Users(username, password, null, null);
        usersList.add(newUser);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully registered!", null));
    }

    public static List<Users> getUsersList() {
        return usersList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

package Controller;

import Entity.Users;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hatice
 */

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private Users user;
    private Users validUser;
    private boolean usernameCorrect;
    private boolean passwordCorrect;

    public LoginBean() {
    }

    public void login() {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lütfen kullanıcı adını giriniz!", null);
            FacesContext.getCurrentInstance().addMessage("loginForm:typeEmailX", message);
            return;
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lütfen şifrenizi giriniz!", null);
            FacesContext.getCurrentInstance().addMessage("loginForm:typePasswordX", message);
            return;
        }

        usernameCorrect = false;
        passwordCorrect = false;

        List<Users> usersList = TestBean.getUsersList();
        for (Users u : usersList) {
            if (u.getUsername().equals(user.getUsername())) {
                usernameCorrect = true;
                if (u.getPassword().equals(user.getPassword())) {
                    passwordCorrect = true;
                    validUser = u;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", user);
                    return;
                }
            }
        }

        if (!usernameCorrect) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kullanıcı adı yanlış!", null);
            FacesContext.getCurrentInstance().addMessage("loginForm:typeEmailX", message);
        }

        if (!passwordCorrect) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre yanlış!", null);
            FacesContext.getCurrentInstance().addMessage("loginForm:typePasswordX", message);
        }
    }

    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public Users getUser() {
        if (user == null) {
            user = new Users();
        }
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getValidUser() {
        return validUser;
    }

    public void setValidUser(Users validUser) {
        this.validUser = validUser;
    }

    public boolean isUsernameCorrect() {
        return usernameCorrect;
    }

    public boolean isPasswordCorrect() {
        return passwordCorrect;
    }
}

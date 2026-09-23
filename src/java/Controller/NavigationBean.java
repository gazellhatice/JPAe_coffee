package Controller;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;

/**
 * NavigationBean for handling page navigation in JSF.
 */
@Named(value = "navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public void navigateTo(String page) throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("/JPAe_coffee/module/"+ page + ".xhtml");
    }

    public String page(String p) {
        return "/module/" + p + "?faces-redirect=true";
    }
}

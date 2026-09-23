package Controller;

/**
 *
 * @author Hatice
 */

import DAO.RolePermissionsDAO;
import Entity.Rolepermissions;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "rolepermissionsBean")
@SessionScoped
public class RolePermissionsBean extends AbstractBean<Rolepermissions> implements Serializable {

    @EJB
    private RolePermissionsDAO RolePermissionsDAO;

    private Rolepermissions Rolepermissions;

    public RolePermissionsBean() {
        super(Rolepermissions.class);
        Rolepermissions = new Rolepermissions();
    }

    @Override
    public List<Rolepermissions> getList() {
        return RolePermissionsDAO.getList(this.hangiSayfa, this.gorunenVeri);
    }

    @Override
    public void create() {
        RolePermissionsDAO.insert(Rolepermissions);
        Rolepermissions = new Rolepermissions(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int rolepermissionsId) {
        RolePermissionsDAO.delete(rolepermissionsId);
    }

    @Override
    public void update(Rolepermissions Rolepermissions) {
        RolePermissionsDAO.update(Rolepermissions);
    }

    @Override
    public void clearForm() {
        Rolepermissions = new Rolepermissions();
    }

    public Rolepermissions getRolepermissions() {
        return Rolepermissions;
    }

    public void setRolepermissions(Rolepermissions Rolepermissions) {
        this.Rolepermissions = Rolepermissions;
    }

    
    public RolePermissionsDAO getRolePermissionsDAO() {
          if (this.RolePermissionsDAO == null) {
            this.RolePermissionsDAO = new RolePermissionsDAO();
        }
        return RolePermissionsDAO;
    }

    public void setRolePermissionsDAO(RolePermissionsDAO RolePermissionsDAO) {
        this.RolePermissionsDAO = RolePermissionsDAO;
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


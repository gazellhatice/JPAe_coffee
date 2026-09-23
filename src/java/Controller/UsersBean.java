package Controller;

/**
 *
 * @author Hatice
 */

import DAO.UserDAO;
import Entity.Users;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "usersBean")
@SessionScoped
public class UsersBean extends AbstractBean<Users> implements Serializable {

    @EJB
    private UserDAO UserDAO;

    private Users users;

    public UsersBean() {
        super(Users.class);
        users = new Users();
    }

    @Override
    public List<Users> getList() {
        return UserDAO.getList(this.hangiSayfa, this.gorunenVeri);
    }

    @Override
    public void create() {
        UserDAO.insert(users);
        users = new Users(); // Reset the product category object after insertion
    }

    @Override
    public void delete(int userId) {
        UserDAO.delete(userId);
    }

    @Override
    public void update(Users Users) {
        UserDAO.update(Users);
    }

    @Override
    public void clearForm() {
        users = new Users();
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    
    public UserDAO getUserDAO() {
          if (this.UserDAO == null) {
            this.UserDAO = new UserDAO();
        }
        return UserDAO;
    }

    public void setUserDAO(UserDAO UserDAO) {
        this.UserDAO = UserDAO;
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


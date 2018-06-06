package service;

import dBHelper.DBHelper;
import dao.DAO;
import dao.HibernetDAOImp;
import model.User;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserServiceImp implements Service {

    private DAO dao;

    UserServiceImp(){
        this.dao = new HibernetDAOImp(DBHelper.getConfiguration());
    }

    public boolean insertUser(User user) {
        return dao.insertUser(user);
    }

    public boolean deleteUser(User user) {
        return dao.deleteUser(user);
    }

    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }

    public User getUser(int id) {
        return dao.getUser(id);
    }

    public User getUserByLogin(String login) {
        return dao.getUserByLogin(login);
    }

    public List<User> getListOfAllUsers() {
        return dao.getListOfAllUsers();
    }
}

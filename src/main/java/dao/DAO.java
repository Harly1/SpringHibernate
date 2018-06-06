package dao;

import model.User;
import java.util.List;

public interface DAO {

    boolean insertUser(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user);

    User getUser(int id);

    User getUserByLogin(String login);

    List<User> getListOfAllUsers();
}
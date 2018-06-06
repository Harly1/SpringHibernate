package service;

import model.User;

import java.util.List;

public interface Service {

    boolean insertUser(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user);

    User getUser(int id);

    User getUserByLogin(String login);

    List<User> getListOfAllUsers();
}

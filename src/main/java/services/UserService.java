package services;

import dao.UserDAO;
import entities.User;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public void addUser(String name, String mail) {
        User user = new User(name, mail);
        userDAO.addUser(user);
    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }
}

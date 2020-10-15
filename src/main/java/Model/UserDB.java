package Model;

import java.util.ArrayList;


public class UserDB {
    private final ArrayList<User> users = new ArrayList<>();

    public boolean add(User user) {
        for (User userFromDB : users) {
            if (userFromDB.getLogin().equals(user.getLogin()) && userFromDB.getPassword().equals(user.getPassword())) {
                return false;
            }
        }
        return users.add(user);
    }

    public boolean userIsExist(final String login, final String password) {

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

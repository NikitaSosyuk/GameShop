package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface UserDAO {
    boolean saveUser(String username, String password);
    User getUserByID(int id);
    User getUserByName(String username);
    boolean userIsExist(String username, String password);
}

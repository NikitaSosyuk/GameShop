package Model.UserServices;

import java.sql.SQLException;

public interface UserDAO {
    boolean saveUser(String username, String password);
    User getUserByID(int id);
    User getUserByName(String username);
    boolean userIsExist(String username, String password);
    public boolean changeUsernameById(int id, String username) throws SQLException;
    public boolean changeEmailById(int id, String email) throws SQLException;
}

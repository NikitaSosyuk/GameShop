package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDB implements UserDAO{

    private static MySQLConnection connection = new MySQLConnection();

    private static final String SQL_INSERT_INTO_USERS
            = "INSERT INTO NNGamingShopDB.users(username, password) VALUES (?, ?)";

    private static final String SQL_SELECT_USER_BY_ID
            = "SELECT id, username, password, registrationTimestamp FROM NNGamingShopDB.users where id = ?";

    private static final String SQL_SELECT_USER_BY_USERNAME
            = "SELECT id, username, password, registrationTimestamp FROM NNGamingShopDB.users where username = ?";

    private static final String SQL_SELECT_USER_BY_USERNAME_AND_PASSWORD
            = "SELECT id, username, password, registrationTimestamp FROM NNGamingShopDB.users where username = ? AND password = ?";


    @Override
    public boolean saveUser(String username, String password) {

        User user = UserService.enrollUser(username, password);

        if (user == null) {
            return false;
        }

        try(Connection conn = connection.getNewConnection()){
            try(PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_INTO_USERS)){
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());

                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }

    public User getUserByID(int id) {
        try(Connection conn = connection.getNewConnection()){
            try(PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_USER_BY_ID)){
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                return getUserFromDB(preparedStatement);
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByName(String username) {
        try(Connection conn = connection.getNewConnection()){
            try(PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_USER_BY_USERNAME)){
                preparedStatement.setString(1, username);

                return getUserFromDB(preparedStatement);
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean userIsExist(String username, String password) {
        if (username == null || password == null){
            return false;
        }

        try(Connection conn = connection.getNewConnection()){
            try(PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_USER_BY_USERNAME_AND_PASSWORD)){
                preparedStatement.setString(1, username);
                preparedStatement.setString(2,  UserService.generateSecurePassword(password));

                if (getUserFromDB(preparedStatement) != null) {
                    return true;
                }
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }

    private User getUserFromDB(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;

        if (resultSet.next()){
            user = new User();
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setRegistrationTimestamp(resultSet.getTimestamp(4));
        }

        return user;
    }
}

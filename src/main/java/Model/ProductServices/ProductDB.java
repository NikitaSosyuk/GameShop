package Model.ProductServices;

import Model.MySQLConnection;
import Model.UserServices.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDB implements ProductDAO {
    private static MySQLConnection connection = new MySQLConnection();

    private static final String SQL_SELECT_PRODUCT_BY_ID
            = "SELECT id, `name`, description, company, image, price, count_of_mark, rating FROM NNGamingShopDB.products where id = ?";

    public Product getProductByID(int id) {
        try(Connection conn = connection.getNewConnection()){
            try(PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_PRODUCT_BY_ID)){
                preparedStatement.setInt(1, id);

                return getProductFromDB(preparedStatement);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private Product getProductFromDB(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        Product product = null;

        if (resultSet.next()){
            product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setImage(resultSet.getString("image"));
            product.setCompany(resultSet.getString("company"));
            product.setPrice(resultSet.getDouble("price"));
            product.setCountOfMark(resultSet.getInt("count_of_mark"));
            product.setRating(resultSet.getDouble("rating"));
        }

        return product;
    }

}

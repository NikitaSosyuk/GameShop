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
            = "SELECT id, `name`, description, company, image, price, count_of_marks, rating FROM products JOIN `product-rating` ON product_id = id WHERE id = ?";

    private static final String SQL_CHANGE_RATING_BY_PRODUCT_ID = "UPDATE `product-rating` SET count_of_marks = ?, rating = ? WHERE product_id = ?";

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
            product.setCountOfMark(resultSet.getInt("count_of_marks"));
            product.setRating(resultSet.getDouble("rating"));
        }

        return product;
    }

    public boolean setMark(int mark, int productId) throws SQLException {
        try(Connection conn = connection.getNewConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_PRODUCT_BY_ID)) {
                preparedStatement.setInt(1, productId);

                Product product = getProductFromDB(preparedStatement);
                double currentRating = product.getRating();
                int currentCountOfMark = product.getCountOfMark();

                try (PreparedStatement preparedStatementForRating = conn.prepareStatement(SQL_CHANGE_RATING_BY_PRODUCT_ID)) {
                    preparedStatementForRating.setInt(1, currentCountOfMark + 1);
                    preparedStatementForRating.setDouble(2, (currentRating*currentCountOfMark + mark)/(currentCountOfMark + 1));
                    preparedStatementForRating.setInt(3, productId);
                    preparedStatementForRating.executeUpdate();
                }

                return true;
            }
        }
    }
}

package Model.BasketServices;

import Model.MySQLConnection;
import Model.ProductServices.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BasketDB implements BasketDAO {
    private static MySQLConnection connection = new MySQLConnection();

    private static final String SQL_INSERT_INTO_USERBASKET
            = "INSERT INTO NNGamingShopDB.user_basket(username, product_id) VALUES (?, ?)";

    private static final String SQL_SELECT_PRODUCTS_FROM_BASKET_BY_USERNAME
            = "SELECT * FROM products JOIN user_basket ON product_id = products.id WHERE username = ?";

    private static final String SQL_DELETE_PRODUCT_FROM_BASKET
            = "DELETE FROM user_basket WHERE product_id = ? LIMIT 1";

    private static final String SQL_CLEAN_BASKET_FOR_USER
            = "DELETE FROM user_basket WHERE username = ?";

    public boolean saveProductToBasket(String username, int productId){
        try(Connection conn = connection.getNewConnection()) {
            try(PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_INTO_USERBASKET)) {
                preparedStatement.setString(1, username);
                preparedStatement.setInt(2, productId);

                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public LinkedList<Product> getListOfProductsInBasketByUsername(String username) throws SQLException {
         try(Connection conn = connection.getNewConnection()) {
             try(PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_PRODUCTS_FROM_BASKET_BY_USERNAME)) {
                 preparedStatement.setString(1, username);

                 return getListOfProductsFromDB(preparedStatement);
             }
         }
    }

    private LinkedList<Product> getListOfProductsFromDB(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        Product product = null;
        LinkedList<Product> listOfProducts = new LinkedList<>();

        while (resultSet.next()){
            product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setImage(resultSet.getString("image"));
            product.setCompany(resultSet.getString("company"));
            product.setPrice(resultSet.getDouble("price"));
            product.setCountOfMark(resultSet.getInt("count_of_mark"));
            product.setRating(resultSet.getDouble("rating"));

            listOfProducts.add(product);
        }

        return listOfProducts;
    }

    public boolean deleteProductFromBasket(int productId) throws SQLException {
        try (Connection conn = connection.getNewConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE_PRODUCT_FROM_BASKET)) {
                preparedStatement.setInt(1, productId);
                preparedStatement.executeUpdate();
                return true;
            }
        }
    }

    public boolean cleanBasketForUser(String username) throws SQLException {
        try (Connection conn = connection.getNewConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_CLEAN_BASKET_FOR_USER)) {
                preparedStatement.setString(1, username);
                preparedStatement.executeUpdate();
                return true;
            }
        }
    }
}

package Model.PurchasesServices;

import Model.MySQLConnection;
import Model.ProductServices.Product;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PurchasesDB implements PurchasesDAO {
    private static MySQLConnection connection = new MySQLConnection();

    private static final String SQL_INSERT_PRODUCT_IN_PURCHASES
            = "INSERT INTO NNGamingShopDB.users_purchases(username, product_id) VALUES (?, ?)";

    private static final String SQL_SELECT_PURCHASE_TIMESTAMP_OF_LAST_PURCHASE
            = "SELECT purchase_timestamp FROM NNGamingShopDB.users_purchases WHERE username = ? ORDER BY purchase_timestamp DESC LIMIT 1";

    private static final String SQL_SELECT_LAST_PURCHASE_BY_USERNAME
            = "SELECT * FROM products JOIN users_purchases ON product_id = products.id WHERE username = ? AND purchase_timestamp = ?";

    private static final String SQL_SELECT_PURCHASES_BY_USERNAME
            = "SELECT * FROM products JOIN users_purchases ON product_id = products.id WHERE username = ?";

    public boolean insertProductsIntoDB(String username, List<Product> products) throws SQLException {
        try (Connection conn = connection.getNewConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT_PRODUCT_IN_PURCHASES)) {
                for (Product product : products) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setInt(2, product.getId());

                    preparedStatement.executeUpdate();
                }
                return true;
            }
        }
    }

    public List<Product> getLastPurchaseList(String username) throws SQLException {
        try (Connection conn = connection.getNewConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_LAST_PURCHASE_BY_USERNAME)) {
                Timestamp timestamp = getLastTimestamp(username);

                preparedStatement.setString(1, username);
                preparedStatement.setTimestamp(2, timestamp);

                return getListOfProductsFromDB(preparedStatement);
            }
        }
    }

    public Product getLastPurchase(String username) throws SQLException {
        if (getLastPurchaseList(username).isEmpty()) {
            return null;
        } else {
            return getLastPurchaseList(username).get(0);
        }
    }

    public int getCountOfPurchase(String username) throws SQLException {
        try (Connection conn = connection.getNewConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_PURCHASES_BY_USERNAME)) {
                preparedStatement.setString(1, username);

                return getListOfProductsFromDB(preparedStatement).size();
            }
        }
    }

    private Timestamp getLastTimestamp(String username) throws SQLException {
        try (Connection conn = connection.getNewConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_PURCHASE_TIMESTAMP_OF_LAST_PURCHASE)) {
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();

                Timestamp timestamp = null;

                if (resultSet.next()) {
                    timestamp = resultSet.getTimestamp("purchase_timestamp");
                }

                return timestamp;
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
}

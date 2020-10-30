package Model.PurchasesServices;

import Model.ProductServices.Product;

import java.sql.SQLException;
import java.util.List;

public interface PurchasesDAO {
    public boolean insertProductsIntoDB(String username, List<Product> products) throws SQLException;
    public List<Product> getLastPurchaseList(String username) throws SQLException;
    public Product getLastPurchase(String username) throws SQLException;
    public int getCountOfPurchase(String username) throws SQLException;
}

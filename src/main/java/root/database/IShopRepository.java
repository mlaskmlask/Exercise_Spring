package root.database;

import root.model.Product;

import java.util.List;

public interface IShopRepository {
    List<Product> getProducts();

    List<Product> getRTV();

    List<Product> getAGD();

    boolean buyProd(String nameBuy, int piecesBuy);

}

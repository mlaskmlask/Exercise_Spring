package root.database;

import org.springframework.stereotype.Component;
import root.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopRepositoryImpl implements IShopRepository {
    private List<Product> productList = new ArrayList<>();

    public ShopRepositoryImpl() {
        productList.add(new Product("Pralka", 20, "biała", "Bosch", Product.Category.AGD, 1500));
        productList.add(new Product("Lodówka", 15, "szara", "Amica", Product.Category.AGD, 1200));
        productList.add(new Product("Płyta indukcyjna", 10, "srebrna", "Samsung", Product.Category.AGD, 1000));
        productList.add(new Product("Telewizor", 10, "czarny", "Panasonic", Product.Category.RTV, 2000));
        productList.add(new Product("Zestaw stereo", 20, "brąz", "Yamaha", Product.Category.RTV, 3000));
        productList.add(new Product("Zmywarka", 30, "srebrna", "Siemens", Product.Category.AGD, 2500));
        productList.add(new Product("Ekspres do kawy", 12, "czarny", "Philips", Product.Category.AGD, 3000));
    }

    public List<Product> getProducts() {
        return this.productList;
    }

    public List<Product> getRTV() {
        List<Product> rtvList = new ArrayList<>();
        for (Product currentProduct : this.productList) {
            if (currentProduct.getCategory() == Product.Category.RTV) {
                rtvList.add(currentProduct);
            }
        }
        return rtvList;
    }

    public List<Product> getAGD() {
        List<Product> agdList = new ArrayList<>();
        for (Product currentProduct : this.productList) {
            if (currentProduct.getCategory() == Product.Category.AGD) {
                agdList.add(currentProduct);
            }
        }
        return agdList;
    }

    public boolean buyProd(String nameBuy, int piecesBuy) {
        for (Product currentProduct : this.productList) {
            if (currentProduct.getName().equals(nameBuy)) {
                if (currentProduct.getPieces() >= piecesBuy) {
                    currentProduct.setPieces(currentProduct.getPieces() - piecesBuy);
                    return true;
                }
            }
        }
        return false;
    }
}

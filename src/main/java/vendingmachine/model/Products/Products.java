package vendingmachine.model.Products;

import java.util.List;
import vendingmachine.model.Product;

public class Products {
    private final List<Product> products;

    private Products(List<Product> products) {
        this.products = products;
    }

    public static Products createProducts(List<Product> products) {
        return new Products(products);
    }

    public List<Product> getProducts() {
        return products;
    }

}

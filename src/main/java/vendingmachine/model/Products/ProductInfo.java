package vendingmachine.model.Products;

import java.util.Comparator;
import java.util.List;
import vendingmachine.model.Product;

public class ProductInfo {
    private final Products products;
    private final int minPrice;

    private ProductInfo(List<Product> product) {
        this.products = Products.createProducts(product);
        this.minPrice = getMinPrice(products);
    }

    public static ProductInfo createProductInfo(List<Product> product) {
        return new ProductInfo(product);
    }


    public List<Product> getProducts() {
        return products.getProducts();
    }

    public int getMinPrice() {
        return minPrice;
    }


    private int getMinPrice(Products products) {
        return products.getProducts().stream()
                .min(Comparator.comparingInt(Product::getPrice))
                .map(Product::getPrice)
                .orElse(0);
    }


}

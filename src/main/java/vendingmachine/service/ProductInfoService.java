package vendingmachine.service;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.model.Product;
import vendingmachine.model.Products.ProductInfo;
import vendingmachine.view.input.InputView;

public class ProductInfoService {
    private final InputView inputView;

    public ProductInfoService(InputView inputView) {
        this.inputView = inputView;
    }

    public ProductInfo getProductInfo() {
        List<String[]> inputProducts = inputView.inputVendingMachineProduct();
        List<Product> products = new ArrayList<>();
        for (String[] product : inputProducts) {
            Product prod = Product.createProduct(product[0], Integer.parseInt(product[1]),
                    Integer.parseInt(product[2]));
            products.add(prod);
        }
        ProductInfo productInfo = ProductInfo.createProductInfo(products);
        return productInfo;
    }
}

package vendingmachine.model;

import static vendingmachine.constant.ConstantNumber.One;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.BUY_PRODUCT_IS_CHEAPER_THAN_PRODUCT;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.BUY_PRODUCT_IS_SOLD_OUT;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.BUY_PRODUCT_MUST_BE_IN_VENDING_MACHINE;

import java.util.List;
import vendingmachine.exception.ErrorInputException;

public class BuyProduct {
    private final String buyProduct;

    private BuyProduct(List<Product> products, String buyProduct, int inputMoney) {
        isNotProduct(products, buyProduct);
        isCheap(products, buyProduct, inputMoney);
        isSoldOut(products, buyProduct);
        this.buyProduct = buyProduct;
    }

    public static BuyProduct createBuyProduct(List<Product> products, String buyProduct, int inputMoney) {
        return new BuyProduct(products, buyProduct, inputMoney);
    }

    public String getBuyProduct() {
        return buyProduct;
    }

    private void isNotProduct(List<Product> products, String input) {
        boolean exists = products.stream()
                .anyMatch(product -> product.getOrderName().equals(input));

        if (!exists) {
            throw new ErrorInputException(BUY_PRODUCT_MUST_BE_IN_VENDING_MACHINE);
        }
    }

    private void isCheap(List<Product> products, String input, int inputMoney) {
        Product prod = getProduct(products, input);

        if (prod.getPrice() > inputMoney) {
            throw new ErrorInputException(BUY_PRODUCT_IS_CHEAPER_THAN_PRODUCT);
        }
    }

    private void isSoldOut(List<Product> products, String input) {
        Product prod = getProduct(products, input);

        if (prod.getQuantity() < One) {
            throw new ErrorInputException(BUY_PRODUCT_IS_SOLD_OUT);
        }
    }

    public int buying(List<Product> products, String input) {
        Product prod = getProduct(products, input);
        prod.subtractQuantity();

        return prod.getPrice();
    }

    private static Product getProduct(List<Product> products, String input) {
        Product prod = products.stream()
                .filter(product -> product.getOrderName().equals(input))
                .findAny()
                .get();
        return prod;
    }
}

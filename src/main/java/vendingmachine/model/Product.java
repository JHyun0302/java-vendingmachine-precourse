package vendingmachine.model;

import static vendingmachine.constant.ConstantNumber.Hundred;
import static vendingmachine.constant.ConstantNumber.One;
import static vendingmachine.constant.ConstantNumber.Ten;
import static vendingmachine.constant.ConstantNumber.Zero;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INVALID_QUANTITY_ERROR;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INVALID_SELL_PRICE_ERROR;

import vendingmachine.exception.ErrorInputException;

public class Product {
    private String orderName;
    private int price;
    private int quantity;

    private Product(String orderName, int price, int quantity) {
        validatePriceAndQuantity(price, quantity);
        this.orderName = orderName;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product createProduct(String orderName, int price, int quantity) {
        return new Product(orderName, price, quantity);
    }

    public String getOrderName() {
        return orderName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void subtractQuantity() {
        this.quantity -= 1;
    }

    private void validatePriceAndQuantity(int price, int quantity) {
        validatePrice(price);
        validateQuantity(quantity);
    }

    private void validatePrice(int price) {
        if (price < Hundred || price % Ten != Zero) {
            throw new ErrorInputException(INVALID_SELL_PRICE_ERROR);
        }

    }

    private void validateQuantity(int quantity) {
        if (quantity < One) {
            throw new ErrorInputException(INVALID_QUANTITY_ERROR);
        }
    }
}

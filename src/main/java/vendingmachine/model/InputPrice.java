package vendingmachine.model;

import static vendingmachine.constant.ConstantNumber.Thousand;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INPUT_PRICE_CAN_NOT_DIVIDED_BY_THOUSAND;

import vendingmachine.exception.ErrorInputException;

public class InputPrice {
    private final int price;

    private InputPrice(int price) {
        isDividedByThousand(price);
        this.price = price;
    }

    public static InputPrice createInputPrice(int price) {
        return new InputPrice(price);
    }

    public int getPrice() {
        return price;
    }

    private void isDividedByThousand(int input) {
        if (input % Thousand != 0) {
            throw new ErrorInputException(INPUT_PRICE_CAN_NOT_DIVIDED_BY_THOUSAND);
        }
    }
}

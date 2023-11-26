package vendingmachine.validation;

import static vendingmachine.constant.ConstantNumber.Zero;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.BUY_PRODUCT_CANNOT_BE_NULL_OR_EMPTY;

import vendingmachine.exception.ErrorInputException;

/**
 * 구입 상품 검증
 */
public class BuyProductValidation {
    public String isNullOrEmpty(String input) {
        if (input == null || input.length() == Zero) {
            throw new ErrorInputException(BUY_PRODUCT_CANNOT_BE_NULL_OR_EMPTY);
        }
        return input;
    }
}

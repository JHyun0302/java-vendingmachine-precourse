package vendingmachine.validation;

import static vendingmachine.constant.ConstantNumber.Zero;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INPUT_PRICE_CANNOT_BE_NULL_OR_EMPTY;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INPUT_PRICE_IS_MORE_THAN_ONE;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INPUT_PRICE_IS_NOT_INTEGER;

import vendingmachine.exception.ErrorInputException;

/**
 * 투입 금액 검증
 */
public class InputPriceValidation {

    public void isNullOrEmpty(String input) {
        if (input == null || input.length() == Zero) {
            throw new ErrorInputException(INPUT_PRICE_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    public int isInteger(String input) {
        if (!isNumeric(input)) {
            throw new ErrorInputException(INPUT_PRICE_IS_NOT_INTEGER);
        }
        return Integer.parseInt(input);
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int isMoreThanOne(int input) {
        if (input <= Zero) {
            throw new ErrorInputException(INPUT_PRICE_IS_MORE_THAN_ONE);
        }
        return input;
    }
}

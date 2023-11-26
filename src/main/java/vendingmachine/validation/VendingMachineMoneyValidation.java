package vendingmachine.validation;

import static vendingmachine.constant.ConstantNumber.Ten;
import static vendingmachine.constant.ConstantNumber.Zero;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.VENDING_MACHINE_MONEY_CANNOT_BE_NULL_OR_EMPTY;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.VENDING_MACHINE_MONEY_IS_MORE_THAN_TEN;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.VENDING_MACHINE_MONEY_IS_NOT_INTEGER;

import vendingmachine.exception.ErrorInputException;

/**
 * 자판기 보유 금액 검증
 */
public class VendingMachineMoneyValidation {

    public void isNullOrEmpty(String input) {
        if (input == null || input.length() == Zero) {
            throw new ErrorInputException(VENDING_MACHINE_MONEY_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    public int isInteger(String input) {
        if (!isNumeric(input)) {
            throw new ErrorInputException(VENDING_MACHINE_MONEY_IS_NOT_INTEGER);
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

    public int isMoreThanTen(int input) {
        if (input < Ten) {
            throw new ErrorInputException(VENDING_MACHINE_MONEY_IS_MORE_THAN_TEN);
        }
        return input;
    }
}

package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INPUT_PRICE_CANNOT_BE_NULL_OR_EMPTY;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INPUT_PRICE_IS_MORE_THAN_ONE;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INPUT_PRICE_IS_NOT_INTEGER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputPriceValidationTest {
    private final InputPriceValidation inputPriceValidation;

    InputPriceValidationTest() {
        inputPriceValidation = new InputPriceValidation();
    }

    @DisplayName("투입 금액은 빈 값이거나 null 인 경우 예외가 발생한다.")
    @Test
    void isNullOrEmptyTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> inputPriceValidation.isNullOrEmpty(null));

        //then
        assertTrue(exception.getMessage().contains(INPUT_PRICE_CANNOT_BE_NULL_OR_EMPTY.getMessage()));
    }

    @DisplayName("투입 금액이 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void isIntegerTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> inputPriceValidation.isInteger("Not Integer"));

        //then
        assertTrue(exception.getMessage().contains(INPUT_PRICE_IS_NOT_INTEGER.getMessage()));
    }

    @DisplayName("투입 금액은 1원 이상이 아닌 경우 예외가 발생한다.")
    @Test
    void isMoreThanOneTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> inputPriceValidation.isMoreThanOne(0));

        //then
        assertTrue(exception.getMessage().contains(INPUT_PRICE_IS_MORE_THAN_ONE.getMessage()));
    }
}
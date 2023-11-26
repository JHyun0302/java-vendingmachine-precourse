package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.BUY_PRODUCT_CANNOT_BE_NULL_OR_EMPTY;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyProductValidationTest {
    private final BuyProductValidation buyProductValidation;

    BuyProductValidationTest() {
        buyProductValidation = new BuyProductValidation();
    }

    @DisplayName("구입 상품은 빈 값이거나 null 인 경우 예외가 발생한다.")
    @Test
    void isNullOrEmptyTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> buyProductValidation.isNullOrEmpty(null));

        //then
        assertTrue(exception.getMessage().contains(BUY_PRODUCT_CANNOT_BE_NULL_OR_EMPTY.getMessage()));
    }
}
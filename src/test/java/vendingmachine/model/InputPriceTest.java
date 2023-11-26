package vendingmachine.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INPUT_PRICE_CAN_NOT_DIVIDED_BY_THOUSAND;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputPriceTest {

    @DisplayName("투입 금액은 동전을 만들지 않는다. 1,000원 단위로 입력하지 않으면 예외 발생")
    @Test
    void isDividedByThousandTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputPrice.createInputPrice(1500));

        //then
        Assertions.assertTrue(exception.getMessage().contains(INPUT_PRICE_CAN_NOT_DIVIDED_BY_THOUSAND.getMessage()));
    }
}
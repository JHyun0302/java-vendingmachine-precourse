package vendingmachine.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.PRODUCT_CANNOT_BE_NULL_OR_EMPTY;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.PRODUCT_ERROR_INPUT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ProductValidationTest {
    private final ProductValidation productValidation;

    ProductValidationTest() {
        productValidation = new ProductValidation();
    }

    @DisplayName("상품은 빈 값이거나 null 인 경우 예외가 발생한다.")
    @Test
    void isNullOrEmptyTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> productValidation.isNullOrEmpty(null));

        //then
        assertTrue(exception.getMessage().contains(PRODUCT_CANNOT_BE_NULL_OR_EMPTY.getMessage()));
    }

    @DisplayName("올바르게 상품, 가격, 수량을 입력하면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20];[사이다,1000,10]"})
    void checkErrorInputTest(String input) {
        //then
        assertThatCode(() -> productValidation.checkErrorInput(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("올바르게 상품, 가격, 수량을 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "콜라,1500,20];[사이다,1000,10]",
            "[콜라,1500,20];[사이다,1000,10",
            "[콜라,1500,20][사이다,1000,10]",
            "[콜라,1500,20;[사이다,1000,10]",
            "[123,1500,20];[사이다,1000,10]",
    })
    void occurErrorWhenInputWrong(String input) {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> productValidation.checkErrorInput(input));

        //then
        assertTrue(exception.getMessage().contains(PRODUCT_ERROR_INPUT.getMessage()));
    }


}
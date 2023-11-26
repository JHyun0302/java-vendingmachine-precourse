package vendingmachine.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INVALID_QUANTITY_ERROR;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.INVALID_SELL_PRICE_ERROR;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProductTest {

    @DisplayName("상품 가격은 100원보다 낮으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"콜라, 50, 10"})
    void LowerPriceTest(String orderName, int price, int quantity) {
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Product.createProduct(orderName, price, quantity));

        //then
        assertTrue(exception.getMessage().contains(INVALID_SELL_PRICE_ERROR.getMessage()));
    }

    @DisplayName("상품 가격은 10원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"콜라, 5001, 10"})
    void DividePriceTest(String orderName, int price, int quantity) {
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Product.createProduct(orderName, price, quantity));

        //then
        assertTrue(exception.getMessage().contains(INVALID_SELL_PRICE_ERROR.getMessage()));
    }
    
    @DisplayName("상품의 수량이 1보다 낮으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"콜라, 5000, 0"})
    void LowQuantityTest(String orderName, int price, int quantity) {
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Product.createProduct(orderName, price, quantity));

        //then
        assertTrue(exception.getMessage().contains(INVALID_QUANTITY_ERROR.getMessage()));
    }
}
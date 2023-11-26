package vendingmachine.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.BUY_PRODUCT_IS_CHEAPER_THAN_PRODUCT;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.BUY_PRODUCT_MUST_BE_IN_VENDING_MACHINE;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyProductTest {

    private List<Product> products;
    private int inputPrice;

    @BeforeEach
    void init() {
        products = Arrays.asList(
                Product.createProduct("콜라", 2000, 10),
                Product.createProduct("사이다", 1000, 5),
                Product.createProduct("암바사", 1500, 1));
        inputPrice = 3000;
    }

    @DisplayName("상품이 아닌 물건 구매시 예외 발생")
    @Test
    void isNotProductTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> BuyProduct.createBuyProduct(products, "환타", inputPrice));

        //then
        assertTrue(exception.getMessage().contains(BUY_PRODUCT_MUST_BE_IN_VENDING_MACHINE.getMessage()));
    }

    @DisplayName("남은 투입 금액이 구입할 상품의 금액보다 낮은 경우 예외가 발생한다.")
    @Test
    void isCheapTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> BuyProduct.createBuyProduct(products, "콜라", 500));

        //then
        assertTrue(exception.getMessage().contains(BUY_PRODUCT_IS_CHEAPER_THAN_PRODUCT.getMessage()));
    }
}
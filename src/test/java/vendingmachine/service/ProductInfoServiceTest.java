package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.model.Products.ProductInfo;
import vendingmachine.validation.BuyProductValidation;
import vendingmachine.validation.InputPriceValidation;
import vendingmachine.validation.ProductValidation;
import vendingmachine.validation.VendingMachineMoneyValidation;
import vendingmachine.view.input.InputView;
import vendingmachine.view.input.template.InputValidatorTemplate;

class ProductInfoServiceTest {
    private final ProductInfoService productInfoService;

    ProductInfoServiceTest() {
        InputView inputView = new InputView(new VendingMachineMoneyValidation(),
                new InputPriceValidation(),
                new ProductValidation(),
                new BuyProductValidation(),
                new InputValidatorTemplate());
        productInfoService = new ProductInfoService(inputView);
    }

    @DisplayName("상품 정보 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20];[사이다,1000,10]"})
    void getProductInfoTest(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        ProductInfo productInfo = productInfoService.getProductInfo();

        //then
        assertEquals(productInfo.getProducts().size(), 2);
        assertEquals(productInfo.getMinPrice(), 1000);
    }
}
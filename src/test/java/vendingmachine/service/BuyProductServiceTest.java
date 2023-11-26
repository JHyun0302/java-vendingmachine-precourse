package vendingmachine.service;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.model.Product;
import vendingmachine.model.Products.ProductInfo;
import vendingmachine.validation.BuyProductValidation;
import vendingmachine.validation.InputPriceValidation;
import vendingmachine.validation.ProductValidation;
import vendingmachine.validation.VendingMachineMoneyValidation;
import vendingmachine.view.input.InputView;
import vendingmachine.view.input.template.InputValidatorTemplate;
import vendingmachine.view.output.OutputView;

class BuyProductServiceTest {
    private final BuyProductService buyProductService;

    BuyProductServiceTest() {
        InputView inputView = new InputView(new VendingMachineMoneyValidation(),
                new InputPriceValidation(),
                new ProductValidation(),
                new BuyProductValidation(),
                new InputValidatorTemplate());
        OutputView outputView = new OutputView();
        buyProductService = new BuyProductService(inputView, outputView);
    }

    @BeforeEach
    void setUp() {
    }

    /**
     * 구입 상품 계속해서 입력해야함..
     */
    @DisplayName("상품 구매 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"콜라", "사이다"})
    void buyProductsTest(String orderName) {
        //given
        List<Product> testData = createTestData();
        ProductInfo productInfo = ProductInfo.createProductInfo(testData);

        System.setIn(new ByteArrayInputStream(orderName.getBytes()));
        //when
        buyProductService.buyProducts(productInfo, 3000);

        //then
    }

    private List<Product> createTestData() {
        return Arrays.asList(
                Product.createProduct("콜라", 2000, 10),
                Product.createProduct("사이다", 1000, 5)
        );
    }
}
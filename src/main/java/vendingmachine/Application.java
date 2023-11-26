package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.service.BuyProductService;
import vendingmachine.service.ProductInfoService;
import vendingmachine.validation.BuyProductValidation;
import vendingmachine.validation.InputPriceValidation;
import vendingmachine.validation.ProductValidation;
import vendingmachine.validation.VendingMachineMoneyValidation;
import vendingmachine.view.input.InputView;
import vendingmachine.view.input.template.InputValidatorTemplate;
import vendingmachine.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // 객체 생성
        InputView inputView = createInputView();
        OutputView outputView = new OutputView();

        BuyProductService buyProductService = createBuyProductService(inputView, outputView);
        ProductInfoService productInfoService = createProductInfoService(inputView);

        VendingMachineController vendingMachineController = createVendingMachineController(inputView, outputView,
                buyProductService, productInfoService);

        // 메서드 호출
        executeControllers(vendingMachineController);
    }

    private static InputView createInputView() {
        VendingMachineMoneyValidation vendingMachineMoneyValidation = new VendingMachineMoneyValidation();
        InputPriceValidation inputPriceValidation = new InputPriceValidation();
        ProductValidation productValidation = new ProductValidation();
        BuyProductValidation buyProductValidation = new BuyProductValidation();
        InputValidatorTemplate template = new InputValidatorTemplate();
        return new InputView(vendingMachineMoneyValidation, inputPriceValidation, productValidation,
                buyProductValidation, template);
    }

    private static BuyProductService createBuyProductService(InputView inputView, OutputView outputView) {
        return new BuyProductService(inputView, outputView);
    }

    private static ProductInfoService createProductInfoService(InputView inputView) {
        return new ProductInfoService(inputView);
    }

    private static VendingMachineController createVendingMachineController(InputView inputView,
                                                                           OutputView outputView,
                                                                           BuyProductService buyProductService,
                                                                           ProductInfoService productInfoService) {
        return new VendingMachineController(inputView, outputView, buyProductService, productInfoService);
    }

    private static void executeControllers(VendingMachineController vendingMachineController) {
        vendingMachineController.run();
    }
}
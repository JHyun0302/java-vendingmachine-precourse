package vendingmachine.controller;

import vendingmachine.dto.ChangeDto;
import vendingmachine.dto.InputMoneyDto;
import vendingmachine.model.InputPrice;
import vendingmachine.model.Products.ProductInfo;
import vendingmachine.model.VendingMachineMoney;
import vendingmachine.service.BuyProductService;
import vendingmachine.service.ProductInfoService;
import vendingmachine.view.input.InputView;
import vendingmachine.view.output.OutputView;

public class VendingMachineController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BuyProductService buyProductService;
    private final ProductInfoService productInfoService;


    public VendingMachineController(InputView inputView, OutputView outputView, BuyProductService buyProductService,
                                    ProductInfoService productInfoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.buyProductService = buyProductService;
        this.productInfoService = productInfoService;
    }

    public void run() {
        outputView.printVendingMachineMoney();
        VendingMachineMoney vmMoney = createVendingMachineMoney();// 자판기 보유 금액 + 보유 동전

        outputView.printProductInfo();
        ProductInfo productInfo = productInfoService.getProductInfo(); // 상품명, 가격, 수량 정보

        outputView.printInputMoney();
        InputPrice inputPrice = createInputPrice(); // 투입금액 입력

        int remainingMoney = buyProductService.buyProducts(productInfo, inputPrice.getPrice());
        InputMoneyDto inputMoneyDto = InputMoneyDto.createInputMoneyDto(remainingMoney);
        outputView.printMoneyInfo(inputMoneyDto.getAmount());

        outputView.printRemainMoney(); // 잔돈
        ChangeDto changeDto = ChangeDto.createChangeDto(vmMoney.getChange(remainingMoney));
        outputView.printChange(changeDto.getChange(), inputMoneyDto.getAmount());
    }


    private InputPrice createInputPrice() {
        while (true) {
            try {
                int inputMoney = inputView.inputPrice();
                return InputPrice.createInputPrice(inputMoney);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private VendingMachineMoney createVendingMachineMoney() {
        while (true) {
            try {
                int vendingMachineMoney = inputView.inputVendingMachineMoney();
                VendingMachineMoney vmMoney = VendingMachineMoney.createVendingMachineMoney(vendingMachineMoney);
                outputView.printVendingMachineCoinInfo(vmMoney);
                return vmMoney;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}

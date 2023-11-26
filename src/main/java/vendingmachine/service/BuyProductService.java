package vendingmachine.service;

import vendingmachine.model.BuyProduct;
import vendingmachine.model.Products.ProductInfo;
import vendingmachine.view.input.InputView;
import vendingmachine.view.output.OutputView;

public class BuyProductService {
    private final InputView inputView;
    private final OutputView outputView;

    public BuyProductService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int buyProducts(ProductInfo productInfo, int inputMoney) {
        while (true) {
            outputView.printMoneyInfo(inputMoney);
            outputView.printBuyProductName();
            BuyProduct buyProduct = createBuyProduct(productInfo, inputMoney);

            inputMoney -= buyProduct.buying(productInfo.getProducts(), buyProduct.getBuyProduct());
            if (inputMoney < productInfo.getMinPrice()) {
                break;
            }
        }
        return inputMoney;
    }

    private BuyProduct createBuyProduct(ProductInfo productInfo, int inputMoney) {
        while (true) {
            try {
                String buyProd = inputView.inputBuyProduct();
                return BuyProduct.createBuyProduct(productInfo.getProducts(), buyProd, inputMoney);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}

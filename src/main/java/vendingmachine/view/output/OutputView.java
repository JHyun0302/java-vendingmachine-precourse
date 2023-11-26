package vendingmachine.view.output;

import static vendingmachine.constant.ConstantNumber.Zero;
import static vendingmachine.constant.PrintOutMessage.EMPTY_LINE;
import static vendingmachine.constant.PrintOutMessage.NONE;
import static vendingmachine.constant.PrintOutMessage.PLZ_INPUT_BUY_PRODUCT_NAME;
import static vendingmachine.constant.PrintOutMessage.PLZ_INPUT_MONEY;
import static vendingmachine.constant.PrintOutMessage.PLZ_INPUT_PRODUCT_INFO;
import static vendingmachine.constant.PrintOutMessage.PLZ_INPUT_VENDING_MACHINE_MONEY;
import static vendingmachine.constant.PrintOutMessage.REMAIN_MONEY;
import static vendingmachine.constant.PrintOutMessage.VENDING_MACHINE_COIN_INFO;
import static vendingmachine.constant.PrintOutMessage.getCoinInfo;
import static vendingmachine.constant.PrintOutMessage.getRemainMoney;

import java.util.Map;
import vendingmachine.constant.Coin;
import vendingmachine.constant.PrintOutMessage;
import vendingmachine.model.VendingMachineMoney;

public class OutputView {
    public void printVendingMachineMoney() {
        System.out.println(PLZ_INPUT_VENDING_MACHINE_MONEY.message);
    }

    public void printVendingMachineCoinInfo(VendingMachineMoney vendingMachineMoney) {
        System.out.println(VENDING_MACHINE_COIN_INFO.message);
        System.out.println(getCoinInfo(vendingMachineMoney));
    }

    public void printProductInfo() {
        System.out.println(PLZ_INPUT_PRODUCT_INFO.message);
    }

    public void printInputMoney() {
        System.out.println(PLZ_INPUT_MONEY.message);
    }

    public void printMoneyInfo(int inputPrice) {
        System.out.println(getRemainMoney(inputPrice));

    }

    public void printBuyProductName() {
        System.out.println(PLZ_INPUT_BUY_PRODUCT_NAME.message);
    }

    public void printRemainMoney() {
        System.out.println(REMAIN_MONEY.message);
    }

    public void printChange(Map<Coin, Integer> change, int inputMoney) {
        if (inputMoney == Zero) {
            System.out.println(NONE.message);
        }
        for (Coin coin : change.keySet()) {
            int count = change.get(coin);
            if (count > Zero) {
                System.out.println(PrintOutMessage.getChange(coin, count));
            }
        }
    }

    public void printErrorMessage(final String message) {
        System.out.print(message + EMPTY_LINE.message);
    }
}

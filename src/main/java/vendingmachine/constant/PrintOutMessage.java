package vendingmachine.constant;

import java.util.Arrays;
import vendingmachine.model.VendingMachineMoney;

public enum PrintOutMessage {
    PLZ_INPUT_VENDING_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    VENDING_MACHINE_COIN_INFO("자판기가 보유한 동전"),
    PLZ_INPUT_PRODUCT_INFO("상품명과 가격, 수량을 입력해 주세요."),
    PLZ_INPUT_MONEY("투입 금액을 입력해 주세요."),
    MONEY_INFO("투입 금액:"),
    PLZ_INPUT_BUY_PRODUCT_NAME("구매할 상품명을 입력해 주세요."),
    REMAIN_MONEY("잔돈"),
    NONE("없음"),
    WON("원"),
    SPACE(" "),
    DASH("-"),
    COUNT("개"),
    EMPTY_LINE("\n");

    public final String message;

    PrintOutMessage(final String message) {
        this.message = message;
    }


    public static String getCoinInfo(VendingMachineMoney vendingMachineMoney) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Coin.values())
                .forEach(coin -> sb.append(coin.toString())
                        .append(WON.message)
                        .append(SPACE.message)
                        .append(DASH.message)
                        .append(SPACE.message)
                        .append(vendingMachineMoney.getCoins().getOrDefault(coin, 0))
                        .append(COUNT.message)
                        .append("\n"));
        return sb.toString();
    }

    public static String getRemainMoney(int remainMoney) {
        return MONEY_INFO.message + SPACE.message + remainMoney + WON.message;
    }

    public static String getChange(Coin coin, int count) {
        return coin + WON.message + SPACE.message + DASH.message + SPACE.message + count + COUNT.message;
    }
}

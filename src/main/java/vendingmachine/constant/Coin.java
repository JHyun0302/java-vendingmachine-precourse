package vendingmachine.constant;

import static vendingmachine.exception.ErrorInputException.ErrorMessage.INVALID_COIN_AMOUNT_ERROR;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.exception.ErrorInputException;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }

    public static final List<Integer> coins = Arrays.stream(values())
            .map(coin -> coin.amount)
            .collect(Collectors.toList());

    public static Coin pickRandomCoin() {
        int amount = Randoms.pickNumberInList(coins);

        for (Coin coin : Coin.values()) {
            if (amount == coin.amount) {
                return coin;
            }
        }
        throw new ErrorInputException(INVALID_COIN_AMOUNT_ERROR);
    }

    public int subtractIfPossible(int money, Map<Coin, Integer> vendingMachineCoin) {
        if (money >= amount) {
            vendingMachineCoin.put(this, vendingMachineCoin.getOrDefault(this, 0) + 1);
            return money - amount;
        }
        return money;
    }
}

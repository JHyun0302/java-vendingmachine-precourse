package vendingmachine.model;

import static vendingmachine.constant.ConstantNumber.Ten;
import static vendingmachine.constant.ConstantNumber.Zero;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.VENDING_MACHINE_MONEY_CAN_NOT_DIVIDED_BY_THOUSAND;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import vendingmachine.constant.Coin;
import vendingmachine.exception.ErrorInputException;

public class VendingMachineMoney {
    private final Map<Coin, Integer> coins;

    private VendingMachineMoney(int money) {
        isDividedByTen(money);
        this.coins = generateCoin(money);
    }

    public static VendingMachineMoney createVendingMachineMoney(int money) {
        return new VendingMachineMoney(money);
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    private Map<Coin, Integer> generateCoin(int money) {
        Map<Coin, Integer> vendingMachineCoin = new EnumMap<>(Coin.class);

        while (money > 0) {
            Coin selectedCoin = Coin.pickRandomCoin();
            money = selectedCoin.subtractIfPossible(money, vendingMachineCoin);
        }

        return vendingMachineCoin;
    }

    private int isDividedByTen(int input) {
        if ((input % Ten) != Zero) {
            throw new ErrorInputException(VENDING_MACHINE_MONEY_CAN_NOT_DIVIDED_BY_THOUSAND);
        }
        return input;
    }

    public Map<Coin, Integer> getChange(int change) {
        Map<Coin, Integer> changeCoins = new EnumMap<>(Coin.class);
        List<Coin> coins = Arrays.asList(Coin.values());
        coins.sort(Comparator.reverseOrder());

        for (Coin coin : coins) {
            int amount = coin.getAmount();
            int count = 0;
            int coinCount = this.coins.getOrDefault(coin, 0);

            while (change >= amount && coinCount > 0) {
                change -= amount;
                coinCount--;
                count++;
            }
            changeCoins.put(coin, count);
        }

        return changeCoins;
    }
}

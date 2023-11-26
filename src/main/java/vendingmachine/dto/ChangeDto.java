package vendingmachine.dto;

import java.util.Map;
import vendingmachine.constant.Coin;

public class ChangeDto {
    private final Map<Coin, Integer> change;

    private ChangeDto(Map<Coin, Integer> change) {
        this.change = change;
    }

    public static ChangeDto createChangeDto(Map<Coin, Integer> change) {
        return new ChangeDto(change);
    }

    public Map<Coin, Integer> getChange() {
        return change;
    }
}

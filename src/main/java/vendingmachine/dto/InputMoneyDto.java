package vendingmachine.dto;

public class InputMoneyDto {
    private final int amount;

    private InputMoneyDto(int amount) {
        this.amount = amount;
    }

    public static InputMoneyDto createInputMoneyDto(int amount) {
        return new InputMoneyDto(amount);
    }

    public int getAmount() {
        return amount;
    }
}

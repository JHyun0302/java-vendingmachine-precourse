package vendingmachine.exception;

public class ErrorInputException extends IllegalArgumentException {
    public enum ErrorMessage {
        INVALID_COIN_AMOUNT_ERROR("Invalid coin amount: "),
        VENDING_MACHINE_MONEY_CANNOT_BE_NULL_OR_EMPTY("[ERROR] 자판기 보유 금액은 빈 값이거나 null 일 수 없습니다. 다시 입력해 주세요."),
        VENDING_MACHINE_MONEY_IS_NOT_INTEGER("[ERROR] 자판기 보유 금액은 정수여야 합니다. 다시 입력해 주세요."),
        VENDING_MACHINE_MONEY_IS_MORE_THAN_TEN("[ERROR] 자판기 보유 금액은 10이상의 자연수여야 합니다. 다시 입력해 주세요."),
        VENDING_MACHINE_MONEY_CAN_NOT_DIVIDED_BY_THOUSAND("[ERROR] 자판기 보유 금액은 10원 단위여야 합니다. 다시 입력해 주세요."),

        INPUT_PRICE_CANNOT_BE_NULL_OR_EMPTY("[ERROR] 투입 금액은 빈 값이거나 null 일 수 없습니다. 다시 입력해 주세요."),
        INPUT_PRICE_IS_NOT_INTEGER("[ERROR] 투입 금액은 정수여야 합니다. 다시 입력해 주세요."),
        INPUT_PRICE_IS_MORE_THAN_ONE("[ERROR] 투입 금액은 1이상의 자연수여야 합니다. 다시 입력해 주세요."),
        INPUT_PRICE_CAN_NOT_DIVIDED_BY_THOUSAND("[ERROR] 투입 금액은 1,000원 단위여야 합니다. 다시 입력해 주세요."),


        PRODUCT_CANNOT_BE_NULL_OR_EMPTY("[ERROR] 상품, 가격, 수량은 빈 값이거나 null 일 수 없습니다. 다시 입력해 주세요."),
        PRODUCT_ERROR_INPUT("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요. 예시 : [콜라,1500,20];[사이다,1000,10]"),
        PRODUCT_ERROR_TYPE("[ERROR] 상품명은 문자이고 가격과 수량은 정수만 입력 가능합니다. 다시 입력해 주세요."),

        INVALID_SELL_PRICE_ERROR("[ERROR] 상품 가격은 100원부터 시작, 10원 단위로 나눠 떨어져야 합니다. 다시 입력해 주세요."),
        INVALID_QUANTITY_ERROR("[ERROR] 상품 수량은 1개 이상이여야 합니다. 다시 입력해 주세요."),


        BUY_PRODUCT_CANNOT_BE_NULL_OR_EMPTY("[ERROR] 구입 상품은 빈 값이거나 null 일 수 없습니다. 다시 입력해 주세요."),
        BUY_PRODUCT_MUST_BE_IN_VENDING_MACHINE("[ERROR] 구입 상품은 자판기에 있는 상품이여야 합니다. 다시 입력해 주세요."),
        BUY_PRODUCT_IS_CHEAPER_THAN_PRODUCT("[ERROR] 구입 상품은 남은 금액으로 구입 불가능합니다. 다시 입력해 주세요."),
        BUY_PRODUCT_IS_SOLD_OUT("[ERROR] 재고가 없어 구매 불가능합니다. 다시 입력해 주세요.");

        ErrorMessage(final String message) {
            this.message = message;
        }

        private final String message;

        public String getMessage() {
            return message;
        }
    }

    public ErrorInputException(ErrorMessage message) {
        super(message.getMessage());
    }
}

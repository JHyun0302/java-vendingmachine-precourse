package vendingmachine.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.VENDING_MACHINE_MONEY_CANNOT_BE_NULL_OR_EMPTY;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.VENDING_MACHINE_MONEY_IS_MORE_THAN_TEN;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.VENDING_MACHINE_MONEY_IS_NOT_INTEGER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VendingMachineMoneyValidationTest {
    private final VendingMachineMoneyValidation vendingMachineMoneyValidation;

    VendingMachineMoneyValidationTest() {
        vendingMachineMoneyValidation = new VendingMachineMoneyValidation();
    }

    @DisplayName("자판기 보유 금액이 빈 값이거나 null 인 경우 예외가 발생한다.")
    @Test
    void isNullOrEmptyTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> vendingMachineMoneyValidation.isNullOrEmpty(null));

        //then
        assertTrue(exception.getMessage().contains(VENDING_MACHINE_MONEY_CANNOT_BE_NULL_OR_EMPTY.getMessage()));
    }

    @DisplayName("자판기 보유 금액이 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void isIntegerTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> vendingMachineMoneyValidation.isInteger("Not Integer"));

        //then
        assertTrue(exception.getMessage().contains(VENDING_MACHINE_MONEY_IS_NOT_INTEGER.getMessage()));
    }

    @DisplayName("자판기 보유 금액이 10원 이상이 아닌 경우 예외가 발생한다.")
    @Test
    void isMoreThanOneTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> vendingMachineMoneyValidation.isMoreThanTen(9));

        //then
        assertTrue(exception.getMessage().contains(VENDING_MACHINE_MONEY_IS_MORE_THAN_TEN.getMessage()));
    }
}
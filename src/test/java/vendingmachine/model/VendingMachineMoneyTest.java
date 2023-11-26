package vendingmachine.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.VENDING_MACHINE_MONEY_CAN_NOT_DIVIDED_BY_THOUSAND;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VendingMachineMoneyTest {
    @DisplayName("자판기 보유 금액 입력 시 10원 단위로 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {405})
    void VendingMachineMoneyTest(int price) {
        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> VendingMachineMoney.createVendingMachineMoney(price));

        //then
        assertTrue(exception.getMessage().contains(VENDING_MACHINE_MONEY_CAN_NOT_DIVIDED_BY_THOUSAND.getMessage()));
    }
}
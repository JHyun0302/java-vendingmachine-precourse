package vendingmachine.view.input;

import java.util.List;
import vendingmachine.validation.BuyProductValidation;
import vendingmachine.validation.InputPriceValidation;
import vendingmachine.validation.ProductValidation;
import vendingmachine.validation.VendingMachineMoneyValidation;
import vendingmachine.view.input.template.InputValidatorTemplate;

public class InputView {
    private final VendingMachineMoneyValidation vendingMachineMoneyValidation;
    private final InputPriceValidation inputPriceValidation;
    private final ProductValidation productValidation;
    private final BuyProductValidation buyProductValidation;
    private final InputValidatorTemplate template;

    public InputView(VendingMachineMoneyValidation vendingMachineMoneyValidation,
                     InputPriceValidation inputPriceValidation, ProductValidation productValidation,
                     BuyProductValidation buyProductValidation, InputValidatorTemplate template) {
        this.vendingMachineMoneyValidation = vendingMachineMoneyValidation;
        this.inputPriceValidation = inputPriceValidation;
        this.productValidation = productValidation;
        this.buyProductValidation = buyProductValidation;
        this.template = template;
    }

    public int inputVendingMachineMoney() {
        return template.InputWithValidation(this::vendingMachineMoneyValidate);
    }

    public List<String[]> inputVendingMachineProduct() {
        return template.InputWithValidation(this::productValidate);
    }

    public int inputPrice() {
        return template.InputWithValidation(this::inputPriceValidate);
    }

    public String inputBuyProduct() {
        return template.InputWithValidation(this::inputBuyProductValidate);
    }

    private int vendingMachineMoneyValidate(String input) {
        vendingMachineMoneyValidation.isNullOrEmpty(input);
        int inputPrice = vendingMachineMoneyValidation.isInteger(input);
        return vendingMachineMoneyValidation.isMoreThanTen(inputPrice);
    }

    private List<String[]> productValidate(String input) {
        productValidation.isNullOrEmpty(input);
        String[] elements = productValidation.checkErrorInput(input);
        return productValidation.validateElements(elements);
    }

    private int inputPriceValidate(String input) {
        inputPriceValidation.isNullOrEmpty(input);
        int inputPrice = inputPriceValidation.isInteger(input);
        return inputPriceValidation.isMoreThanOne(inputPrice);
    }

    private String inputBuyProductValidate(String input) {
        return buyProductValidation.isNullOrEmpty(input);
    }
}

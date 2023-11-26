package vendingmachine.validation;

import static vendingmachine.constant.ConstantNumber.One;
import static vendingmachine.constant.ConstantNumber.Three;
import static vendingmachine.constant.ConstantNumber.Zero;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.PRODUCT_CANNOT_BE_NULL_OR_EMPTY;
import static vendingmachine.exception.ErrorInputException.ErrorMessage.PRODUCT_ERROR_INPUT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vendingmachine.exception.ErrorInputException;

/**
 * 구매 상품 검증
 */
public class ProductValidation {

    public void isNullOrEmpty(String input) {
        if (input == null || input.length() == Zero) {
            throw new ErrorInputException(PRODUCT_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    public String[] checkErrorInput(String input) {
        String[] elements = input.split(";");
        Arrays.stream(elements)
                .forEach(element -> validateElement(element));
        return elements;
    }

    public List<String[]> validateElements(String[] elements) {
        List<String[]> result = new ArrayList<>();
        for (String element : elements) {
            String[] product = element.substring(One, element.length() - One).split(",");
            result.add(product);
        }
        return result;
    }

    private void validateElement(String element) {
        if (element.charAt(Zero) != '[' || element.charAt(element.length() - One) != ']') {
            throw new ErrorInputException(PRODUCT_ERROR_INPUT);
        }
        String[] product = element.substring(One, element.length() - One).split(",");
        validateSubElements(product);
    }

    private void validateSubElements(String[] product) {
        if (product.length != Three) {
            throw new ErrorInputException(PRODUCT_ERROR_INPUT);
        }
        if (!startsWithKorean(product[Zero])) {
            throw new ErrorInputException(PRODUCT_ERROR_INPUT);
        }
    }

    private boolean startsWithKorean(String s) {
        Pattern pattern = Pattern.compile("^[가-힣]");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}

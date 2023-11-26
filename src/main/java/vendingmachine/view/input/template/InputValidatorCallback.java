package vendingmachine.view.input.template;

public interface InputValidatorCallback<T> {
    T validate(String input);
}

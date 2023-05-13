package lambdafunctions;

import interfaces.CustomLambdaSupplier;

public class CustomLambdaPhoneCarrier <T> implements CustomLambdaSupplier<T> {
    private final T value;

    public CustomLambdaPhoneCarrier(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }

}

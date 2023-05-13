package lambdafunctions;
import interfaces.CustomLambdaPredicate;

public class CustomLambdaPhoneOrigin<T> implements CustomLambdaPredicate<T> {
    private final T origin;

    public CustomLambdaPhoneOrigin(T origin){
        this.origin = origin;
    }

    @Override
    public boolean test(T t){
        return origin.equals(t);
    }
}

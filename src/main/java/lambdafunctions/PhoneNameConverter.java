package lambdafunctions;

// Want to use this FUNCTION lambda function to convert phone brands into phone models
import phones.*;


import java.util.function.Function;

public class PhoneNameConverter implements Function<Phone, String> {

    @Override
    public String apply(Phone phone) {
        return phone.getName();
    }
}
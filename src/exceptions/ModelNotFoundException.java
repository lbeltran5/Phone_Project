package exceptions;

public class ModelNotFoundException extends Throwable{
    public ModelNotFoundException(String message){
        super(message);
    }
}

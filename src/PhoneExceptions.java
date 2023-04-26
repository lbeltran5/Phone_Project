//The PhoneException class serves as a base class for all phone-related exceptions,
// and each of the more specific exceptions extends this base class.
// This allows you to catch all phone-related
// exceptions in one catch block by catching PhoneException.

public class PhoneExceptions {
    public static class PhoneException extends Exception {
        public PhoneException(String message) {
            super(message);
        }
    }
    public static class InvalidSelectionException extends PhoneException {
        public InvalidSelectionException(String message) {
            super(message);
        }
    }

    public static class ModelNotFoundException extends PhoneException {
        public ModelNotFoundException(String message) {
            super(message);
        }
    }

    public static class OSNotFoundException extends PhoneException {
        public OSNotFoundException(String message) {
            super(message);
        }
    }

    public static class InvalidBrandException extends PhoneException {
        public InvalidBrandException(String message){
            super(message);
        }
    }

    public static class InvalidInputException extends PhoneException{
        public InvalidInputException(String message){
            super(message);
        }
    }

}

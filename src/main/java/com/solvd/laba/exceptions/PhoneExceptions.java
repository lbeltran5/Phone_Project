package com.solvd.laba.exceptions;

//The PhoneException class serves as a base class for all phone-related exceptions,
// and each of the more specific exceptions extends this base class.
// This allows you to catch all phone-related
// exceptions in one catch block by catching PhoneException.

public class PhoneExceptions extends Exception{
    public PhoneExceptions(String message) {
        super(message);
    }
}
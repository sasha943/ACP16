package com.company.exceptions;

/**
 * Created by ubuntu on 21.01.17.
 */
public class NoProductFoundException extends Exception {

    public NoProductFoundException() {
        super("No com.company.model found");
    }
}

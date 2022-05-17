package de.langomatisch.hetzner.internal.exception;

public class HetznerNotAuthorizedException extends Exception {

    public HetznerNotAuthorizedException(String message) {
        super(message);
    }

}

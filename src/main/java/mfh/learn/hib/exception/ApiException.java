package mfh.learn.hib.exception;

public class ApiException extends RuntimeException {
    public ApiException(String exceptionMessage) {
        super(exceptionMessage);
    }
}

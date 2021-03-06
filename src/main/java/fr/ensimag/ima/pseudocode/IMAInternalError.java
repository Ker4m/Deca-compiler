package fr.ensimag.ima.pseudocode;

/**
 * Internal error related to IMA code. Should never happen.
 *
 * @author Ensimag
 * @date 01/01/2022
 */
public class IMAInternalError extends RuntimeException {
    private static final long serialVersionUID = 3929345355905773360L;

    public IMAInternalError(String message, Throwable cause) {
        super(message, cause);
    }

    public IMAInternalError(String message) {
        super(message);
    }

}

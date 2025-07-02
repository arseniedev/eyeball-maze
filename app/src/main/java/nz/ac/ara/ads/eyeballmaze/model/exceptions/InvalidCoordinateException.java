package nz.ac.ara.ads.eyeballmaze.model.exceptions;

import java.io.Serial;

public class InvalidCoordinateException extends Exception {

    public InvalidCoordinateException() {
        // TODO Auto-generated constructor stub
    }

    public InvalidCoordinateException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

//    public InvalidCoordinateException(Throwable cause) {
//        super(cause);
//        // TODO Auto-generated constructor stub
//    }

    public InvalidCoordinateException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    @Serial
    private static final long serialVersionUID = -2623659967979838393L;
}
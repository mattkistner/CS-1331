/**
 * An unchecked exception checking for Invalid Course.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class InvalidCourseException extends RuntimeException {
    /**
     * A constructor taking in an error message.
     * @param msg String representing error message.
     */
    public InvalidCourseException(String msg) {
        super(msg);
    }

    /**
     * A default constructor that takes in no parameters and has a default error message.
     */
    public InvalidCourseException() {
        super("Invalid course type!");
    }
}
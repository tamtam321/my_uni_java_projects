public class MyException extends Exception {
    public MyException() {
        super("Something went wrong! This is an exception!");
    }

    public MyException(String message) {
        super(message);
    }
}
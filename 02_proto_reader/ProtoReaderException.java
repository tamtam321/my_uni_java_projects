public class ProtoReaderException extends Exception {
    public ProtoReaderException() {
        super("A bemenet nem felel meg a regexnek! ");
    }

    public ProtoReaderException(String message) {
        super(message);
    }
}

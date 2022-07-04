public class My_Exception extends Exception {
    /**
     * My_Exception konstruktor
     * Ezzel dobok hiba üzeneteket
     *
     * @param message   hiba üzenet
     * */
    public My_Exception(String message) {
        super(message);
    }
}

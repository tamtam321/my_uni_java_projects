public class MyException extends Exception {
    /**
     * Paraméternélküli konstruktor.
     * Terminálon megadott helytelen bemenet esetén dobunk exceptiont.
     * */
    MyException() {
        super("Helytelen bemenet!");
    }
}

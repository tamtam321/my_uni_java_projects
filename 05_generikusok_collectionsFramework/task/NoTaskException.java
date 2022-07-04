public class NoTaskException extends Exception {
    /**
     * Paraméternélküli konstruktor.
     * Üres napi listából nem tudunk taskot megcsinálni, exceptiont dobunk.
     * */
    NoTaskException() {
        super("Az adott naphoz a lista ures, nincs task amit csinalhatsz!");
    }

    /**
     * Konstruktor.
     * Itt megadhatunk egyedi exception üzenetet.
     *
     * @param message   Hibaüzenet
     * */
    NoTaskException(String message) {
        super(message);
    }

    /**
     * Konstruktor.
     * A hibaüzenet mellé megadom, hogy melyik napi listánál fordul elő a hiba.
     *
     * @param d     Day enum -> Az üzenetben megadom, hogy melyik napi listánál fordult elő a hiba.
     * */
    NoTaskException(Day d) {
        super(d + " lista ures, nincs tobb task, amit meg tudnal csinalni!");
    }
}

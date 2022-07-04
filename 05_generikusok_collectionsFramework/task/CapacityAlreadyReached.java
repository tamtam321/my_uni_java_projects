public class CapacityAlreadyReached extends Exception {
    /**
     * Paraméternélküli konstruktor.
     * Az adott napi task listába max 10db task lehet, ha annál több akkor exceptiont dobunk.
     * */
    CapacityAlreadyReached() {
        super("Az adott naphoz a lista tele van, max 10 task lehet benne!");
    }

    /**
     * Konstruktor.
     * Itt megadhatunk egyedi exception üzenetet.
     *
     * @param message   Hibaüzenet
     * */
    CapacityAlreadyReached(String message) {
        super(message);
    }

    /**
     * Konstruktor.
     * A hibaüzenet mellé megadom, hogy melyik napi listánál fordul elő a hiba.
     *
     * @param d     Day enum -> Az üzenetben megadom, hogy melyik napi listánál fordult elő a hiba.
     * */
    CapacityAlreadyReached(Day d) {
        super(d + " lista tele van, max 10 taskot tud eltarolni!");
    }
}

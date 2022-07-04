/**
 * @author nguta
 * */

public abstract class Currency implements BuyableCurrency, SellableCurrency {
    protected double curr_exchange_rate;    // árfolyam
    protected double curr_money;    // külföldi pénznemből mennyi van nekünk
    protected static double huf_money = 0;  // HUF amink van, itt nulla de van egy metódus ahol meg tudjuk adni
    protected String currency_name;     // A pénznem neve
    protected double selling_limit;     // Max limit amennyit még eladhatunk

    /**
     * Paraméter nélküli konstruktor esetben
     * mindent nullára állítok és Undefined-ra.
     * */
    Currency() {
        curr_exchange_rate = 0;
        curr_money = 0;
        currency_name = "Undefined";
        selling_limit = 0;
    }

    /**
     * Konstruktor
     * Beállítom, hogy mennyi pénzünk legyen az adott külföldi pénznemből.
     *
     * @param _cm   külföldi pénznem értéke
     * */
    Currency(double _cm) {
        curr_money = _cm;
    }

    /**
     * Beállítom a HUF értéket, ami nálunk lesz.
     *
     * @param set_huf   HUF érték amennyink lesz
     * */
    public void setHuf(double set_huf) {
        huf_money = set_huf;
    }

    /**
     * Kiíratom, hogy mennyi HUF érték van nálunk.
     *
     * */
    public void printHuf() {
        System.out.println("HUF: " + huf_money);
    }

    /**
     * Kiíratom, hogy mennyi pénz van nálunk a bizonyos pénznemből.
     *
     * */
    public void printCurrency() {
        System.out.println(currency_name+ ": " + curr_money);
    }

    /**
     * Kiíratom, hogy a bizonyos külföldi pénzből és a HUFból mennyink van.
     *
     * @return Stringgel tér vissza, ami a fentebb dolgot írja le.
     * */
    @Override
    public String toString() {
        return ("HUF: " + huf_money + "\n" + currency_name + ": " + curr_money + "\n");
    }

    /**
     * Kiíratom, hogy miből mit váltottunk és hogy mennyi lett a váltás eredménye.
     *
     * @param changed_val   átváltott érték
     * @param from  honnan váltottunk
     * @param to    mibe váltottunk
     * */
    public void printChangedVal(double changed_val, String from, String to) {
        System.out.println(from + " -> " + to + ": " + changed_val);
    }

    /**
     * Be lehet állítani, hogy a bizonyos külföldi pénznemből mennyink legyen.
     *
     * @param currency_val  Amennyi küldöldi pénzünk legyen az adott pénznemből.
     * */
    public void setCurrencyVal(double currency_val) {
        curr_money = currency_val;
    }

    /**
     * Itt váltunk át HUF-ból egy külföldi pénznembe.
     * Amennyi HUF-ot szeretnénk váltani az ne legyen kevesebb mint az árfolyam, különben hibát dob.
     * Amennyi HUF-ot szeretnénk váltani az ne legyen több mint amennyink van, különben hibát dob.
     *
     * @param _huf  Mennyi HUF-ból szeretnénk váltani.
     * @return double értékkel térek vissza, ami megmondja hogy mennyi az átváltás eredményének az értéke.
     * */
    @Override
    public double buyCurrency(double _huf) {
        try {
            if (_huf >= curr_exchange_rate) {  // Az átváltandó érték az legalább annyi legyen mint az árfolyam, ha
                                              // kevesebb, akkor nem történik váltás és jelzem.
                if (huf_money >= _huf) {  // Legalább annyi pénzünk legyen, mint amennyit váltani szeretnénk.
                    double exchanged_money = (_huf / curr_exchange_rate);   // átváltott érték

                    huf_money -= _huf;  // frissítjük a HUF értéket

                    curr_money += exchanged_money;  // frissítjük a külföldi pénznem értéket

                    // kiíratom hogy miből mennyit és mibe váltottunk és mennyi az átváltott érték
                    System.out.println(_huf +" HUF -> " + currency_name + ": " + exchanged_money);

                    return exchanged_money;
                }
                else {
                    throw new My_Exception("HUF egyenleg: " + huf_money + ", ami kevesebb, mint amit valtani szeretnenk!");
                }
            }
            else {
                throw new My_Exception("Keves a HUF osszeg amit szeretnel " + currency_name + " penznembe valtani. " +
                                       "Legalább " + curr_exchange_rate + "Ft-ot kene megadni!");
            }
        }
        catch (My_Exception ex) {
            System.err.println(ex.getMessage());
            return 0;   // Ha exception van akkor 0-val térek vissza és nem történik kereskedelem.
        }
    }

    /**
     * Itt váltunk át a külföldi pénznemből HUF-ba.
     * Az átváltandó érték az ne legyen nagyobb mint a max limit amit eladhatunk.
     * Az átváltandó érték az legyen 0-nál nagyobb és ne legyen több, mint amink van.
     *
     * @param other_currency    Külföldi pénznem értéke, amit át szeretnénk váltani
     * @return double value értékkel tér vissza, ami megmondja az átváltás eredményét.
     * */
    @Override
    public double sellCurrency(double other_currency) {
        try {
            if (other_currency <= selling_limit) {  // Átváltandó érték nem haladhatja meg az eladási limitet!
                if (other_currency > 0) {   // Átváltandó érték legyen nagyobb, mint nulla.
                    if (curr_money >= other_currency) {  // A pénznemből legalább annyi legyen, mint amennyit váltani szeretnénk.
                        double exchanged2Huf = (other_currency * curr_exchange_rate);   // átváltás utáni érték

                        huf_money += exchanged2Huf; // HUF frissítése

                        curr_money -= other_currency;   // Külföldi pénznem frissítése

                        // Kiíratom, hogy miből mennyit és mibe váltok és hogy mennyi az átváltás eredménye
                        System.out.println(other_currency + " " + currency_name + " -> HUF" +
                                ": " + exchanged2Huf);

                        return exchanged2Huf;
                    }
                    else {
                        throw new My_Exception("Szamla egyenlege: " + curr_money + " " + currency_name + " " +
                                               " kevesebb, mint amennyit szeretnel eladni!");
                    }
                }
                else {
                    throw new My_Exception(currency_name + " -> HUF az atvaltas, ahol amibol valtunk annak az" +
                                           " erteke nem negyobb, mint nulla, ezert nem valosithato meg az atvaltas!");
                }
            }
            else {
                throw new My_Exception("Tul halattad az eladasi limitet! " + selling_limit +
                                        " " + currency_name + " arfolyamnal tobbet nem tudsz eladni.");
            }
        }
        catch (My_Exception ex) {
            System.err.println(ex.getMessage());
            return 0;   // Ha van exception, akkor 0-val térek vissza jelezve hogy nem történt kereskedelem.
        }
    }
}
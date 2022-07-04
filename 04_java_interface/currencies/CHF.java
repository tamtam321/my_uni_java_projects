/**
 * @author nguta
 * */

public class CHF extends Currency {
    boolean enabled;    // Ezzel engedélyezem a kereskedést a pénznemmel

    /**
     * Paraméternélküli konstruktor
     * Megadom az árfolyamot, pénznem nevét, a max eladási limitet és
     * alapból 0 értékű a külföldi pénznem, ami nálunk van.
     * enable alapból true, vagyis alapból engedjük a kereskedést, de ezt meg tudjuk változtatni utólag.
     * */
    public CHF() {
        super.curr_exchange_rate = 326.67;
        super.currency_name = "CHF";
        super.selling_limit = 909.17;
        super.curr_money = 0;
        enabled = true;
    }

    /**
     * Konstruktor
     * Megadom, hogy mennyi külföldi pénzünk legyen az adott pénznemből.
     * Többi érték meg ugyanaz, mint fentebb.
     *
     * @param _cm   Mennyi legyen a külföldi pénznem értéke
     * */
    public CHF(double _cm) {
        super(_cm);
        super.curr_exchange_rate = 326.67;
        super.currency_name = "CHF";
        super.selling_limit = 909.17;
        enabled = true;
    }

    /**
     * Getter fv
     * Lekérdezi az enable értékét-
     *
     * @return enable értéke
     * */
    public boolean getEnable() {
        return enabled;
    }

    /**
     * Ezzel kapcsolom át az enable-t
     *
     * */
    public void trigger() {
        enabled = !enabled;
    }

    /**
     * Kiíratom, hogy most milyen állapotban van a kereskedés.
     *
     * */
    public void printEnable() {
        if (enabled) {
            System.out.println("A svajci frank mozgasa engedelyezve van.");
        }
        else {
            System.out.println("A svajci frank mozgasa nincs engedelyezve!");
        }
    }

    /**
     * Itt váltunk át HUF-ból egy külföldi pénznembe.
     * Ha engedélyezve van a kereskedés akkor kereskedünk, különben nem és jelezzük.
     * Amennyi HUF-ot szeretnénk váltani az ne legyen kevesebb mint az árfolyam, különben hibát dob.
     * Amennyi HUF-ot szeretnénk váltani az ne legyen több mint amennyink van, különben hibát dob.
     *
     * @param _huf  HUF összeg, amit szeretnénk váltani a péznembe.
     * @return double értékkel térek vissza, ami megmondja hogy mennyi az átváltás eredményének az értéke.
     * */
    @Override
    public double buyCurrency(double _huf) {
        try {
            if (enabled) {  // Ha true, akkor lehet kereskedni, különben nem és jelezzük.
                if (_huf >= super.curr_exchange_rate) { // Az átváltandó érték az legalább annyi legyen mint az árfolyam, ha
                                                        // kevesebb, akkor nem történik váltás és jelzem.
                    if (huf_money >= _huf) {    // Legalább annyi pénzünk legyen, mint amennyit váltani szeretnénk.
                        double exchanged_money = (_huf / super.curr_exchange_rate);  // Innentől ugyanaz, mint a Currency osztályban

                        huf_money -= _huf;

                        super.curr_money += exchanged_money;

                        System.out.println(_huf +" HUF -> " + super.currency_name + ": " + exchanged_money);

                        return exchanged_money;
                    }
                    else {
                        throw new My_Exception("HUF egyenleg: " + huf_money + ", ami kevesebb, mint amit valtani szeretnenk!");
                    }
                }
                else {
                    throw new My_Exception("Keves a HUF osszeg amit szeretnel " + super.currency_name + " penznembe valtani. " +
                            "Legalább " + super.curr_exchange_rate + "Ft-ot kene megadni!");
                }
            }
            else {
                throw new My_Exception("Nincs engedelyezve a kereskedes!");
            }
        }
        catch (My_Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

    /**
     * Itt váltunk át a külföldi pénznemből HUF-ba.
     * Ha engedélyezve van a kereskedés akkor kereskedünk, különben nem és jelezzük.
     * Az átváltandó érték az ne legyen nagyobb mint a max limit amit eladhatunk.
     * Az átváltandó érték az legyen 0-nál nagyobb és ne legyen több, mint amink van.
     *
     * @param other_currency    Külföldi pénznem értéke, amit át szeretnénk váltani
     * @return double value értékkel tér vissza, ami megmondja az átváltás eredményét.
     * */
    @Override
    public double sellCurrency(double other_currency) {
        try {
            if (enabled && other_currency <= super.selling_limit) {  // Ha enabled igaz, akkor mehet a kereskedelem, különben nem és jelzem.
                                                                    // Ha lehet kereskedni, akkor az átváltandó érték ne legyen több, mint
                                                                    // az eladási limit!
                if (other_currency > 0) {   // Innentől ugyanaz mint a Currency osztályban
                    if (super.curr_money >= other_currency) {
                        double exchanged2Huf = (other_currency * super.curr_exchange_rate);

                        huf_money += exchanged2Huf;

                        super.curr_money -= other_currency;

                        System.out.println(other_currency + " " + super.currency_name + " -> HUF" +
                                ": " + exchanged2Huf);

                        return exchanged2Huf;
                    }
                    else {
                        throw new My_Exception("Szamla egyenlege: " + super.curr_money + " " + super.currency_name + " " +
                                " kevesebb, mint amennyit szeretnel eladni!");
                    }
                }
                else {
                    throw new My_Exception(super.currency_name + " -> HUF az atvaltas, ahol amibol valtunk annak az" +
                            " erteke nem negyobb, mint nulla, ezert nem valosithato meg az atvaltas!");
                }
            }
            else {
                throw new My_Exception("Nincs engedelyezve a kereskedes vagy tul haladtad az eladasi limitet, ami " +
                          super.selling_limit + " CHF-nel nem lehet több!");
            }
        }
        catch (My_Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
/**
 * @author nguta
 * */

public class EUR extends Currency {

    /**
     * Paraméternélküli konstruktor
     * Megadom az árfolyamot, pénznem nevét, a max eladási limitet és
     * alapból 0 értékű a külföldi pénznem, ami nálunk van.
     * */
    public EUR() {
        super.curr_exchange_rate = 360.01;
        super.currency_name = "EUR";
        super.selling_limit = 824.98;
        super.curr_money = 0;
    }

    /**
     * Konstruktor
     * Megadom, hogy mennyi külföldi pénzünk legyen az adott pénznemből.
     * Többi érték meg ugyanaz, mint fentebb.
     *
     * @param _cm   Mennyi legyen a külföldi pénznem értéke
     * */
    public EUR(double _cm) {
        super(_cm);
        super.curr_exchange_rate = 360.01;
        super.currency_name = "EUR";
        super.selling_limit = 824.98;
    }
}
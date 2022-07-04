/**
 * @author nguta
 * */

public class USD extends Currency {

    /**
     * Paraméternélküli konstruktor
     * Megadom az árfolyamot, pénznem nevét, a max eladási limitet és
     * alapból 0 értékű a külföldi pénznem, ami nálunk van.
     * */
    public USD() {
        super.curr_exchange_rate = 297.00;
        super.currency_name = "USD";
        super.selling_limit = 1000;
        super.curr_money = 0;
    }

    /**
     * Konstruktor
     * Megadom, hogy mennyi külföldi pénzünk legyen az adott pénznemből.
     * Többi érték meg ugyanaz, mint fentebb.
     *
     * @param _cm   Mennyi legyen a külföldi pénznem értéke
     * */
    public USD(double _cm) {
        super(_cm);
        super.curr_exchange_rate = 297.00;
        super.currency_name = "USD";
        super.selling_limit = 1000;
    }
}
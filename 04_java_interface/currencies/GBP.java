/**
 * @author nguta
 * */

public class GBP extends Currency {

    /**
     * Paraméternélküli konstruktor
     * Megadom az árfolyamot, pénznem nevét és
     * alapból 0 értékű a külföldi pénznem, ami nálunk van.
     * */
    public GBP() {
        super.curr_exchange_rate = 419.12;
        super.currency_name = "GBP";
        super.curr_money = 0;
    }

    /**
     * Konstruktor
     * Megadom, hogy mennyi külföldi pénzünk legyen az adott pénznemből.
     * Többi érték meg ugyanaz, mint fentebb.
     *
     * @param _cm   Mennyi legyen a külföldi pénznem értéke
     * */
    public GBP(double _cm) {
        super(_cm);
        super.curr_exchange_rate = 419.12;
        super.currency_name = "GBP";
    }

    /**
     * Metódus ahol fontból átváltunk HUF-ba, DE
     * ezt nem fogjuk engedni, mert nem akarunk eladni.
     *
     * @param other_currency    Mennyi fontot váltsunk át, de ennek sok jelentőssége nincsen
     * @return  Az átváltás értéke, mindig nulla mert nem akarunk eladni!
     * */
    @Override
    public double sellCurrency(double other_currency) {
        try {
            throw new My_Exception("Angol fontbol nem akarunk eladni!");
        }
        catch (My_Exception ex) {
            System.err.println(ex.getMessage());
        }

        return 0;
    }
}
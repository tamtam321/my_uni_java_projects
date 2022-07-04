/**
 * @author nguta
 * */

public class JPY extends Currency {

    /**
     * Paraméternélküli konstruktor
     * Megadom az árfolyamot, pénznem nevét, a max eladási limitet és
     * alapból 0 értékű a külföldi pénznem, ami nálunk van.
     * */
    public JPY() {
        super.curr_exchange_rate = 2800.75;
        super.currency_name = "JPY";
        super.selling_limit = 106043.02;
        super.curr_money = 0;
    }

    /**
     * Konstruktor
     * Megadom, hogy mennyi külföldi pénzünk legyen az adott pénznemből.
     * Többi érték meg ugyanaz, mint fentebb.
     *
     * @param _cm   Mennyi legyen a külföldi pénznem értéke
     * */
    public JPY(double _cm) {
        super(_cm);
        super.curr_exchange_rate = 2800.75;
        super.currency_name = "JPY";
        super.selling_limit = 106043.02;
    }

    /**
     * Ezzel a metódussal váltok HUF-ból külföldi pénznembe, DE
     * nem akarunk yent venni!
     *
     * @param _huf  Mennyi HUF-ból szeretnénk váltani, ennek itt nincs jelentőssége
     * @return mindig nullával térünk vissza, mert nem akarunk yent venni!
     * */
    @Override
    public double buyCurrency(double _huf) {
        System.err.println("Japan yen-bol nem akarunk venni!");

        return 0;
    }

    /**
     * Itt váltunk át a külföldi pénznemből HUF-ba.
     * Az átváltandó érték az ne legyen nagyobb mint a max limit amit eladhatunk.
     * Az átváltandó érték az legyen 1000-nél nagyobb és ne legyen több, mint amink van.
     *
     * @param other_currency    Külföldi pénznem értéke, amit át szeretnénk váltani
     * @return double value értékkel tér vissza, ami megmondja az átváltás eredményét.
     * */
    @Override
    public double sellCurrency(double other_currency) {
        try {
            if (other_currency <= super.selling_limit) {
                if (other_currency >= 1000) {   // Átváltandó érték legyen legalább 1000.
                    if (super.curr_money >= other_currency) {
                        double jpy = (other_currency / 1000);   // megnézem hányszor van meg benne az 1000
                        double jpy_modulo = other_currency % 1000;  // a maradékot nem vonom le a pénzünkből, csak az ezres értéket
                        double exchanged2Huf = (jpy * super.curr_exchange_rate);    // átváltás érték

                        huf_money += exchanged2Huf; // Huf frissítése

                        super.curr_money -= (other_currency - jpy_modulo);  // Pénznem frissítése

                        // Kiíratom, hogy miből mennyit és mibe váltok és hogy mennyi az átváltás eredménye
                        System.out.println(other_currency + " " + currency_name + " -> HUF" +
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
                            " erteke nem nagyobb vagy egyenlo, mint 1000, ezert nem valosithato meg az atvaltas!");
                }
            }
            else {
                throw new My_Exception("Tul halattad az eladasi limitet! " + super.selling_limit +
                        " JPY-nel tobbet nem tudsz eladni.");
            }
        }
        catch (My_Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
import java.util.Stack;

/**
 * @author nguta
 * */

public class Sor {
    private  Stack<Integer> inStack, outStack;   // inStack verembe teszi a sor az InThread által pusholt elemet.
                                                 // outStack veremből poppol a sor, amikor az OutThread poppolni akar a sorból.

    /**
     * Konstruktor
     * Inicializálom a két stacket.
     * */
    public Sor() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * A sor itt teszi bele az InThread által pusholt elemet az inStack-be.
     * inStack-re szinkronizálok, mert ez mindkét Thread-nél használva lesz.
     * Ha mindkét Thread őrült módon szól a sor-nak, hogy nyúljon hozzá, akkor a kiíratás sorrendje változhat, amit nem szeretnénk.
     *
     * @param numb  int típus amit beleteszek a inStack-be.
     * */
    public void Push(int numb) {
        synchronized (inStack) {
            inStack.push(numb);
        }
    }

    /**
     * Ez hajtja végre a sor-ból való poppolást.
     * Az outStackre szinkronizálok, mondjuk nem feltétlen szükséges, mert csak az OutThread fogja mondani a sor-nak hogy nyúljon hozzá, de ott hagytam.
     * inStackre is szinkronizálok itt, mert OutThread poppolásnál kérni fogja a sort, hogy nyúljon hozzá, amikor a sorban az outStack üres, akkor az
     * inStack-ből átviszek elemet. Ha üres sorból próbálunk poppolni akkor dobok exception-t, jelzem üzenettel meg visszaadok -1 értéket ezzel is jelezve.
     *
     * @return  Poppolt int értékkel térek vissza.
     * */
    public int Pop() {
        synchronized (outStack) {
            try {
                if(!this.isEmpty()) {
                    if (outStack.isEmpty()) {
                        synchronized (inStack) {
                            while (!inStack.isEmpty()) {
                                outStack.push(inStack.pop());
                            }
                        }
                    }
                }
                else {
                    throw new Exception("Ures listabol akarsz poppolni!");
                }
            }
            catch (Exception ex) {
                System.err.println(ex.getMessage());
                return -1;
            }

            return outStack.pop();
        }
    }

    /**
     * Itt vizsgálom meg, hogy üres-e a sor.
     * Ha mindkét belső verem üres, akkor a sor üres.
     *
     * @return boolean értékkel térek vissza, ha mindkét belső verem üres akkor true, vagyis üres, különben nem.
     * */
    public boolean isEmpty() {
        /**
         * Itt rossz, mert szinkronizálni kell az isEmptyt az outStackre először mert a Popnál is úgy van és akkor ott kéne
         * először vizsgálni hogy üres-e. Azért kell mindkettőre szinkronizálni, mert van az a szitu, hogy mondjuk a egyik szál
         * csekkolja hogy üres-e, inStack üres, de outStack nem és még csak az inStacket csekkolta le
         * aztán egy második szál közben kivesz a sorból és az outStack is üres lesz de közben
         * inStackbe kerül egy elem. Az első szál folytatja a vizsgálatot, már lecsekkolta az instacket és akkor üresnek találta, ami most már
         * nem az és folytatja az outStackkel ami akkor még nem volt üres, de most igen és az első szál üresnek ítéli a sort miközben az inStackbe
         * került közben elem, mert egy másik szál elintézte és tulajdonképpen a sor nem üres.
         *
         * Megoldás: egymásba ágyazott synchronized blokk, ahol outStackre szinkronizálok először kívül aztán az inStackre.
         * Ezt majd ki kéne javítani!!!!
         * */
        return (inStack.isEmpty() && outStack.isEmpty());
    }
}

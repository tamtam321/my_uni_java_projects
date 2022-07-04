import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * @author nguta
 * */

/**
 * OutThread poppol a sorból és írja ki az elemeit konzolra és fájlba.
 * */
public class OutThread implements Runnable {
    private volatile Sor sor;    // Közös sor erőforrás.
    private volatile LinkedList<Boolean> running;   // Itt tárolom el az osztott mutable listát.
    private volatile PrintWriter pw;    // Fájlba íráshoz fog kelleni.

    /**
     * Konstruktor
     * Átadom a this.sor-nak a közös sor forrást.
     * Átadom a megosztott Boolean-t tároló listát a this.running-ba.
     * Inicializálom a pw-t.
     *
     * @param sor       Sor típus, amit átadok this.sor-nak.
     * @param running   LinkedList<Boolean> típus, amit átadok this.running-nak.
     * */
    public OutThread(Sor sor, LinkedList<Boolean> running) throws FileNotFoundException {
        this.sor = sor;
        this.running = running;
        pw = new PrintWriter("sorOutput.txt");   // A sorOutput.txt fájlba fogok írni
    }

    /**
     * Runnable interface metódusa.
     * A while ciklus addig fut, amíg InThread nem rakta a sorba az összes nála lévő elemeket vagy
     * a sor nem üres. Poppolom a sorból az elemeket és kiíraom konzolra és fájlba.
     * */
    @Override
    public void run() {
        while (running.get(0) || !sor.isEmpty()) {
            int val = sor.Pop();
            System.out.println(val);
            pw.println(val);

            try {
                Thread.sleep(1000);     // Mindegyik iterálásnál késleltetem egy másodperccel. A OutThread hagyj időt az InThread-nek,
            }                                //  hogy magához vegye az inStacket és rakjon bele elemet, amit ki tud venni és nem fog üres sorból kiveni!
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        pw.close();     // Ha OutThread befejezte, akkor bezárom a printWritert és megjelenítem az értékeket a fájlban.
        System.out.println("Itt a vege!");  // Jelzem konzolon, hogy vége van.
    }
}

import java.util.LinkedList;

/**
 * @author nguta
 * */

/**
 * InThread pushol a sorba elemet.
 * */
public class InThread implements Runnable {
    private volatile Sor sor;   // Közös sor erőforrás.
    private volatile LinkedList<Boolean> running;   // Itt tárolom el az osztott mutable listát.
    private volatile LinkedList<Integer> numb_list; // Lista ami 10db Intet tárol, amit a sorba fogok belerakni.

    /**
     * Konstruktor
     * Átadom közös sor forrást és a megosztott LinkedList<Boolean> listát.
     * Inicializálom a numb_list listát és feltöltöm 10db inttel 0-90-ig 10-es lépésszámmal.
     *
     * @param sor       Sor típus -> közös sor forrás.
     * @param running   LinkedList<Boolean> típus -> megosztott lista bool értékkel.
     * */
    public InThread(Sor sor, LinkedList<Boolean> running) {
        this.sor = sor;
        this.running = running;
        numb_list = new LinkedList<>();

        for(int i = 0; i < 10; ++i) {
            numb_list.add(i*10);
        }
    }

    /**
     * Runnable interface run() metódus implementálása.
     * Amíg InThread-nek van eleme, amit bele tud tenni a sorba addig pörög.
     * Ha sor üres és van eleme az InThread-nek akkor pushol a sorba. Ha végzett, akkor
     * beállítja a megosztott listában a boolean értéket false-ra, jelezve hogy InThread végzett és ha
     * OutThread is végzett akkor vége az egésznek.
     * */
    @Override
    public void run() {
        while (running.get(0)) {
            if (sor.isEmpty()) {
                if (!numb_list.isEmpty()) {
                    sor.Push(numb_list.removeFirst());
                }
            }

            if (numb_list.isEmpty()) {
                running.set(0, false);
            }
        }
    }
}

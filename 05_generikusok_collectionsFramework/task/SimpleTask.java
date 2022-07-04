/**
 * @author nguta
 * */

final class SimpleTask extends AbstractTask {

    /**
     * Paraméternélküli konstruktor.
     *
     * Megadom az alapértéket a name és a priority-nak a szülő konstruktorával.
     * */
    SimpleTask() {
        super();
    }

    /**
     * Konstruktor
     *
     * Paraméterrel értéket adok a szülő konstruktor segítségével a name és a priotity-nak.
     *
     * @param _name         Task neve
     * @param _priority     Task prioritása
     * */
    SimpleTask(String _name, int _priority) {
        super(_name, _priority);
    }
}

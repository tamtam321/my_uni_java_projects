/**
 * @author nguta
 * */

abstract class AbstractTask implements Task {
    private String name;    // Task neve
    private int priority;   // Task prioritása

    /**
     * Paraméternélküli konstruktor.
     *
     * Megadom az alapértéket a name és a priority-nak.
     * */
    AbstractTask() {
        name = "nincs definialva";
        priority = 0;
    }

    /**
     * Konstruktor.
     *
     * Paraméterrel adok értéket a változóknak.
     *
     * @param _name         Task neve
     * @param _priority     Task prioritása
     * */
    AbstractTask(String _name, int _priority) {
        name = _name;
        priority = _priority;
    }

    /**
     * Getter
     *
     * Ezzel elérem az AbstractTask osztály private name változóját
     *
     * @return private name változóval térek vissza
     * */
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * Ezzel tudok értéket adni a private name változónak.
     *
     * @param _name     Task neve
     * */
    public void setName(String _name) {
        name = _name;
    }

    /**
     * Setter
     *
     * Ezzel tudok értéket adni a private priority változónak.
     *
     * @param _prior   Task prioritása
     * */
    public void setPriority(int _prior) {
        priority = _prior;
    }

    /**
     * Konzolra kiíratom a task prioritását és nevét.
     * */
    @Override
    public void doTask() {
        System.out.println("Prioritas: " + priority + ", Task neve: " + name);
    }

    /**
     * Ezzel elérem a private priority változót.
     *
     * @return  A private priority változóval térek vissza.
     * */
    @Override
    public int getPriority() {
        return priority;
    }

    /**
     * Két AbstractTask típust hasonlít össze.
     *
     * @param  at   AbstractTask típusú példány
     * @return  Integer értékkel tér vissza, ami megmondja, hogy a nálunk lévő példány prioritása nagyobb-e vagy kisebb
     *          vagy egyenlő, mint a paraméterül kapttnak.
     * */
    @Override
    public int compareTo(Task at) {
        return Integer.compare(at.getPriority(), this.getPriority());
    }
}

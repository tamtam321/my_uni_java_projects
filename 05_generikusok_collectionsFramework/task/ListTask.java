import java.util.Collections;
import java.util.LinkedList;

/**
 * @author nguta
 * */

final class ListTask <T extends Task> extends AbstractTask {
    private LinkedList<T> list_task;    // Láncolt lista, ami SimpleTask típusokat fog tárolni.

    /**
     * Paraméternélküli konstruktor.
     *
     * Létrehozom az üres listát.
     * */
    ListTask() {
        list_task = new LinkedList<>();
    }

    /**
     * Kiíratom a lista tartalmát.
     * */
    @Override
    public void doTask() {
        for (T t : list_task) {
            t.doTask();
        }
    }

    /**
     * Lista feladatainak átlag prioritásának egészre kerekített értékével tér vissza.
     *
     * @return Lista feladatainak átlag prioritásának egészre kerekített értékével tér vissza.
     * */
    @Override
    public int getPriority() {
        int sum_prior = 0;
        int avg_prior;
        int count = list_task.size();

        for (T t : list_task) {
            sum_prior += t.getPriority();
        }

        avg_prior = (sum_prior / count);

        return avg_prior;
    }

    /**
     * Hozzáadok a listához taskot.
     *
     * @param st    SimpleTask amit hozzáadok a listához.
     * */
    public void add2List(T st) {
        list_task.add(st);
    }

    /**
     * A listát prioritás szerint sorbarendezi.
     * A nagyobb szám az a nagyobb prioritás.
     * */
    public void sortListPrior() {
        Collections.sort(list_task);
    }

    /**
     * Getter
     *
     * @return Visszatérek a lista hosszával.
     * */
    public int getListSize() {
        return list_task.size();
    }

    /**
     * A legelső elem mindig a jelenlegi legnagyobb prioritású task a listában.
     * Azt megjelenítem, jelezve hogy melyiket végzem el és aztán törlöm, mert már el van végezve.
     * */
    public void doPriorTask() {
        list_task.get(0).doTask();
        list_task.removeFirst();
    }

    /**
     * Megadom, hogy a lista üres-e.
     *
     * @return Boolean értékkel térek vissza, ha igaz akkor üres a lista, különben nem.
     * */
    public boolean isEmpty() {
        return list_task.isEmpty();
    }
}

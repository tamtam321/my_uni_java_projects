import java.util.Comparator;

/**
 * @author nguta
 * */

public interface Task extends Comparable<Task> {
    /**
     * SimpleTask példány esetén kiírja a task prioritását és nevét.
     * ListTask esetén kiírja a SimpleTaskokat tartalmazó lista tartalmát.
     * */
    void doTask();

    /**
     * SimpleTask esetén visszaadja a prioritás értékét.
     * ListTask esetén a lista feladatainak átlag prioritásának egészre kerekített értékével tér vissza.
     * */
    int getPriority();
}

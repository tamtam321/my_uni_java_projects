import task.*;

/**
 * @author nguta
 * */

public class Main {

    public static void main(String[] args) {
        /**
         * Létrehozok egy TaskManager példányt és meghívom a terminalUsing metódusát.
         * Terminálon felsorolt parancsokkal lehet majd hozzáadni a listához taskokat a bizonyos napokhoz vagy
         * teljesíteni a legnagyobb prioritású taskot a megadott napon és azzal eltávolítani a listából.
         * Ki lehet iratni a listát.
         *
         * "exit" paranccsal lehet leállítani a folyamatot.
         * */
        TaskManager tm1 = new TaskManager();
        tm1.terminalUsing();


        /**
         * ListTask getPriority teszt
         * */
        /*System.out.println("___________Teszt 1: ListTask getPriority teszt___________");
        TaskManager tm2 = new TaskManager();
        tm2.addTask(Day.KEDD, "task1", 5);
        tm2.addTask(Day.KEDD, "task2", 2);
        tm2.addTask(Day.KEDD, "task3", 1);
        tm2.addTask(Day.KEDD, "task4", 7);
        tm2.addTask(Day.KEDD, "task5", 5);
        tm2.printDayList();
        tm2.printAvgPrior(Day.KEDD);*/
    }
}

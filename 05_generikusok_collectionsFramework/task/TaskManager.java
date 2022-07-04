import java.util.HashMap;
import java.util.*;

public class TaskManager {
    private HashMap<Day, ListTask<SimpleTask>> my_task;   // HashMap, ahol a napok a kulcsok és a hozzájuk tartozó lista az érték.

    /**
     * Paraméternélküli konstruktor.
     *
     * Létrehozom az üres mappet.
     * */
    public TaskManager() {
        my_task = new HashMap<>();
    }

    /**
     * Hozzáadok taskot a bizonyos nap listájához.
     *
     * Létrehzom a SimpleTaskot, megnézem hogy van-e már olyan napi lista, ha van akkor annak
     * a listájába beszúrom a taskot, ha még nincs akkor létrehozom a napot és ahhoz a listát és
     * aztán szúrom be. Ha a napi lista meghaladja a 10db taskot, akkor exceptiont dobok.
     *
     * @param day           Nap (Day)
     * @param task_name     Task neve (String)
     * @param task_prior    Task prioritás értéke (int)
     * @exception CapacityAlreadyReached   Ha a napi lista meghaladja a 10db taskot, akkor exceptiont dobok.
     * */
    public void addTask (Day day, String task_name, int task_prior) {
        SimpleTask new_task = new SimpleTask(task_name, task_prior);

        if (my_task.containsKey(day)) {
            try {
                if (my_task.get(day).getListSize() < 10) {
                    my_task.get(day).add2List(new_task);
                    my_task.get(day).sortListPrior();
                    System.out.println("Hozzaadva\n");
                }
                else {
                    throw new CapacityAlreadyReached(day);
                }
            }
            catch (CapacityAlreadyReached ex) {
                System.err.println(ex.getMessage());
            }
        }
        else {
            ListTask<SimpleTask> new_lt = new ListTask<>();
            new_lt.add2List(new_task);
            my_task.put(day, new_lt);
            System.out.println("Hozzaadva\n");
        }
    }

    /**
     * Az adott napi lista legnagyobb prioritású taskját törlöm, mert elvégeztük a feladatot.
     * Megnézem, hogy létezik-e a napi lista, ha nem akkor dobok exceptiont, ha igen akkor abból törlöm
     * a legnagyobb prioritású elemet. Ha üres listából törlünk, akkor is dobunk exceptiont.
     *
     * @param d     Nap (Day)
     * @exception NoTaskException   Üres listából törlünk, akkor dobunk exceptiont.
     * */
    public void completeTask(Day d) {
        try {
            if (my_task.containsKey(d)) {
                if (my_task.get(d).isEmpty()) {
                    throw new NoTaskException(d);
                }
                else {
                    System.out.println("Az alabbi task lett elvegezve: ");
                    System.out.print(d + " -> ");
                    my_task.get(d).doPriorTask();
                }
            }
            else {
                throw new NoTaskException("Az adott napon " + d + " nincsen semmilyen task!");
            }
        }
        catch (NoTaskException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Kiíratom a map tartalmát.
     * */
    public void printDayList() {
        my_task.forEach((key, value) -> {
            System.out.println(key);
            value.doTask();
            System.out.println();
        });
    }

    /**
     * Ezzel a segédfüggvénnyel azonosítom be a terminálon kapott napnak a nevét és
     * adom meg a megfelelő Day típusértéket.
     *
     * @param day   String, ami egy napra utal.
     * @return Day típussal térek vissza.
     * */
    private Day checkDayInput(String day) {
        Day task_day = null;

        if (day.toLowerCase().trim().equals("hetfo")) {
            task_day = Day.HETFO;
        }
        else if (day.toLowerCase().trim().equals("kedd")) {
            task_day = Day.KEDD;
        }
        else if (day.toLowerCase().trim().equals("szerda")) {
            task_day = Day.SZERDA;
        }
        else if (day.toLowerCase().trim().equals("csutortok")) {
            task_day = Day.CSUTORTOK;
        }
        else if (day.toLowerCase().trim().equals("pentek")) {
            task_day = Day.PENTEK;
        }
        else if (day.toLowerCase().trim().equals("szombat")) {
            task_day = Day.SZOMBAT;
        }
        else if (day.toLowerCase().trim().equals("vasarnap")) {
            task_day = Day.VASARNAP;
        }

        return task_day;
    }

    /**
     * Ezzel a metódussal kezelem a terminálon érkező parancsokat, amivel tudunk a napi listához beszúrni, törölni és kiíratni a map tartalmát.
     * "exit" paranccsal lehet befejezni a folyamatot.
     *
     * 4 parancs van:
     *  - add: task hozzaadasa
     *  - do: legnagyobb prioritasu task elvegzese a bizonyos napon
     *  - print: lista tartalmanak kiiratasa
     *  - exit: kilepes
     *
     *  Bizonyos parancsok után meg is adom a válasz opciókat.
     *  Helytelen, rossz input esetén a program nem csinál semmit vagy exceptiont dob.
     *
     * @exception MyException   Rossz bemenet esetén exceptiont dobunk.
     * */
    public void terminalUsing() {

        System.out.println("Parancsok: \n[ add: task hozzaadasa ]; [ do: legnagyobb prioritasu task elvegzese a bizonyos napon ]; " +
                "[ print: lista tartalmanak kiiratasa ]; [ exit: kilepes ]");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        String day;
        Day task_day;

        while(!command.equals("exit")) {    // exit parancsra kilép

            switch (command.toLowerCase().trim()) {
                case "add" -> {     // add parancs során végrehajtandó lépések
                    System.out.println("Add meg, melyik napra szeretnel taskot adni: \n" +
                            "opciok: hetfo, kedd, szerda, csutortok, pentek, szombat, vasarnap");

                    day = sc.nextLine();

                    try {

                        task_day = checkDayInput(day);

                        if (task_day == null) {  // Ha nem érvényes napot adok meg akkor dobok exceptiont!
                            throw new MyException();
                        }
                        else {
                            System.out.println("Add meg a task nevet: ");
                            String task_name = sc.nextLine();

                            System.out.println("Add meg a task prioritasat: ");
                            int task_prior = sc.nextInt();

                            addTask(task_day, task_name, task_prior);
                        }
                    }
                    catch (MyException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                case "do" -> {  // do parancs során végrehajtandó lépések
                    System.out.println("Melyik napon szeretned elvegezni a legnagyobb prioritasu taskot: \n"
                                       + "opciok: hetfo, kedd, szerda, csutortok, pentek, szombat, vasarnap");

                    day = sc.nextLine();

                    try {
                        task_day = checkDayInput(day);

                        if (task_day == null) {   // Ha nem érvényes napot adok meg akkor dobok exceptiont!
                            throw new MyException();
                        }
                        else {
                            completeTask(task_day);
                        }

                        System.out.println();
                    }
                    catch (MyException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                case "print" -> {   // print parancs során kiíratom a map tartalmát
                    System.out.println("A jelenlegi lista tartalma: ");
                    printDayList();
                    System.out.println();
                }
            }

            System.out.println("Parancsok: \n[ add: task hozzaadasa ]; [ do: legnagyobb prioritasu task elvegzese a bizonyos napon ]; " +
                    "[ print: lista tartalmanak kiiratasa ]; [ exit: kilepes ]");

            sc = new Scanner(System.in);
            command = sc.nextLine();
        }

        sc.close();
    }

    /**
     * Kiíratom az adott napi lista feladatainak átlag prioritásának egészre kerekített értékét.
     *
     * @param d   Nap
     * */
    public void printAvgPrior(Day d) {
        System.out.println(d + " lista feladatainak átlag prioritásának egészre kerekített értéke: " + my_task.get(d).getPriority());
    }
}

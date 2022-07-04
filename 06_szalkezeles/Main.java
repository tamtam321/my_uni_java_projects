import mySor.*;

import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * @author nguta
 * */

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // LinkedList az mutable, ez osztott változó, ahol majd az InThread jelzi majd, hogy
        // ő befejezte a dolgát és akkor az OutThread is befejezheti, hamár a sor üres.
        LinkedList<Boolean> boolList = new LinkedList<>();
        boolList.add(true);    // Igaz értéket tárol, mert az elején az InThread futni fog.
        Sor sor = new Sor();    // Ez lesz a közös sor forrás, amit a két Thread-nek átadunk és piszkálni fogják.
        Thread tIn = new Thread(new InThread(sor, boolList));
        Thread tOut = new Thread(new OutThread(sor, boolList));

        tIn.start();
        tOut.start();
    }
}

/**
 * @author Nguyen Thien Tam
 * */

public abstract class Gerinces {
    protected int numb_vertebra;   // csigolyák száma
    protected int numb_leg;   // lábak száma
    protected String moving; // haladás módja

    /**
     * Pataméter néküli konstruktor
     * Ha nincs paraméter megadva, akkor az int értékeket nullára
     * a Stringet meg "Semmilyen"-re lesz beállítva.
     * */
    public Gerinces() {
        numb_vertebra = 0;
        numb_leg = 0;
        moving = "Semmilyen";
    }

    /**
     * Konstruktor
     * A példánynak beállítja a csigolya és láb értékét
     *
     * @param _vertebra     csigolya szám
     * @param _leg          lábak száma
     * */
    public Gerinces(int _vertebra, int _leg) {
        numb_vertebra = _vertebra;
        numb_leg = _leg;
    }

    /**
     * Konstruktor
     * Beállítja a példánynak a csigolyáját.
     *
     * @param _vertebra     csigolyák száma
     * */
    public Gerinces(int _vertebra) {
        numb_vertebra = _vertebra;
    }

    /**
     * Kiíratom csigolya számát.
     * */
    public void printVertebra() {
        System.out.println("Csigolyak szama: " + numb_vertebra);
    }

    /**
     * Kiíratom lábak számát.
     * */
    public void printLeg() {
        System.out.println("Labak szama: " + numb_leg);
    }

    /**
     * Kiíratom haladás módját.
     * */
    public void halad() {
        System.out.println("Haladasuk modja: " + moving);
    }

    /**
     * Kiíratom a példány adatait.
     * */
    @Override
    public String toString() {
        return ("Csigolyak szama: " + numb_vertebra + "\nLabak szama: " + numb_leg +
                "\nHaladas modnja: " + moving);
    }

    /**
     * Setter, ami beállítja a csigolyák számát
     *
     * @param _vertebra     A beállítandó csigolyák száma
     * */
    public void setVertebra(int _vertebra) {
        numb_vertebra = _vertebra;
    }

    /**
     * Setter, ami beállítja a lábak számát
     *
     * @param _leg     A beállítandó lábak száma
     * */
    public void setLeg(int _leg) {
        numb_leg = _leg;
    }

    /**
     * Setter, ami beállítja a mozgást
     *
     * @param _moving     A beállítandó mozgás
     * */
    public void setMoving(String _moving) {
        moving = _moving;
    }
}

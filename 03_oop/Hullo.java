/**
 * @author Nguyen Thien Tam
 * */

public class Hullo extends Gerinces {
    final private String name;    // név
    private boolean is_poisonous;   // ezzel jelzem hogy mérgező-e a hüllő

    /**
     * Paraméternélküli konstruktor
     * Ha nem adunk nevet akkor nem lesz neve.
     * A hüllő alapból siklik.
     * Ebben az esetben nem mérgező.
     */
    public Hullo() {
        name = "nincs neve";
        is_poisonous = false;
        super.moving = "csendesen siklik";
    }

    /**
     * Konstruktor
     * Paraméterekkel beállítom a hüllő attribútumait.
     *
     * @param _vertebra     Csigolya száma
     * @param _leg          lábak száma
     * @param _name         név
     * @param _poisonous    mérgező-e
     * */
    public Hullo (int _vertebra, int _leg, String _name, boolean _poisonous) {
        super(_vertebra, _leg);
        super.moving = "csendesen siklik";
        name = _name;
        is_poisonous = _poisonous;
    }

    /**
     * Kiíratom, hogy mérgező-e hüllő.
     * */
    public void isPoisonous() {
        if (is_poisonous) {
            System.out.println("Ez a fajta hullo mergezo.");
        }
        else {
            System.out.println("Ez a fajta hullo nem mergezo.");
        }
    }

    /**
     * Kiíratom a példány adatait.
     * */
    @Override
    public String toString() {
        return ("Csigolyak szama: " + super.numb_vertebra + "\nLabak szama: " + this.numb_leg +
                "\nHaladas modja: " + super.moving + "\nMergezo: " + is_poisonous +
                "\nNev: " + name);
    }

    /**
     * Beállítom, hogy mérgező-e vagy sem.
     *
     * @param _poisonous      Beállítandó boolean érték, hogy mérgező-e vagy sem.
     * */
    public void setPoisonous(boolean _poisonous) {
        is_poisonous = _poisonous;
    }
}

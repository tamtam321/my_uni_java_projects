/**
 * @author Nguyen Thien Tam
 * */

public class Keteltu extends Gerinces {
    final private String name;  // név
    private boolean is_french_food; // Ezzel jelzem, hogy a franciák megeszik-e ezt a kétéltűt.

    /**
     * Paraméternélküli konstruktor
     * Ha nem adunk meg nevet, akkor nem lesz neve.
     * A kétéltű alapból úszik és megy.
     * Ebben az esetben nem francia étel.
     */
    public Keteltu() {
        name = "nincs neve";
        is_french_food = false;
        super.moving = "uszik es megy";
    }

    /**
     * Konstruktor
     * Paraméterekkel beállítom a hüllő attribútumait.
     *
     * @param _vertebra     Csigolya száma
     * @param _leg          lábak száma
     * @param _name         név
     * @param _iff          francia étel-e
     * */
    public Keteltu(int _vertebra, int _leg, String _name, boolean _iff) {
        super(_vertebra, _leg);
        super.moving = "uszik es megy";
        name = _name;
        is_french_food = _iff;
    }

    /**
     * Kiíratom, hogy a franciák megeszik-e vagy nem.
     * */
    public void isFrenchFood() {
        if (is_french_food) {
            System.out.println("Ezt a fajta keteltut a franciak megeszik.");
        }
        else {
            System.out.println("Ezt a fajta keteltut a franciak nem eszik meg.");
        }
    }

    /**
     * Kiíratom a példány adatait.
     * */
    @Override
    public String toString() {
        return ("Csigolyak szama: " + super.numb_vertebra + "\nLabak szama: " + this.numb_leg +
                "\nHaladas modja: " + super.moving + "\nMegeszik-e a franciak: " + is_french_food +
                "\nNev: " + name);
    }

    /**
     * Beállítom, hogy francia étel-e vagy sem.
     *
     * @param _iff      Beállítandó boolean érték, hogy francia étel-e vagy sem.
     * */
    public void setIsFrenchFood(boolean _iff) {
        is_french_food = _iff;
    }
}

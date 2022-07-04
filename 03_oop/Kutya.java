/**
 * @author Nguyen Thien Tam
 * */

public final class Kutya extends Emlos {
    private boolean is_bark;    // Ezzel jelzem, hogy ugat-e a kutya.

    /**
     * Paraméternélküli konstruktor
     * Ha nem adunk meg nevet, akkor nem lesz neki.
     * A kutyák alapból farokcsóválva szaladnak.
     * Ebben az esetben nem ugat.
     * */
    public Kutya() {
        super("nincs neve");
        super.moving = "farokcsovalva szalad";
        is_bark = false;
    }

    /**
     * Konstruktor
     * Paraméterekkel beállítom a hüllő attribútumait.
     *
     * @param _vertebra     Csigolya száma
     * @param _leg          lábak száma
     * @param _name         név
     * @param _teeth        fogak száma
     * @param _bark         ugat-e
     * */
    public Kutya(int _vertebra, int _leg, String _name, int _teeth, boolean _bark) {
        super(_vertebra, _leg, _name, _teeth);
        super.moving = "farokcsovalva szalad";
        is_bark = _bark;
    }

    /**
     * Kiíratom, hogy harap-e a kutya.
     * */
    public void isBite() {
        if (is_bark) {
            System.out.println("A kutya harap!");
        }
        else {
            System.out.println("A kutya nem harap!");
        }
    }

    /**
     * Kiíratom a példány adatait.
     * */
    @Override
    public String toString() {
        return ("Csigolyak szama: " + super.numb_vertebra + "\nLabak szama: " + this.numb_leg +
                "\nHaladas modja: " + super.moving + "\nFogak szama: " + numb_teeth +
                "\nUgat: " + is_bark + "\nNev: " + name);
    }

    /**
     * Beállítom, hogy ugat-e a kutya.
     *
     * @param _bark      Beállítandó boolean, hogy ugat-e a kutya vagy nem.
     * */
    public void setBark(boolean _bark) {
        is_bark = _bark;
    }
}

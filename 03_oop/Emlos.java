/**
 * @author Nguyen Thien Tam
 * */

public class Emlos extends Gerinces{
    final protected String name;  // név
    protected int numb_teeth;   // fogak száma

    /**
     * Paraméternélküli konstruktor
     * Ha nem adunk meg nevet, akkor nem lesz neki.
     * Emlős alapból csak mászik.
     * Ebben az esetben a fogak száma nulla;
     * */
    public Emlos () {
        name = "nincs neve";
        numb_teeth = 0;
        super.moving = "maszik";
    }

    /**
     * Konstruktor
     * Paraméterekkel beállítom a hüllő attribútumait.
     *
     * @param _vertebra     Csigolya száma
     * @param _leg          lábak száma
     * @param _name         név
     * @param _teeth        fogak száma
     * */
    public Emlos (int _vertebra, int _leg, String _name, int _teeth) {
        super(_vertebra, _leg);
        super.moving = "maszik";
        name = _name;
        numb_teeth = _teeth;
    }

    /**
     * Konstruktor
     * Beállítom alaphelyzetben nevét.
     *
     * @param _name         név
     * */
    public Emlos (String _name) {
        name = _name;
    }

    /**
     * Kiíratom a fogak számát.
     * */
    public void printTeeth() {
        System.out.println("Fogak szama: " + numb_teeth);
    }

    /**
     * Kiíratom a példány adatait.
     * */
    @Override
    public String toString() {
        return ("Csigolyak szama: " + super.numb_vertebra + "\nLabak szama: " + this.numb_leg +
                "\nHaladas modja: " + super.moving + "\nFogak szama: " + numb_teeth +
                "\nNev: " + name);
    }

    /**
     * Beállítom, a fogak számát.
     *
     * @param _teeth      Beállítandó fogak száma.
     * */
    public void setTeeth(int _teeth) {
        numb_teeth = _teeth;
    }
}

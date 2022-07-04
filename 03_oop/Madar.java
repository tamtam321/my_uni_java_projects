/**
 * @author Nguyen Thien Tam
 * */

public class Madar extends Gerinces {
    final private String name;    // név
    private int numb_wing;  // szárnyak száma

    /**
     * Paraméternélküli konstruktor
     * Ha nincs neve, akkor nem lesz beállítva.
     * A madár alapból repül.
     * Ebben az esetben a szárnyak száma nulla.
     * */
    public Madar() {
        name = "nincs neve";
        numb_wing = 0;
        super.moving = "repul";
    }

    /**
     * Konstruktor
     * Paraméterekkel beállítom a hüllő attribútumait.
     *
     * @param _vertebra     Csigolya száma
     * @param _leg          lábak száma
     * @param _name         név
     * @param _wing         szárnyak száma
     * */
    public Madar(int _vertebra, int _leg, String _name, int _wing) {
        super(_vertebra, _leg);
        super.moving = "repul";
        name = _name;
        numb_wing = _wing;
    }

    /**
     * Kiíratom a szárnyak számát.
     * */
    public void printWing() {
        System.out.println("Szarnyak szama: " + numb_wing);
    }

    /**
     * Kiíratom a példány adatait.
     * */
    @Override
    public String toString() {
        return ("Csigolyak szama: " + super.numb_vertebra + "\nLabak szama: " + this.numb_leg +
                "\nHaladas modja: " + super.moving + "\nSzarnyak szama: " + numb_wing +
                "\nNev: " + name);
    }

    /**
     * Beállítom, a szárnyak számát.
     *
     * @param _wing      Beállítandó szárnyak száma.
     * */
    public void setWing(int _wing) {
        numb_wing = _wing;
    }
}

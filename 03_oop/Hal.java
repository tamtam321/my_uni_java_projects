/**
 * @author Nguyen Thien Tam
 * */

public class Hal extends Gerinces {
    final private String name;
    private int numb_fin;   // uszonyok száma
    final static private int numb_leg = 0;  // halnak nincs lába, ezért az összesnek beállítom.

    /**
     * Paraméternélküli Konstruktor
     * Ha nem adunk nevet akkor névtelen lesz a példány.
     * A hal csak úszni tud, ezért azt alapból beállítom.
     * Ebben az esetben nulla lesz az uszonyok száma.
     * */
    public Hal() {
        name = "nincs neve";
        numb_fin = 0;
        super.moving = "uszik";
    }

    /**
     * Konstruktor
     * A paraméterekkel beállítom a példány attríbútumait.
     *
     * @param _vertebra     csigolyák száma
     * @param _name         név
     * @param _fin          uszonyok száma
     * */
    public Hal(int _vertebra, String _name, int _fin) {
        super(_vertebra);
        super.moving = "uszik";
        name = _name;
        numb_fin = _fin;
    }

    /**
     * Kiíratom az uszony számát.
     * */
    public void printFin() {
        System.out.println("Uszonyok szama: " + numb_fin);
    }

    /**
     * Kiíratom a példány adatait.
     * */
    @Override
    public String toString() {
        return ("Csigolyak szama: " + super.numb_vertebra + "\nLabak szama: " + numb_leg +
                "\nHaladas modja: " + super.moving + "\nUszonyok szama: " + numb_fin +
                "\nNev: " + name);
    }

    /**
     * Beállítom az uszonyok számát.
     *
     * @param _fin      Beállítandó uszonyok száma.
     * */
    public void setFin(int _fin) {
        numb_fin = _fin;
    }
}

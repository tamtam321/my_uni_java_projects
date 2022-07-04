/**
 * @author Nguyen Thien Tam
 * */

public final class Macska extends Emlos {
    private String fur_color;   // macska szőrének a színe

    /**
     * Paraméternélküli konstruktor
     * Ha nem adunk meg nevet, akkor nem lesz neki.
     * A macskák alapból sündörögnek.
     * Ebben a helyzetben a szőr színe fekete.
     * */
    public Macska() {
        super("nincs neve");
        super.moving = "sundorog";
        fur_color = "fekete";
    }

    /**
     * Konstruktor
     * Paraméterekkel beállítom a hüllő attribútumait.
     *
     * @param _vertebra     Csigolya száma
     * @param _leg          lábak száma
     * @param _name         név
     * @param _teeth        fogak száma
     * @param _fur          milyen színű szőre a macskának
     * */
    public Macska(int _vertebra, int _leg, String _name, int _teeth, String _fur) {
        super(_vertebra, _leg, _name, _teeth);
        super.moving = "sundorog";
        fur_color = _fur;
    }

    /**
     * Kiíratom milyen a macska szőrének a színe.
     * */
    public void printFurColor() {
        System.out.println("Macska szorenek a szine: " + fur_color);
    }

    /**
     * Kiíratom a példány adatait.
     * */
    @Override
    public String toString() {
        return ("Csigolyak szama: " + super.numb_vertebra + "\nLabak szama: " + this.numb_leg +
                "\nHaladas modja: " + super.moving + "\nFogak szama: " + numb_teeth +
                "\nSzor szine: " + fur_color + "\nNev: " + name);
    }

    /**
     * Beállítom, a szőr színét.
     *
     * @param _fur_color      Beállítandó szőr színe.
     * */
    public void setFurColor(String _fur_color) {
        fur_color = _fur_color;
    }
}

public class Main {
    public static void main(String[] args) {
        // Teszt 1: Példányok függvény teszt
        System.out.println("___________Teszt 1: Példányok függvény teszt____________\n");

        Hal hal1 = new Hal(100, "harcsa", 4);
        hal1.printFin();
        hal1.printVertebra();
        hal1.printLeg();
        hal1.halad();
        System.out.println(hal1);
        System.out.println();

        Keteltu keteltu1 = new Keteltu(200, 4, "beka", true);
        keteltu1.isFrenchFood();
        keteltu1.printVertebra();
        keteltu1.printLeg();
        keteltu1.halad();
        System.out.println(keteltu1);
        System.out.println();

        Hullo hullo1 = new Hullo(300, 4, "szalamandra", false);
        hullo1.isPoisonous();
        hullo1.printVertebra();
        hullo1.printLeg();
        hullo1.halad();
        System.out.println(hullo1);
        System.out.println();

        Madar madar1 = new Madar(400, 2, "golya", 2);
        madar1.printWing();
        madar1.printVertebra();
        madar1.printLeg();
        madar1.halad();
        System.out.println(madar1);
        System.out.println();

        Emlos emlos1 = new Emlos(500, 4, "medve", 50);
        emlos1.printTeeth();
        emlos1.printVertebra();
        emlos1.printLeg();
        emlos1.halad();
        System.out.println(emlos1);
        System.out.println();

        Kutya kutya1 = new Kutya(600, 4, "labrador", 60, false);
        kutya1.isBite();
        kutya1.printTeeth();
        kutya1.printVertebra();
        kutya1.printLeg();
        kutya1.halad();
        System.out.println(kutya1);
        System.out.println();

        Macska macska1 = new Macska(700, 4, "perzsa", 70, "orange");
        macska1.printFurColor();
        macska1.printTeeth();
        macska1.printVertebra();
        macska1.printLeg();
        macska1.halad();
        System.out.println(macska1);
        System.out.println();

        // Teszt 2:
        System.out.println("___________Teszt2 : hal teszt 1____________\n");

        Gerinces g1 = new Hal();
        System.out.println(g1);

        System.out.println();

        g1.setLeg(12);
        g1.setMoving("Sietve uszik");
        g1.setVertebra(100);
        System.out.println(g1);

        // Teszt 3:
        System.out.println("___________Teszt3 : hullő teszt 1____________\n");

        Gerinces g2 = new Hullo();
        System.out.println(g2);

        System.out.println();

        g2.setLeg(12);
        g2.setMoving("Sietve maszik");
        g2.setVertebra(100);
        System.out.println(g2);

        // Teszt 4:
        System.out.println("___________Teszt4 : hal teszt 2____________\n");

        Hal hal2 = new Hal();
        System.out.println(hal2);

        System.out.println();

        hal2.setLeg(12);
        hal2.setMoving("Nagyon sietve uszik");
        hal2.setVertebra(100);
        hal2.setFin(22);
        System.out.println(hal2);

        // Teszt 4:
        System.out.println("___________Teszt4 : hullő teszt 2____________\n");

        Hullo hullo2 = new Hullo();
        System.out.println(hullo2);

        System.out.println();

        hullo2.setLeg(100);
        hullo2.setMoving("Sietve siklik");
        hullo2.setVertebra(50);
        hullo2.setPoisonous(true);
        System.out.println(hullo2);

        // Teszt 5:
        System.out.println("___________Teszt5 : kétéltű teszt 1____________\n");

        Keteltu keteltu2 = new Keteltu();
        System.out.println(keteltu2);

        System.out.println();

        keteltu2.setLeg(100);
        keteltu2.setMoving("Sietve siklik");
        keteltu2.setVertebra(50);
        keteltu2.setIsFrenchFood(true);
        System.out.println(keteltu2);

        // Teszt 6:
        System.out.println("___________Teszt6 : madar teszt 1____________\n");

        Madar madar2 = new Madar();
        System.out.println(madar2);

        System.out.println();

        madar2.setLeg(100);
        madar2.setMoving("Sietve repul");
        madar2.setVertebra(50);
        madar2.setWing(4);
        System.out.println(madar2);

        // Teszt 7:
        System.out.println("___________Teszt7 : kutya teszt 1____________\n");

        Kutya kutya2 = new Kutya();
        System.out.println(kutya2);

        System.out.println();

        kutya2.setLeg(100);
        kutya2.setMoving("Sietve szalad");
        kutya2.setVertebra(50);
        kutya2.setBark(true);
        kutya2.setTeeth(120);
        System.out.println(kutya2);

        // Teszt 8:
        System.out.println("___________Teszt8 : macska teszt 1____________\n");

        Macska macska2 = new Macska();
        System.out.println(macska2);

        System.out.println();

        macska2.setLeg(100);
        macska2.setMoving("Sietve lopakodik");
        macska2.setVertebra(50);
        macska2.setFurColor("Kek");
        macska2.setTeeth(90);
        System.out.println(macska2);

        // Teszt 9:
        System.out.println("___________Teszt9 : emlos teszt 1____________\n");

        Emlos em1 = new Macska();
        System.out.println(em1);

        System.out.println();

        em1.setLeg(30);
        em1.setMoving("Nagyon lopakodik");
        em1.setVertebra(500);
        em1.setTeeth(55);
        System.out.println(em1);
    }
}

import currencies.*;

public class Main {

    /**
     * A teszteket amire hibát dobok, azokat kikommenteltem.
     * Ha szeretnéd tesztelni, kérlek kommenteld ki, és nézd meg egyenként
     * így jobban nyomon lehet követni a hibát, mint ha egyszerre futna le az összes teszt, amire hibát dobok.
     **/

    public static void main(String[] args) {
        System.out.println("_______________Teszt 1: Külfödi árfolyam (USD) példány tesztelése 1#_________________");
        USD usd1 = new USD(10000);
        usd1.setHuf(100000);

        usd1.printHuf();
        usd1.printCurrency();
        double changed_value = usd1.sellCurrency(500);
        usd1.printChangedVal(changed_value, "USD", "HUF");  // Már a sellCurrency fv-ben van kiíratás,
                                                                    // de van ez a metódus is, hogy legyen használva a visszatérési érték.
        System.out.println(usd1);

        usd1.printHuf();
        usd1.printCurrency();
        changed_value = usd1.buyCurrency(10000);    // Már a buyCurrency fv-ben van kiíratás,
                                                        // de van ez a metódus is, hogy legyen használva a visszatérési érték.
        usd1.printChangedVal(changed_value, "HUF", "USD");
        System.out.println(usd1);

        /*usd1.printHuf();
        usd1.printCurrency();
        changed_value = usd1.sellCurrency(1001);    // 1000 USD-nél nem tudunk többet venni, kapunk jelzést róla
        usd1.printChangedVal(changed_value, "USD", "HUF"); // changed_value 0 lesz
        System.out.println(usd1);   // Nem látunk változást*/

        /*usd1.printHuf();
        usd1.printCurrency();
        changed_value = usd1.sellCurrency(-1500);    // Negatív a bemenet, hibát dob a program
        usd1.printChangedVal(changed_value, "USD", "HUF"); // changed_value 0 lesz
        System.out.println(usd1);   // Nem látunk változást*/

        System.out.println("_______________Teszt 2: Angol font példány tesztelése 1#_________________");
        GBP gbp1 = new GBP(100);

        /*gbp1.printHuf();
        gbp1.printCurrency();
        changed_value = gbp1.sellCurrency(10);    // Nem akarunk eladni fontból, itt kéne kapnunk róla jelzést.
        gbp1.printChangedVal(changed_value, "GBP", "HUF");
        System.out.println(gbp1); // Nem változik semmi, mert nem adunk el fontból.*/

        /*gbp1.printHuf();
        gbp1.printCurrency();
        changed_value = gbp1.buyCurrency(20);   // Túl kevés a huf, hogy lehessen váltani és dobok egy jelzést.
        gbp1.printChangedVal(changed_value, "HUF", "GBP");
        System.out.println(gbp1);   // Nincs változás*/

        gbp1.printHuf();
        gbp1.printCurrency();
        changed_value = gbp1.buyCurrency(1000);
        gbp1.printChangedVal(changed_value, "HUF", "GBP");
        System.out.println(gbp1);

        /*gbp1.printHuf();
        gbp1.printCurrency();
        changed_value = gbp1.buyCurrency(5500);   // Túl kevés a huf, hogy lehessen váltani és dobok egy jelzést.
        gbp1.printChangedVal(changed_value, "HUF", "GBP");
        System.out.println(gbp1);   // Nincs változás*/

        System.out.println("_______________Teszt 3: Euro példány tesztelése 1#_________________");
        EUR eur1 = new EUR(1000);

        eur1.printHuf();
        eur1.printCurrency();
        eur1.sellCurrency(20);
        System.out.println(eur1);

        eur1.printHuf();
        eur1.printCurrency();
        eur1.buyCurrency(2000);
        System.out.println(eur1);

       /* eur1.printHuf();
        eur1.printCurrency();
        eur1.sellCurrency(1000);    // Ennyit nem tudunk eladni, hibát fog dobni.
        System.out.println(eur1);   // Nem lesz változás!*/

        /*eur1.printHuf();
        eur1.printCurrency();
        eur1.sellCurrency(-2000);    // Itt jelezni fog, hogy nem jó a bemenet.
        System.out.println(eur1);   // Nem lesz változás*/

        /*eur1.setCurrencyVal(200);   // Beállítom az EUR egyenleget 200-ra
        eur1.printHuf();
        eur1.printCurrency();
        eur1.sellCurrency(300);    // Többet szeretnénk eladni, mint amink van. Hibát dobunk.
        System.out.println(eur1);   // Nem lesz változás*/

        /*eur1.setHuf(1000);  // HUF értékét 1000-re állítom.
        eur1.printHuf();
        eur1.printCurrency();
        eur1.buyCurrency(2000); // Többet váltok be, mint amennyim van. Hibát dobok!
        System.out.println(eur1);   // Nem lesz változás!*/

        System.out.println("_______________Teszt 4: Svájci frank példány tesztelése 1#_________________");
        CHF chf1 = new CHF(1000);

        chf1.printEnable();
        chf1.printHuf();
        chf1.printCurrency();
        chf1.sellCurrency(20);
        System.out.println(chf1);

        chf1.printHuf();
        chf1.printCurrency();
        chf1.buyCurrency(2000);
        System.out.println(chf1);

        /*chf1.printHuf();
        chf1.printCurrency();
        chf1.sellCurrency(2000);    // Többet adunk el, mint amit lehetne, hibát fog dobni
        System.out.println(chf1);   // Nem lesz változás*/

        /*chf1.printHuf();
        chf1.printCurrency();
        chf1.sellCurrency(-2000);    // Negatív az érték, hibát dob a program!
        System.out.println(chf1);   // Nem lesz változás*/

        /*chf1.trigger();
        chf1.printEnable();
        chf1.printHuf();
        chf1.printCurrency();
        chf1.sellCurrency(20);  // Nincs engedelyezve a penznem mozgasa, hibat dobunk!
        System.out.println(chf1);   // Nem lesz valtozas!*/

        /*chf1.setHuf(4000);  // HUF értékét beállítom 4000-re
        chf1.printHuf();
        chf1.printCurrency();
        chf1.buyCurrency(5000); // Többet akarok beváltani,mint amim van. Hibát dobok!
        System.out.println(chf1);  // Nem lesz változás!*/

        /*chf1.setCurrencyVal(500);   // 500-ra állítom a CHF értékét
        chf1.printEnable();
        chf1.printHuf();
        chf1.printCurrency();
        chf1.sellCurrency(600);  // Több, mint amink van, hibát dobunk.
        System.out.println(chf1);   // Nem lesz valtozas!*/

        // Teszteltem, hogy működik-e a trigger fv.
        /*chf1.trigger();
        chf1.printEnable();
        chf1.trigger();
        chf1.printEnable();*/

        System.out.println("_______________Teszt 5: Japán yen példány tesztelése 1#_________________");
        JPY jpy1 = new JPY(12000);

        jpy1.printHuf();
        jpy1.printCurrency();
        jpy1.sellCurrency(4700);
        System.out.println(jpy1);

        /*jpy1.printHuf();
        jpy1.printCurrency();
        jpy1.sellCurrency(20);  // Legalább 1000 yen kell, hogy lehessen váltani! Itt hibát dob.
        System.out.println(jpy1);   // Nem történik semmi!*/

        /*jpy1.printHuf();
        jpy1.printCurrency();
        jpy1.buyCurrency(2000);     // Nem akarunk venni ebből a pénznemből, hibát dobunk
        System.out.println(jpy1);   // Nem lesz változás*/

        /*jpy1.printHuf();
        jpy1.printCurrency();
        jpy1.sellCurrency(2000);    // Többet adunk el, mint amit lehetne, hibát fog dobni
        System.out.println(jpy1);   // Nem lesz változás*/

        /*jpy1.printHuf();
        jpy1.printCurrency();
        jpy1.sellCurrency(-2000);    // Negatív az érték, hibát dob a program!
        System.out.println(jpy1);   // Nem lesz változás*/
    }
}
import java.io.*;
import java.net.ProtocolException;
import java.util.LinkedList;
import java.util.regex.*;

/**
 * @author Nguyen Thien Tam
 */

public class ProtoReader {
    private BufferedReader input;
    private PrintWriter output;
    private PrintWriter error;

    private InputStreamReader isr;  // Ezt fogom a BufferedReaderbe beletenni (input)
    private String regex;   // Itt tárolom el a regexet

    /*
    * Ezzel jelzem, hogy a paraméter nélküli konstruktor lett-e meghívva (konzolon írom a bemenetet)
    * vagy a paraméteres (fájlból olvasom be), mert annak megfelelően fogom az üzenetet kiírni.
    * */
    private boolean console_version;

    /*
    * Ezt arra használom, hogy a fajlbeolvasásnál csak egyszer írja ki a hibaüzenetet és ne annyiszor
    * ahány hiba van. Ha volt már hibaüzenet akkor átállítom az értéket false-ra mert alapból true, mert
    * az elején igaz, hogy még nincs hibaüzenet.
    * */
    private boolean no_error_message;

    /**
     * Ez a konstruktor az stdin/stoud/stderr használatára készíti fel a létrehozott objektumot.
     * Beállítja a regexet, a console_version booleannel jelezzük, hogy melyik konstruktor lett meghívva.
     * A no_error_message alaphelyzetben mindig true, mert ha paraméteres konstruktor van használva akkor az elején igaz, hogy
     * még nem volt hibaüzenet, ha már volt akkor be lesz állítva false-ra és akkor csak egyszer fog szólni a felhasználónak,
     * hogy van rossz bemenet és nézze meg a kimeneti txt-t és nem annyiszor ahányszor talál hibát.
     * */
    public ProtoReader() {
        isr = new InputStreamReader(System.in);
        input = new BufferedReader(isr);
        output = new PrintWriter(System.out);
        error = new PrintWriter(System.err);

        regex = "\\*BEGIN [a-zA-Z0-9\s]* \\*END";

        console_version = true;
        no_error_message = true;
    }

    /**
     * Ez a konstruktor az argumentumban megadott input, output és error használatára készíti fel a létrehozott objektumot.
     * A regex, no_error_message hasonló logika alapján van definiálva mint a fentinél.
     * A console_version false, mert itt nem konzolon olvassuk be a bemenetet.
     *
     * @param input     Beolvasandó fájl.
     * @param output    Fájl ahová kiíratom a helyes bemenetet.
     * @param error     Fájl ahová kiíratom a rossz bemenetet.
     *
     * */
    public ProtoReader(InputStream input, OutputStream output, OutputStream error) {

        this.input = new BufferedReader(new InputStreamReader(input));
        this.output = new PrintWriter(output);
        this.error = new PrintWriter(error);

        regex = "\\*BEGIN [a-zA-Z0-9\s]* \\*END";

        console_version = false;
        no_error_message = true;
    }

    /**
     * Ez a metódus egy sort olvas az input-ból, majd dekódolja.
     * Sikeres dekódolás esetén az outputba írja, sikertelen dekódolás esetén az error-ba írja és kivételt dob.
     *
     * Az elején beolvasom konzolról vagy fájlból az első sort, aztán while ciklussal ellenőrzöm hogy vége van e a
     * beolvasásnak, ha nem akkor folytassa a beolvasást. A konzol olvasásnál folyamatosan olvassa a bemenetet, ezért
     * "exit" paranccsal állítom meg a folyamatot, amikor elégnek érzem a bemenetet. A checkCorrection metódussal
     * ellenőrzöm, hogy a bemenet megfelel-e a regexnek, ha nem akkor dob exceptiont. Fájlolvasás esetén az
     * error kimeneti txt-be írja ki a rossz kifejezéseket a jókat meg az output kimeneti txt-be és konzolon dob is
     * hibaüzenetet, ha van a fájlban hibás kifejezés.
     * Konzol esetén a rossz üzenetekre szól, hogy rossz és a végén ki is írja hogy melyek voltak azok és hogy melyek voltak jók.
     *
     * @throws ProtoReaderException     Ha volt hibás bemenet, akkor azt kezeli.
     * @throws IOException              IOException kezelésére.
     * */
    public void readMessage() throws IOException {
        String strCurrentLine = input.readLine();

        while (strCurrentLine != null) {

            // "exit" paranccsal lehet megállítani a konzol olvasást
            if (strCurrentLine.equals("exit")) {
                break;
            }

            try {
                checkCorrection(strCurrentLine);
                output.println(strCurrentLine);
            }
            catch (ProtoReaderException ex) {
                error.println(strCurrentLine);
                System.err.println(ex.getMessage());
            }

            strCurrentLine = input.readLine();
        }

        input.close();

        if (console_version) {
            System.out.println("Helyes bemenet: ");
        }
        output.close();

        if (console_version) {
            System.err.println("Rossz bemenet: ");
        }
        error.close();
    }

    /**
     * Leellenőrzi, hogy a bemenet megfelel-e a regexnek.
     * Itt dobom az exception, ha a kifejezés nem volt megfelelő és a readMessage-ben catchelem.
     *
     * @param text  A bemeneti szöveg.
     * @return Boolean értékkel tér vissza. True ha a bemenet jó, false ha rossz.
     * */
    private boolean checkCorrection(String text) throws ProtoReaderException {
        Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(text);

        if (!mt.matches()) {
            if (console_version) {      // Konzol és fájlolvasás esetén más-más az üzenet.
                throw new ProtoReaderException();
            }
            else {
                if (no_error_message) {     // Ha nem volt még hibaüzenet, akkor írjon ki egyet, különben semmit.
                    no_error_message = false;
                    throw new ProtoReaderException("A beolvasott fajlban van hibas bemenet, a hiba(k) az error.txt-ben!");
                }
                else {
                    throw new ProtoReaderException("");
                }
            }
        }

        return mt.matches();
    }
}

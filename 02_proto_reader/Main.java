import java.io.*;

public class Main {
//Javította: HAlász András
//Ha lezárod a System out-ot, meg a System errort, akkor soha többet nem lehet semmit a konzolra írni.
    public static void main(String[] args) throws IOException {

        // Itt konzolon olvassuk be a bemenetet.
        ProtoReader pr1 = new ProtoReader();
        pr1.readMessage();

        // Itt meg fájlból.
        ProtoReader pr2 = new ProtoReader(new FileInputStream("test1.txt"), new FileOutputStream("out.txt"), new FileOutputStream("error.txt"));
        pr2.readMessage();
        System.out.println("Ezt nem írja ki, mert lezártad a Sys.out-ot");
    }
}

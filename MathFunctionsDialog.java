import java.util.*;

/**
 * Diese Klasse testet interaktiv die Fachklasse MathFunctions.
 * 
 * @author Mert Kiran & Daniel Stelz
 * @version 1.2
 */
public class MathFunctionsDialog {
    /**
     * Attribute
     */
    private Scanner in;

    /**
     * Klassenkonstanten
     */
    private static final int TEILERSUMME    = 1;
    private static final int ISBN           = 2;
    private static final int NULLSTELLEN    = 3;
    private static final int POTENZSUMME    = 4;
    private static final int REIHENSUMME    = 5;
    private static final int ENDE           = 0;

    /**
     * Standardkonstruktor mit dem Scanner
     */
    public MathFunctionsDialog() {
        in = new Scanner(System.in);
    }

    /**
     * Hauptschleife des Testprogramms
     * Gibt Errormeldungen in Form von Exceptions aus.
     */
    public void start() {
        int funktion = -1;

        while(funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                in.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Main-Methode zum Erzeugen des ArtikelDialog-Objektes
     * und zum Anstarten der Testschleife.
     */
    public static void main(String[] args) {
        new MathFunctionsDialog().start();
    }

    /**
     * Mit dieser Methode wird die Auswahl an Funktionen angezeigt
     * 
     * @return auszuführende Funktion
     */
    private int einlesenFunktion() {
        System.out.println(
            TEILERSUMME     + ": Teilersumme berechnen \n" +
            ISBN            + ": Prüfziffer einer ISBN-10 berechnen \n" +
            NULLSTELLEN     + ": Nullstellen bestimmen \n" +
            POTENZSUMME     + ": Summe von Potenzen berechnen \n" +
            REIHENSUMME     + ": Reihensumme berechnen \n" +
            ENDE            + ": Beenden");

        return in.nextInt();
    }

    /**
     * Die ausgewählte Funktion wird mit dieser Methode ausgeführt.
     * Enthält Die Methoden für Teilersumme, ISBN, Nullstellen und Beendung des Programmes.
     * 
     * @param funktion
     */
    private void ausfuehrenFunktion(int funktion) {
        int i;
        long zahl, isbn9, n;
        double p, q, x;

        if(funktion == TEILERSUMME) {
            System.out.println("Eine positive Zahl eingeben: ");
            zahl = in.nextLong();
            System.out.println("Die Teilersumme lautet: " + MathFunctions.berechneTeilersumme(zahl));

        } else if(funktion == ISBN) {
            System.out.println("Die ersten 9 Ziffern einer ISBN-10 eingeben: ");
            isbn9 = in.nextLong();
            System.out.println("Die Prüfziffer lautet: " + MathFunctions.berechneChecksummeIsbn(isbn9));

        } else if(funktion == NULLSTELLEN) {
            System.out.println("Einen Wert für p eingeben: ");
            p = in.nextDouble();
            System.out.println("Einen Wert für q eingeben: ");
            q = in.nextDouble();
            System.out.println(MathFunctions.berechneNullstellen(p, q));

        } else if(funktion == POTENZSUMME) {
            System.out.println("Eine obere Grenze eingeben: ");
            n = in.nextLong();
            System.out.println(MathFunctions.istSummeVonPotenzen(n));

        } else if(funktion == REIHENSUMME) {
            System.out.println("Iterator eingeben: ");
            i = in.nextInt();
            System.out.println("x-Wert eingeben: ");
            x = in.nextDouble();
            System.out.println(MathFunctions.berechneReihensumme(i, x));

        } else if(funktion == ENDE) {
            System.out.println("Programmende!");

        } else {
            System.out.println("Falsche Eingabe!");
        }
    }
}
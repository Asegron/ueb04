/**
 * Die Klasse MathFunctions bietet mathematische Funktionen 
 * in Form von Klassenmethoden an.
 * 
 * @author Mert Kiran & Daniel Stelz
 * @version 1.2
 */
public class MathFunctions {
    /**
     * Klassenkonstanten
     */
    private static final String NEGATIV =
        "Die eingegebene Zahl ist nicht positiv!";
    private static final String ISBN_FALSCH =
        "Die ISBN ist nicht 9-stellig!";
    private static final long MIN_ISBN = 100000000;
    private static final long MAX_ISBN = 999999999;
    private static final double EPSILON = 1.0E-08;

    /**
     * Standardkonstruktor
     */
    private MathFunctions() {}

    /**
     * Diese Methode berechnet die Teilersumme einer Zahl.
     * 
     * @param zahl
     * @return Teilersumme
     */
    public static long berechneTeilersumme(long zahl) {
        long i, teilersumme;

        if(zahl <= 0) {
            throw new IllegalArgumentException(NEGATIV);
        }

        for(i = 1, teilersumme = 0; i <= zahl / 2; i++) {
            if((zahl % i) == 0) {
                teilersumme += i;
            }
        }
        return teilersumme + zahl;
    }

    /**
     * Diese Methode berechnet die Prüfziffer einer ISBN-10.
     * 
     * @param isbn
     * @return Prüfziffer einer ISBN-10
     */
    public static String berechneChecksummeIsbn(long isbn) {
        long summe = 0;
        int i = 9;

        if(isbn < MIN_ISBN || isbn > MAX_ISBN) {
            throw new IllegalArgumentException(ISBN_FALSCH);
        }

        while(isbn > 0) {
            summe += (isbn % 10) * i;
            isbn /= 10;
            i--;
        }

        if(summe % 11 == 10) {
            return "X";
        } else {
            return "" + summe % 11;
        }
    }

    /**
     * Diese Methode berechnet die Nullstellen einer quadratischen Gleichung.
     * 
     * @param p
     * @param q
     * @return Nullstelle
     */
    public static String berechneNullstellen(double p, double q) {
        double diskriminante, x, x1, x2;
        String ergebnis = new String();

        diskriminante = (p / 2) * (p / 2) - q;

        if(diskriminante >= EPSILON) {
            x1 = -(p / 2) + Math.sqrt(diskriminante);
            x2 = -(p / 2) - Math.sqrt(diskriminante);
            ergebnis += "Zwei Nullstellen: " + x1 + " | " + x2;
        } else {
            if(diskriminante <= -EPSILON) {
                ergebnis += "Komplexe Nullstellen";
            } else{
                x = -(p / 2);
                ergebnis += "Doppelte Nullstelle: " + x;
            }
        }
        return ergebnis;
    }

    /**
     * Diese Methode entscheidet zu einer übergebenen positiven long-Zahl, 
     * ob es positive ganze Zahlen a, b und c gibt, so dass gilt; 
     * n = a^4 + b^3 + c^2.
     * 
     * @param n die größte Zahl, die erreicht werden darf
     * @return gültige Zahlentripel
     */
    public static boolean istSummeVonPotenzen(long n) {
        if(n <= 0) {
            throw new IllegalArgumentException(NEGATIV);
        }

        for(long a = 1; a < n; a++) {
            for(long b = 1; b < n; b++) {
                for(long c = 1; c < n; c++) {
                    if(n == (a * a * a * a) + (b * b * b) + (c * c)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Diese Methode berechnet die Reihensumme einer int-Zahl und einer double-Zahl.
     * 
     * @param x x-Wert der Summenformel
     * @param n Iterator der Summenformel
     * @return die Summe
     */
    public static double berechneReihensumme(int n, double x) {
        int i;
        double summe, summand, zaehler, zaehlerfaktor, nenner, nennerfaktor;

        if(n <= 0 || x <= 0) {
            throw new IllegalArgumentException(NEGATIV);
        }

        for(zaehler = zaehlerfaktor = (x - 1), nenner = nennerfaktor = x, 
                summe = summand = (zaehler / nenner),
                i = 2;i <= n; i++) {
            nennerfaktor    *= x;
            nenner           = i * nennerfaktor;
            zaehler         *= zaehlerfaktor;
            summand          = zaehler / nenner;
            summe           += summand;
        }
        return summe;
    }
}
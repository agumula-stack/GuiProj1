package Gui1;

import java.util.*;

public class Praca extends Thread{
    public enum rodzajPracy{
    OGÓLNA,
    MONTAŻ,
    DEMONTAŻ,
    WYMIANA
    }
    private static int licznik = 0;
    private static Map<Integer, Praca> wszystkiePrace = new HashMap<>();
    private int id;
    private rodzajPracy rodzaj;
    private int czasPracySekundy;
    private boolean czyZreazlizowane = false;
    private String opis;
    private List<Praca> praceNaKtoreCzekamy;
    private List<Praca> praceDoUruchomieniaPoTej;

    public Praca(rodzajPracy rodzaj, int czasPracySekundy, String opis, List<Praca> praceNaKtoreCzekamy) {
        this.id = ++licznik;
        this.rodzaj = rodzaj;
        this.czasPracySekundy = czasPracySekundy;
        this.opis = opis;
        this.praceNaKtoreCzekamy = praceNaKtoreCzekamy != null ? praceNaKtoreCzekamy : new ArrayList<>();
        this.praceDoUruchomieniaPoTej = new ArrayList<>();
        wszystkiePrace.put(id, this);
    }

    public List<Praca> getPraceNaKtoreCzekamy() {
        return praceNaKtoreCzekamy;
    }
}

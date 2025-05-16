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

    public Praca(rodzajPracy rodzaj, int czasPracySekundy, String opis) {
        this.id = ++licznik;
        this.rodzaj = rodzaj;
        this.czasPracySekundy = czasPracySekundy;
        this.opis = opis;
        this.praceNaKtoreCzekamy = new ArrayList<>();
        this.praceDoUruchomieniaPoTej = new ArrayList<>();
        wszystkiePrace.put(id, this);

    }
    //"Konstruktor ma przyjmować rodzaj Pracy, czas, opis oraz kolekcję Prac ( to pole nie jest
    //wymagane dla każdej pracy)." TU JEST KONSTRUKTOR BEZ TEGO POLA
    public Praca(rodzajPracy rodzaj, int czasPracySekundy, String opis, List<Praca> praceNaKtoreCzekamy) {
        this.id = ++licznik;
        this.rodzaj = rodzaj;
        this.czasPracySekundy = czasPracySekundy;
        this.opis = opis;
        this.praceNaKtoreCzekamy = praceNaKtoreCzekamy != null ? praceNaKtoreCzekamy : new ArrayList<>();
        this.praceDoUruchomieniaPoTej = new ArrayList<>();
        wszystkiePrace.put(id, this);
    }
    public void addToPraceNaKtoreCzekamy(Praca praca) {
        praceNaKtoreCzekamy.add(praca);
    }

    public void removeFromPraceNaKtoreCzekamy(Praca praca) {
        praceNaKtoreCzekamy.add(praca);
    }


    public List<Praca> getPraceNaKtoreCzekamy() {
        return praceNaKtoreCzekamy;
    }

    public List<Praca> getPraceDoUruchomieniaPoTej() {
        return praceDoUruchomieniaPoTej;
    }

    @Override
    public String toString() {
        return "Praca{" +
                "id=" + id +
                ", rodzaj=" + rodzaj +
                ", czasPracySekundy=" + czasPracySekundy +
                ", czyZreazlizowane=" + czyZreazlizowane +
                ", opis='" + opis + '\'' +
                ", praceNaKtoreCzekamy=" + praceNaKtoreCzekamy +
                ", praceDoUruchomieniaPoTej=" + praceDoUruchomieniaPoTej +
                '}';
    }
    //logika nie jest skończona tutaj, nie wyrobiłem się
}

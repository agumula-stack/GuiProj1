package Gui1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.Collections;

public abstract class Pracownik implements Comparable<Pracownik> {
    private String imie;
    private String nazwisko;
    private LocalDate dataUrodzenia;
    private DzialPracownikow dzial;
    private static final List<Pracownik> wszyscyPracownicy = new ArrayList<>();


    public Pracownik(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.dzial = dzial;
        Pracownik.wszyscyPracownicy.add(this);
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public DzialPracownikow getDzial() {return dzial;}

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }


    public static List<Pracownik> getWszyscyPracownicy() {
        return wszyscyPracownicy;
    }

    /*
 Porównuje po nazwisku.
 Jeśli nazwisko jest takie samo, to porównuje po imieniu.
 Jeśli imię też jest takie samo (może to trochę bez sensu,
 ale hipotetycznie może być dwóch Janów Kowalskich),
 to porównuje po dacie urodzenia.
*/
    @Override
    public int compareTo(Pracownik other) {

        int nazwiskoComparison = this.nazwisko.compareTo(other.nazwisko);
        if (nazwiskoComparison != 0) {
            return nazwiskoComparison;
        }

        int imieComparison = this.imie.compareTo(other.imie);
        if (imieComparison != 0) {
            return imieComparison;
        }

        return this.dataUrodzenia.compareTo(other.dataUrodzenia);
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie = " + imie +
                ", nazwisko = " + nazwisko +
                ", data urodzenia = " + dataUrodzenia +
                ", dzial = " + dzial + '}';
    }
}


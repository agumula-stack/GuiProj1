package Gui1;

import java.util.*;

public class DzialPracownikow {
    private final int id;
    private static int idCounter = 1;

    private final String nazwaDzialu;
    private List<Pracownik> pracownicy;
    private static List<String> zajeteNazwy = new ArrayList<>();
    private static List<DzialPracownikow> dzialy = new ArrayList<>();


    private DzialPracownikow(String nazwaDzialu) throws NotUniqueNameException {
        if (zajeteNazwy.contains(nazwaDzialu)) {
            throw new NotUniqueNameException("Nazwa działu '" + nazwaDzialu + "' jest zajęta.");
        }
        this.id = ++idCounter;
        this.nazwaDzialu = nazwaDzialu;
        this.pracownicy = new ArrayList<>();
        zajeteNazwy.add(nazwaDzialu);
        dzialy.add(this);
    }

    public static DzialPracownikow createDzial(String nazwaDzialu) throws NotUniqueNameException {
        return new DzialPracownikow(nazwaDzialu);
    }

    public String getNazwaDzialu() {
        return nazwaDzialu;
    }

    public int getId() {
        return id;
    }

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }


    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public static List<DzialPracownikow> getDzialy() {
        return dzialy;
    }

    @Override
    public String toString() {
        return "DzialPracownikow{" +
                "id=" + id +
                ", nazwaDzialu='" + nazwaDzialu + '\'' +
                ", pracownicy=" + pracownicy +
                '}';
    }
}

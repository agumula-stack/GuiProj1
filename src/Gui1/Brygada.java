package Gui1;

import java.util.List;
import java.util.ArrayList;

public class Brygada {
    private static int licznikBrygad = 1;
    private int numerBrygady;
    private String nazwaBrygady;
    private Brygadzista brygadzista;
    private List<Pracownik> listaPracownikow;

    public Brygada(String nazwaBrygady, Brygadzista brygadzista, List<Pracownik> listaPracownikow) {
        this.numerBrygady = licznikBrygad++;
        this.nazwaBrygady = nazwaBrygady;
        this.brygadzista = brygadzista;
        this.listaPracownikow = new ArrayList<>();
    }
//metoda poszerzona o zadanie dodatkowe nr.1
    public void dodajPracownikow(Pracownik pracownik) {
        if (pracownik.getClass() == Uzytkownik.class) {
            System.out.println("Użytkownika nie dodajemy do brygady.");
            return;
        }
            this.listaPracownikow.add(pracownik);
    }

    public void dodajPracownikow(List<Pracownik> pracownicy) {
        if (pracownicy != null) {
            this.listaPracownikow.addAll(pracownicy);
        }
    }

    public static int getLicznikBrygad() {
        return licznikBrygad;
    }

    public int getNumerBrygady() {
        return numerBrygady;
    }

    public String getNazwaBrygady() {
        return nazwaBrygady;
    }

    public Brygadzista getBrygadzista() {
        return brygadzista;
    }

    public List<Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }

    @Override
    public String toString() {
        return "Brygada{" +
                "numerBrygady=" + numerBrygady +
                ", nazwaBrygady='" + nazwaBrygady + '\'' +
                '}';
    }
}


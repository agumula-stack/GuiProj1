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

    public void dodajPracownikow(Pracownik pracownik) {
        if (!(pracownik instanceof Brygadzista)) {
            this.listaPracownikow.add(pracownik);
        }
    }

    public void dodajPracownikow(List<Pracownik> pracownicy) {
        if (pracownicy != null) {
            this.listaPracownikow.addAll(pracownicy);
        }
    }

    @Override
    public String toString() {
        return "Brygada{" +
                "numerBrygady=" + numerBrygady +
                ", nazwaBrygady='" + nazwaBrygady + '\'' +
                ", brygadzista=" + brygadzista +
                ", listaPracownikow=" + listaPracownikow +
                '}';
    }
}


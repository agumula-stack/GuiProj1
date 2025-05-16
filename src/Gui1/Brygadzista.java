package Gui1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Brygadzista extends Uzytkownik {

    private List<Brygada> brygady;
    private List<Zlecenie> zlecenia;

    public Brygadzista(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzial, login, haslo);
        this.brygady = new ArrayList<>();
        this.zlecenia = new ArrayList<>();
    }

    public List<Brygada> getBrygady() {
        return brygady;
    }

    public void dodajBrygade(Brygada brygada) {
        this.brygady.add(brygada);
    }

    public List<Zlecenie> getZlecenia() {
        return zlecenia;
    }

    public void dodajZlecenie(Zlecenie zlecenie) {
        this.zlecenia.add(zlecenie);
    }



    @Override
    public String toString() {
        return "Brygadzista {" +
                "imie = " + getImie() +
                ", nazwisko = " + getNazwisko() +
                ", data Urodzenia = " + getDataUrodzenia() +
                ", dział = " + getDzial() +
                ", login = " + getLogin() +
                ", inicjał = " + getInicjal() +
                '}';
    }
}

package Gui1;

import java.time.LocalDate;

public class Uzytkownik extends Pracownik {

    private String login;
    private String haslo;
    private String inicjal;

    public Uzytkownik(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial, String login, String haslo) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.login = login;
        this.haslo = haslo;
        this.inicjal = imie.substring(0, 1).toUpperCase() + nazwisko.substring(0, 1).toUpperCase();
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public String getInicjal() {
        return inicjal;
    }


    @Override
    public void setImie(String imie) {
        super.setImie(imie);
        this.inicjal = imie.substring(0, 1).toUpperCase() + getNazwisko().substring(0, 1).toUpperCase();
    }

    @Override
    public void setNazwisko(String nazwisko) {
        super.setNazwisko(nazwisko);
        this.inicjal = getImie().substring(0, 1).toUpperCase() + nazwisko.substring(0, 1).toUpperCase();
    }

    @Override
    public String toString() {
        return "Uzytkownik {" +
                "imie = " + getImie() +
                ", nazwisko = " + getNazwisko() +
                ", data urodzenia = " + getDataUrodzenia() +
                ", dzial = " + getDzial() +
                ", login = " + login +
                ", inicial = " + inicjal +
                '}';
    }
}



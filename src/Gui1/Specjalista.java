package Gui1;

import java.time.LocalDate;

public class Specjalista extends Pracownik {

    private String specjalizacja;

    public Specjalista(String imie, String nazwisko, LocalDate dataUrodzenia, DzialPracownikow dzial, String specjalizacja) {
        super(imie, nazwisko, dataUrodzenia, dzial);
        this.specjalizacja = specjalizacja;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    @Override
    public String toString() {
        return "Specjalista {" +
                "imie='" + getImie() + '\'' +
                ", nazwisko='" + getNazwisko() + '\'' +
                ", data urodzenia=" + getDataUrodzenia() +
                ", dzial=" + getDzial() +
                ", specjalizacja='" + specjalizacja + '\'' +
                '}';
    }
}

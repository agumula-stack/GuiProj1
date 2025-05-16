package Gui1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Gui1.DzialPracownikow.*;

public class Main {
    public static void main(String[] args) throws NotUniqueNameException {
        System.out.println("tworze dzialy: ");
        DzialPracownikow d1 = createDzial("Budowlanka");
        DzialPracownikow d2 = createDzial("IT");
        DzialPracownikow d3 = createDzial("HR");
        DzialPracownikow d4 = createDzial("Marketing");
        DzialPracownikow d5 = createDzial("Logistyka");
        DzialPracownikow d6 = createDzial("Księgowość");
        DzialPracownikow d7 = createDzial("Produkcja");

        System.out.println("tworze pracownikow: ");

        Pracownik p1 = new Specjalista("Jan", "Kowalski", LocalDate.of(1990, 1, 1), d1, "Java");
        Pracownik p2 = new Brygadzista("Anna", "Nowak", LocalDate.of(1985, 5, 10), d2, "anowak", "1234");
        Pracownik p3 = new Specjalista("Ewa", "Wisniewska", LocalDate.of(1992, 3, 15), d2, "HRM");
        Pracownik p4 = new Specjalista("Piotr", "Zieliński", LocalDate.of(1988, 8, 20), d3, "Excel");
        Pracownik p5 = new Brygadzista("Karol", "Mazur", LocalDate.of(1980, 12, 5), d4, "kmazur", "abcd");
        Pracownik p6 = new Specjalista("Monika", "Grabowska", LocalDate.of(1995, 7, 7), d5, "SAP");
        Pracownik p7 = new Specjalista("Tomasz", "Lewandowski", LocalDate.of(1987, 11, 11), d6, "Finanse");
        Pracownik p8 = new Brygadzista("Zofia", "Dąbrowska", LocalDate.of(1983, 4, 4), d7, "zdabrowska", "pass1");
        Pracownik p9 = new Specjalista("Marek", "Nowicki", LocalDate.of(1991, 9, 9), d1, "C++");
        Uzytkownik p10 = new Uzytkownik("Kuba","KNap", LocalDate.of(1932,2,11),d4,"ludek2", "12341234");
        System.out.println(p3);


        List<Pracownik> pracownicy = new ArrayList<>();

        pracownicy.add(new Uzytkownik("Dagna", "Rycka", LocalDate.of(1998, 5, 13), d1, "agghula", "123484"));
        pracownicy.add(new Uzytkownik("Joanna", "Reglska0", LocalDate.of(1998, 3, 23), d2, "agula", "123454"));
        System.out.println("przed sortem");
        for (Pracownik prac : pracownicy) {
            System.out.println(prac);
        }

        Collections.sort(pracownicy);

        System.out.println("\nPo sortowaniu:");
        for (Pracownik prac : pracownicy) {
            System.out.println(prac);


        }
        Brygada brygada1 = new Brygada("mistrzowie", (Brygadzista) p2, pracownicy);
        Brygada brygada2 = new Brygada(null, null, pracownicy);
        Brygada brygada3 = new Brygada("nowicjusze", (Brygadzista) p2, pracownicy);

        Zlecenie z = new Zlecenie(false, brygada1);
        System.out.println(Zlecenie.getZlecenieById(1).getId());

        Zlecenie z2 = new Zlecenie(true);
        z2.dodajBrygade(brygada3);
        System.out.println(z2.getBrygada().toString());

    }

}





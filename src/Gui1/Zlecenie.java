package Gui1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Zlecenie implements Runnable {

    public enum RodzajZlecenia {
        PLANOWANE,
        NIEPLANOWANE
    }

    public enum StanZlecenia {
        UTWORZONE,
        ROZPOCZĘTE,
        ZAKOŃCZONE,
    }

    private static int licznik = 1;
    private static Map<Integer, Zlecenie> zlecenia = new HashMap<>();
    private int id;
    private List<Praca> prace;
    private Brygada brygada;
    private LocalDateTime dataUtworzenia;
    private LocalDateTime dataRozpoczecia;
    private LocalDateTime dataZakonczenia;
    private RodzajZlecenia rodzaj;
    private StanZlecenia stanZlecenia;

    public Zlecenie(boolean czyPlanowane) {
        this.id = licznik++;
        zlecenia.put(this.id, this);

        this.rodzaj = czyPlanowane ? RodzajZlecenia.PLANOWANE : RodzajZlecenia.NIEPLANOWANE;
        this.dataUtworzenia = LocalDateTime.now();
        this.dataRozpoczecia = null;
        this.dataZakonczenia = null;
        this.prace = new ArrayList<>();
        this.brygada = null;
        this.stanZlecenia = StanZlecenia.UTWORZONE;
    }

    public Zlecenie(boolean czyPlanowane, Brygada brygada) {
        this(czyPlanowane);
        this.brygada = brygada;
    }

    //przemyslec
    public Zlecenie(boolean czyPlanowane, List<Praca> prace) {
        this(czyPlanowane);
        this.prace = prace != null ? prace : new ArrayList<>();
    }

    //przemyslec
    public Zlecenie(boolean czyPlanowane, List<Praca> prace, Brygada brygada) {
        this(czyPlanowane, prace);
        this.brygada = brygada;
    }

    public void addPraca(Praca praca) {
        if (praca != null) {
            prace.add(praca);
        }
    }

    public boolean dodajBrygade(Brygada b) {
        if (this.brygada == null && b != null) {
            this.brygada = b;
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public List<Praca> getPrace() {
        return prace;
    }

    public Brygada getBrygada() {
        return brygada;
    }

    public LocalDateTime getDataUtworzenia() {
        return dataUtworzenia;
    }

    public LocalDateTime getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public LocalDateTime getDataZakonczenia() {
        return dataZakonczenia;
    }

    public RodzajZlecenia getRodzaj() {
        return rodzaj;
    }

    public StanZlecenia getStanZlecenia() {
        return this.stanZlecenia;
    }

    public static Zlecenie getZlecenieById(int id) {
        return zlecenia.get(id);
    }

    @Override
    public void run() {
        if (this.brygada == null || this.prace == null || this.prace.isEmpty()) {
            System.out.println("Zlecenie nr. " + id + " nie może się rozpocząć – brak brygady lub prac.");
            return;
        }

        this.dataRozpoczecia = LocalDateTime.now();
        this.stanZlecenia = StanZlecenia.ROZPOCZĘTE;

        for (Praca praca : prace) {
            if (praca.getPraceNaKtoreCzekamy().isEmpty()) {
                praca.start();
            }
        }
        // ^ to uruchamia tylko prace, ktore moga zaczac sie od razu; niezalezne od innych prac
        for (Praca praca : prace) {
            try {
                praca.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.dataZakonczenia = LocalDateTime.now();
        this.stanZlecenia = StanZlecenia.ZAKOŃCZONE;
        System.out.println("Zlecenie nr. " + id + " zakończone.");

    }
}

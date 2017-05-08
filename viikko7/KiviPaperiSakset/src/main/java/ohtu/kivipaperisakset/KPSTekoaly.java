package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends Pelaa{

    private static final Scanner scanner = new Scanner(System.in);
    private Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String ekanSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        return ekanSiirto;
    }

    @Override
    protected String tokanSiirto(String ekanSiirto) {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}
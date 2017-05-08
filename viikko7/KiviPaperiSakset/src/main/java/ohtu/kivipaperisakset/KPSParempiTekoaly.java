package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends Pelaa {

    private static final Scanner scanner = new Scanner(System.in);   
    private TekoalyParannettu tekoalyp;

    @Override
    protected String ekanSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        return ekanSiirto;
    }

    @Override
    protected String tokanSiirto(String ekanSiirto) {
        String tokanSiirto = tekoalyp.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoalyp.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}

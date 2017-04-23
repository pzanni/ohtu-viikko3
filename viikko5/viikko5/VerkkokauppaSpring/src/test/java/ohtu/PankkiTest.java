/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Tuote;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author pzanni
 */
public class PankkiTest {
    
    private Pankki pankki;
    private Viitegeneraattori viite;
    private Varasto varasto;
    private Kauppa kauppa;
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        kauppa = new Kauppa(varasto, pankki, viite);
        
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));   
    }
       
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikein() {
    kauppa.aloitaAsiointi();
    kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    kauppa.tilimaksu("pekka", "12345");

    verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(),anyInt());   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
    
    @Test
    public void kahdenEriOstoksenMaksuTilisiirrollaSujuu() {
        when(varasto.saldo(2)).thenReturn(10); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mantelimaito", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("hanna", "444");
        
        verify(pankki).tilisiirto(eq("hanna"), anyInt(), eq("444"), anyString(), anyInt());
    }
    
    @Test
    public void kaksiSamaaOstostaTilisiirrolla() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("hanna", "444");
        
        verify(pankki).tilisiirto(eq("hanna"), anyInt(), eq("444"), anyString(), anyInt());
    }
    
    @Test
    public void toinenOstoskorinTuoteOnLoppuTilisiirto() {
        when(varasto.saldo(2)).thenReturn(0); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mantelimaito", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("hanna", "444");
        
        verify(pankki).tilisiirto(eq("hanna"), anyInt(), eq("444"), anyString(), anyInt());
    }
    
    @Test
    public void aloitaAsiointiNollaaOstoksenTiedot() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("hanna", "444");
       
        verify(pankki).tilisiirto(eq("hanna"), anyInt(), eq("444"), anyString(), anyInt());
        
        kauppa.aloitaAsiointi();
        kauppa.tilimaksu("hanna", "444");
        verify(pankki).tilisiirto(eq("hanna"), anyInt(), eq("444"), anyString(), eq(0));
    }
}

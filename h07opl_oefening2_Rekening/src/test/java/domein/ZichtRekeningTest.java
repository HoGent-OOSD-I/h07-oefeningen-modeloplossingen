package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.ZichtRekening;

class ZichtRekeningTest {

    private ZichtRekening zrek1, zrek2;

    @BeforeEach
    void before() {
        zrek1 = new ZichtRekening(123456789911L, "Antoon", -500);
        zrek2 = new ZichtRekening(123123456784L, "Carla", -1000);
    }

    @Test
    void maakZichtRekening_NegatieveMaxKredietOnderNul_objectWordtGemaakt() {
        Assertions.assertEquals(-500.0, zrek1.getMaxKredietOnderNul());
        Assertions.assertEquals(-1000.0, zrek2.getMaxKredietOnderNul());
    }

    @Test
    void maakZichtRekening_PositieveMaxKredietOnderNul_werptException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ZichtRekening(123456789911L, "Antoon", 500));
         }

    @Test
    void setMaxKredietOnderNul_Waarde0_attribuutWordtAangepast() {
        zrek2.setMaxKredietOnderNul(0);
        Assertions.assertEquals(0.0, zrek2.getMaxKredietOnderNul(), 0.0);
    }
    
    @Test
    void setMaxKredietOnderNul_WaardeBoven0_werptException() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> zrek2.setMaxKredietOnderNul(0. + Double.MIN_VALUE));
    }

    @Test
    void setMaxKredietOnderNul_WaardeOnder0OnderSaldo_werptException() {
    	zrek2.haalAf(800);
    	Assertions.assertThrows(IllegalArgumentException.class, () -> 
    	           zrek2.setMaxKredietOnderNul(-500));
    }
    
    @Test()
    void haalAf_bedragZonderOnderMaxKredietOnderNulUitkomen_saldoWijzigtNiet() {
        //zrek1 heeft maxKredietOnderNul van -500 
        Assertions.assertFalse(zrek1.haalAf(1000));
        Assertions.assertEquals(0.0, zrek2.getSaldo());
    }

    @Test
    void haalAf_bedragBovenOnderMaxKredietOnderNul_saldoWijzigtEnIsNegatief() {
        //zrek2 heeft maxKrediet van -1000
        zrek2.haalAf(500);
        Assertions.assertEquals(-500.0, zrek2.getSaldo());
    }

    @Test
    void haalAf_ongeldigBedrag_saldoBlijftGelijk()
    {
        Assertions.assertFalse(zrek1.haalAf(-300));
        Assertions.assertEquals(0.0, zrek1.getSaldo());
    }
    
    @Test
    void haalAf_bedragPreciesZelfdeAlsMaxKredietOnderNul_saldoWijzigtEnIsNegatief() {
        //zrek2 heeft maxKrediet van -1000 
        zrek2.haalAf(1000);
        Assertions.assertEquals(-1000.0, zrek2.getSaldo());
    }
    
    @Test
    void haalAf_genoegSaldoOpRekening_saldoWijzigt() {
        //zrek1 heeft maxKrediet van -500 
    	zrek1.stortOp(1000);
        zrek1.haalAf(600);
        Assertions.assertEquals(400, zrek1.getSaldo());
    }

}
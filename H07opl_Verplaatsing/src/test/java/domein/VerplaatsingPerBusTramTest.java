package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.VerplaatsingPerBusTram;

class VerplaatsingPerBusTramTest {

    private VerplaatsingPerBusTram vpbt1, vpbt2;

    @BeforeEach
    void before() 
    {
        vpbt1 = new VerplaatsingPerBusTram("Voskenslaan Gent", "Veldstraat Gent", 4.2, 1, false, true);
        vpbt2 = new VerplaatsingPerBusTram("Station Dampoort Gent", "Blaarmeersen Gent", 7.7, 49, false, false);
    }

    @Test
    void maakVerplaatsingPerBusTram_alleAttributenViaParameters_maaktObject() 
    {
        Assertions.assertEquals("Voskenslaan Gent", vpbt1.getVan());
        Assertions.assertEquals("Veldstraat Gent", vpbt1.getNaar());
        Assertions.assertEquals(4.2, vpbt1.getAantalKm());
        Assertions.assertEquals(1, vpbt1.getLijnnr());
        Assertions.assertFalse(vpbt1.isBus());
        Assertions.assertTrue(vpbt1.isStadslijn());
    }

    @Test
    void maakVerplaatsingPerBusTram_lijnNrNegatief_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new VerplaatsingPerBusTram("Voskenslaan Gent", "Veldstraat Gent", 4.2, -1, false, true));
    }

    @Test
    void setLijnnr_waardePositief_attribuutKrijgtWaarde() 
    {
        vpbt2.setLijnnr(39);
        Assertions.assertEquals(39, vpbt2.getLijnnr());
    }
    
    @Test
    void setLijnnr_waardePositiefGrens_attribuutKrijgtWaarde() 
    {
        vpbt2.setLijnnr(1);
        Assertions.assertEquals(1, vpbt2.getLijnnr());
    }

    @Test
    void setLijnnr_waardeNegatief_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> vpbt2.setLijnnr(-2));
    }
    
    @Test
    void setLijnnr_waardeNegatiefGrens_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> vpbt2.setLijnnr(-1));
    }

    @Test
    void berekenPrijs_normaalGeval_geeft2Punt56Terug() 
    {
        Assertions.assertEquals(2.56, vpbt1.berekenPrijs(), 0.001);
    }

    
}

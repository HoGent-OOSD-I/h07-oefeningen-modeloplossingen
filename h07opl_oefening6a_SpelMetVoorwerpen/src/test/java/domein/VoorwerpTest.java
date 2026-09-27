package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Voorwerp;

class VoorwerpTest 
{
    private Voorwerp vwp1, vwp2;

    @BeforeEach
    void before() 
    {
        vwp1 = new Voorwerp("speer", 150.0, 3);
    }

    @Test
    void maakVoorwerp_alleAttributenNormaal_objectWordtGemaakt() 
    {
        Assertions.assertEquals("speer", vwp1.getNaam());
        Assertions.assertEquals(3, vwp1.getNiveau());
        Assertions.assertEquals(150.0, vwp1.getGewicht());
    }

    @Test
    void maakVoorwerp_naamNietsDoorgegeven_werptException() 
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Voorwerp(null, -5.0, 3));
    }

    @Test
    void maakVoorwerp_naamLegeTekst_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Voorwerp("", -5.0, 3));
    }

    @Test
    void maakVoorwerp_gewichtTeKlein_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Voorwerp("speer", -5.0, 3));
    }

    @Test
    void maakVoorwerp_gewichtTeGroot_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Voorwerp("speer", 1500.0, 3));
    }

    @Test
    void maakVoorwerp_gewichtRandGeval_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Voorwerp("speer", 1000.0, 3));
    }

    @Test
    void maakVoorwerp_niveauTeKleinGrens_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Voorwerp("speer", 1000.0, 0));
    }
    
    @Test
    void maakVoorwerp_niveauTeKlein_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Voorwerp("speer", 1000.0, -5));
    }

    @Test
    void maakVoorwerp_niveauTeGroot_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Voorwerp("speer", 1000.0, 15));
    }
    
    @Test
    void maakVoorwerp_niveauTeGrootGrens_werptException() 
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Voorwerp("speer", 1000.0, 11));
    }

    @Test
    void maakVoorwerp_defaultWaardeNiveau_objectWordtGemaakt() 
    {
        vwp2 = new Voorwerp("speer", 150.0);
        Assertions.assertEquals("speer", vwp2.getNaam());
        Assertions.assertEquals(1, vwp2.getNiveau());
        Assertions.assertEquals(150.0, vwp2.getGewicht());
    }

    


}

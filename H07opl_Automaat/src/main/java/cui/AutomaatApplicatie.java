package cui;

import domein.DomeinController;
import domein.Grijpkraan;
import domein.KauwgomAutomaat;

public class AutomaatApplicatie {

    private final DomeinController dc;

    public AutomaatApplicatie(DomeinController dc)
    {
        this.dc = dc;
    }

	public void start() {
		String resultaat;
		boolean gelukt;

        dc.maakKauwgomAutomaatMetXBallen(200);
        dc.maakGrijpkraanMetXPrijzen(20);
		System.out.println(dc.geefResultaatNKeerDraaienAanKauwgomAutomaat(10));
        System.out.println(dc.geefResultaatNKeerDraaienAanGrijpkraan(10));
        System.out.println(dc.geefResultaatDraaienAanKauwgomAutomaatZonderBetalen());
        System.out.println(dc.geefResultaatDraaienAanKauwgomAutomaatNaTerugnemenMunt());
        System.out.println("Kauwgom er vergeten uitnemen...");
        System.out.println(dc.geefResultaat2KeerDraaienAanKauwgomAutomaatZonderKauwgomUitnemen());
        System.out.println("Kauwgom te kort...");
        dc.maakKauwgomAutomaatMetXBallen(1);
        System.out.println(dc.geefResultaatNKeerDraaienAanKauwgomAutomaat(2));
	}




}
package persistentie;

import domein.Verplaatsing;
import domein.VerplaatsingPerAuto;
import domein.VerplaatsingPerBusTram;

public class VerplaatsingMapper 
{
	public Verplaatsing[] geefVerplaatsingen()
	{       
        Verplaatsing[] vpn = new Verplaatsing[4];

        vpn[0] = new VerplaatsingPerAuto("HoGent campus Schoonmeersen Gent",
                "EFFIX Waregem", 35.4, 1.32, 0.049);
        vpn[1] = new VerplaatsingPerAuto("HoGent campus Aalst",
                "Brenso NV Affligem", 11.9, 1.37, 0.058);
        vpn[2] = new VerplaatsingPerBusTram("HoGent campus Schoonmeersen Gent",
                "Technologiepark Zwijnaarde", 4.7, 70, true, true);
        vpn[3] = new VerplaatsingPerBusTram("Sint-Pietersstation Gent",
                "Vijfwindgatenstraat Gent", 3, 22, false, true);
		return vpn;
	}

}

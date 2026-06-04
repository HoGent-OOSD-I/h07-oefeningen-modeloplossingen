package cui;

import java.util.List;

import domein.DomeinController;
import domein.Verplaatsing;
import domein.VerplaatsingPerAuto;
import domein.VerplaatsingPerBusTram;
import dto.VerplaatsingDTO;

public class VerplaatsingApplicatie
{
	private final DomeinController dc;
	
    public VerplaatsingApplicatie(DomeinController dc) 
    {
		this.dc = dc;
	}

	public void start()
    {
        List<VerplaatsingDTO> vpnDTOs = dc.geefVerplaatsingDTOs();
        int index = 0;
        
        for (VerplaatsingDTO vpDTO : vpnDTOs)
        {
        	System.out.printf("verplaatsing van %s naar %s %s", vpDTO.van(),vpDTO.naar(),
        			vpDTO.soort()=='A'?"per auto":
        				(vpDTO.bus()?String.format("met stadsbus %d", vpDTO.lijnnr()):String.format("met stadstram %d", vpDTO.lijnnr())));

            System.out.printf("%nKosten voor deze verplaatsing: € %.2f%n%n", dc.geefKostenVerplaatsing(index++));
        }
       System.out.printf("Totale kosten voor alle verplaatsingen samen: € %.2f%n", dc.geefTotaleKosten());
    	
    }

}

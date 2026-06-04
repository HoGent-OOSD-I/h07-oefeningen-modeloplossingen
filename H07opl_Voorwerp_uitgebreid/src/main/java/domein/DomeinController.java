package domein;

import java.util.ArrayList;
import java.util.List;

import dto.VoorwerpDTO;

public class DomeinController
{
private final VoorwerpRepository rr;
	
	public DomeinController()
	{
		rr = new VoorwerpRepository();
	}
	
	public VoorwerpDTO[] geefVoorwerpDTOs()
	{
		List<Voorwerp> voorwerpen = rr.getVoorwerpen();
		VoorwerpDTO[] voorwerpDTOs = new VoorwerpDTO[voorwerpen.size()];
		
		int index=0;
		for (Voorwerp v : voorwerpen)
		{
			if (v instanceof Wapen w)
			{
				//voorwerpDTOs[index++]=new VoorwerpDTO(w.getNaam(),w.getGewicht(),w.getNiveau(),w.getKracht(),w.isGebruikt(),0,0,'W');
				voorwerpDTOs[index++]=new VoorwerpDTO(w.getNaam(),w.getGewicht(),w.getNiveau(),w.getKracht(),w.isGebruikt());
			}
			else 
				if (v instanceof Sleutel s)
				{
					//voorwerpDTOs[index++]=new VoorwerpDTO(s.getNaam(),s.getGewicht(),s.getNiveau(),0,false,Sleutel.getAantalInOmloop(),s.getDeur(),'S');
					voorwerpDTOs[index++]=new VoorwerpDTO(s.getNaam(),s.getGewicht(),s.getNiveau(),Sleutel.getAantalInOmloop(),s.getDeur());
				}
		}
		
		return voorwerpDTOs;
	}

    
    public void voegWapenToe(String naam, double gewicht, int niveau, int kracht, boolean gebruikt)
    {
    	Voorwerp wapen = new Wapen(naam,gewicht,niveau,kracht,gebruikt);
    	rr.voegVoorwerpToe(wapen);
    }
    
     public void voegSleutelToe(String naam, double gewicht, int niveau, int deur)
     { 
    	 Voorwerp sleutel = new Sleutel(naam,gewicht,niveau, deur);
         rr.voegVoorwerpToe(sleutel);
     }
     
     
}

package cui;

import java.util.List;

import domein.DomeinController;


import dto.VoorwerpDTO;

public class VoorwerpApplicatie 
{
	private DomeinController dc;
	
    public VoorwerpApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start()
    {
		VoorwerpDTO[] lijstDTO = dc.geefVoorwerpDTOs();
		
		for (VoorwerpDTO dto : lijstDTO)
		{
			if(dto.soort()=='W')
				System.out.printf("Wapen %s met gewicht %.3f kg uit niveau %d en met kracht %d %s gebruikt.%n", 
						 dto.naam(),dto.gewicht(),dto.niveau(),dto.kracht(),
						dto.gebruikt()?"al":"nog niet");
			else
				if(dto.soort()=='S')
				{
					System.out.printf("Sleutel %s met gewicht %.3f kg uit niveau %d past op deur %d.%n", 
							 dto.naam(),dto.gewicht(),dto.niveau(),dto.deur());
					System.out.printf("Er zijn %d sleutel(s) in omloop.%n",dto.aantalInOmloop());
				}
		}
    }
}

package domein;

import java.util.ArrayList;
import java.util.List;

import dto.VerplaatsingDTO;

public class DomeinController 
{
	private final VerplaatsingRepository verplaatsRepo;

	public DomeinController() 
	{
		verplaatsRepo = new VerplaatsingRepository();
	}
	
	public List<VerplaatsingDTO> geefVerplaatsingDTOs()
	{
		List<VerplaatsingDTO> lijst = new ArrayList<>();
		Verplaatsing[] vpn = verplaatsRepo.getVpn();
		

		for (Verplaatsing v : vpn)
		{
			if (v instanceof VerplaatsingPerAuto )
			{
				lijst.add(new VerplaatsingDTO(v.getVan(),v.getNaar()));
			}
			else 
				if (v instanceof VerplaatsingPerBusTram vBusTram)
				{
					lijst.add(new VerplaatsingDTO(vBusTram.getVan(),vBusTram.getNaar(),vBusTram.getLijnnr(),vBusTram.isBus()));
				}
		}
		
		
		return lijst;
	}
	
	public double geefKostenVerplaatsing(int index)
	{
		return verplaatsRepo.geefKostenVerplaatsing(index);
	}
	
	public double geefTotaleKosten()
	{
		return verplaatsRepo.geefTotaleKosten();
	}

}

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
			String van = v.getVan();
			String naar = v.getNaar();
			lijst.add(
				switch(v)
				{
					case VerplaatsingPerAuto va -> new VerplaatsingDTO(van, naar);
					case VerplaatsingPerBusTram vBusTram ->
						new VerplaatsingDTO(van, naar, vBusTram.getLijnnr(),vBusTram.isBus());
					default -> throw new IllegalArgumentException("Foute verplaatsing");
				});
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

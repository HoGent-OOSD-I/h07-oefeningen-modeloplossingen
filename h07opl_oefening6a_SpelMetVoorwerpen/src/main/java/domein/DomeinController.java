package domein;

import java.util.ArrayList;
import java.util.List;

import dto.VoorwerpDTO;

public class DomeinController 
{
	private final VoorwerpRepository vr;
	
	public DomeinController()
	{
		vr = new VoorwerpRepository();
	}
	
	public VoorwerpDTO[] geefVoorwerpDTOs()
	{
		Voorwerp[] voorwerpen = vr.getVoorwerpen();
		VoorwerpDTO[] voorwerpDTOs = new VoorwerpDTO[voorwerpen.length];
		
		int index=0;
		for (Voorwerp v : voorwerpen) {
			String naam = v.getNaam();
			double gewicht = v.getGewicht();
			int niveau = v.getNiveau();
			voorwerpDTOs[index++] =
				switch (v)
				{
					case Wapen w ->
						new VoorwerpDTO(naam, gewicht, niveau, w.getKracht(), w.isGebruikt());
					case Sleutel s ->
						new VoorwerpDTO(naam, gewicht, niveau, Sleutel.getAantalInOmloop(), s.getDeur());
					default -> throw new IllegalArgumentException("onbekend voorwerp");
				};
		}
		return voorwerpDTOs;
	}

}


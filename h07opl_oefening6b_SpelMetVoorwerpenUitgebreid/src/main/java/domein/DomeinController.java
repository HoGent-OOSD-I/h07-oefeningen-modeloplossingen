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
		List<Voorwerp> voorwerpen = vr.getVoorwerpen();
		VoorwerpDTO[] voorwerpDTOs = new VoorwerpDTO[voorwerpen.size()];

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

    public void voegWapenToe(String naam, double gewicht, int niveau, int kracht, boolean gebruikt)
    {
    	Voorwerp wapen = new Wapen(naam,gewicht,niveau,kracht,gebruikt);
    	vr.voegVoorwerpToe(wapen);
    }

     public void voegSleutelToe(String naam, double gewicht, int niveau, int deur)
     {
    	 Voorwerp sleutel = new Sleutel(naam,gewicht,niveau, deur);
         vr.voegVoorwerpToe(sleutel);
     }
}

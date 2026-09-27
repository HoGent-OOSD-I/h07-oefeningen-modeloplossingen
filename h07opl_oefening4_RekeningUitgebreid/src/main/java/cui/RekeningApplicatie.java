package cui;

import java.util.List;

import domein.DomeinController;
import dto.RekeningDTO;

public class RekeningApplicatie
{
	private DomeinController dc;
	
	public RekeningApplicatie(DomeinController dc)
	{
		this.dc = dc;
	}

	public void werkMetRekeningen()
	{
		dc.wijzigRekeningen();
        List<RekeningDTO> lijstDTO = dc.geefRekeningDTOs();
		String soort, extra;

		for (RekeningDTO dto : lijstDTO)
		{
			soort = "";
		    extra = "";
			switch(dto.soort())
			{
				case 'S': soort = "Spaarrekening";
						  extra = "met aangroeiIntrest van %.2f%n".formatted(dto.aangroeiIntrest());
				case 'Z': soort = "Zichtrekening";
						  extra = "met maxKrediet van %.2f%n".formatted(dto.maxKredietOnderNul());
			}
			System.out.printf("%S %d op naam van %s heeft saldo van %.2f %s",
					soort, dto.rekeningnummer(), dto.houder(), dto.saldo(), extra);
		}
	}
}

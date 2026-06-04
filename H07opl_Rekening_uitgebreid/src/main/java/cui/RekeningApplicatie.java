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

		for (RekeningDTO dto : lijstDTO)
		{
			System.out.printf("%S %d op naam van %s heeft saldo van %.2f ", dto.soort()=='S'?"Spaarrekening":"ZichtRekening",dto.rekeningnummer(), dto.houder(), dto.saldo());
			if(dto.soort()=='Z')
				System.out.printf("met maxKrediet van %.2f%n",dto.maxKredietOnderNul());
			else
				System.out.printf("met aangroeiIntrest van %.2f%n",dto.aangroeiIntrest());
		}

	}
}

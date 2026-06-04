package domein;

import java.util.ArrayList;
import java.util.List;

import dto.RekeningDTO;

public class DomeinController
{
	private final RekeningRepository rr;
	
	public DomeinController()
	{
		rr = new RekeningRepository();
	}
	
	public void wijzigRekeningen()
	{
		rr.wijzigRekeningen();
	}
	
	public List<RekeningDTO> geefRekeningDTOs()
	{
		List<Rekening> lijst = rr.getRekeningen();
		List<RekeningDTO> rekeningDTOs = new ArrayList<>();
		
		for (Rekening r : lijst)
		{
			long reknr = r.getRekeningNr();
			double saldo = r.getSaldo();
			String houder = r.getHouder();
			
			if (r instanceof SpaarRekening)
				rekeningDTOs.add(RekeningDTO.maakSpaarrekeningDTO(reknr, saldo, houder, SpaarRekening.getAangroeiIntrest()));
			else // r is geen SpaarRekening
				if (r instanceof ZichtRekening zr)
					rekeningDTOs.add(RekeningDTO.maakZichtrekeningDTO(reknr, saldo, houder, zr.getMaxKredietOnderNul()));
		}		
		return rekeningDTOs;
	}
}

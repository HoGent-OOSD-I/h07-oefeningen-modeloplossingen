package domein;

import java.util.List;

import persistentie.RekeningMapper;

public class RekeningRepository
{
	private final RekeningMapper rm;
	private final List<Rekening> rekeningen;
	
	public RekeningRepository()
	{
		rm = new RekeningMapper(); // niet vergeten!!!
		rekeningen = rm.geefRekeningen();
	}

	public List<Rekening> getRekeningen()
	{
		return rekeningen;
	}
	
	public void wijzigRekeningen()
	{
		for (Rekening r : rekeningen)
		{
			if (r instanceof SpaarRekening)
			{
				double rente = r.getSaldo() * SpaarRekening.getAangroeiIntrest() / 100;
				r.stortOp(rente);
			}
			else
				if (r instanceof ZichtRekening zr)
				{
					double krediet = zr.getMaxKredietOnderNul();
					krediet -= 10;
					zr.setMaxKredietOnderNul(krediet);
					//OF
					//zr.setMaxKredietOnderNul(zr.getMaxKredietOnderNul() - 10);
				}
		}
	}
}

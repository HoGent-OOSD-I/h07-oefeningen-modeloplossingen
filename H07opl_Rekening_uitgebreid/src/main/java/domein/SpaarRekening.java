package domein;

public class SpaarRekening extends Rekening
{
	private static double aangroeiIntrest;

	public static double getAangroeiIntrest()
	{
		return aangroeiIntrest;
	}

	public static void setAangroeiIntrest(double aangroeiIntrest)
	{
		if (aangroeiIntrest < 0)
			throw new IllegalArgumentException("Intrest mag niet negatief zijn!");
		SpaarRekening.aangroeiIntrest = aangroeiIntrest;
	}

	public SpaarRekening(long rekeningNr, String houder)
	{
		super(rekeningNr, houder);
	}

	@Override
	public boolean haalAf(double bedrag)
	{
		if (bedrag <= getSaldo())
			return super.haalAf(bedrag); // kan alleen nog mislukken omdat bedrag <= 0 is
		// else - bedrag te hoog!
		return false;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s. Aangroeiintrest = %.2f%%", 
				super.toString(), aangroeiIntrest);
	}
}

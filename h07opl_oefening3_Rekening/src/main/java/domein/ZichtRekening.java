package domein;

public class ZichtRekening extends Rekening
{
	private double maxKredietOnderNul;

	public ZichtRekening(long rekeningNr, String houder, double maxKredietOnderNul)
	{
		super(rekeningNr, houder);
		setMaxKredietOnderNul(maxKredietOnderNul);
	}
	
	public double getMaxKredietOnderNul()
	{
		return maxKredietOnderNul;
	}

	public void setMaxKredietOnderNul(double maxKredietOnderNul)
	{
		if (maxKredietOnderNul > 0 || maxKredietOnderNul > getSaldo())
			throw new IllegalArgumentException("Maxkrediet moet negatief zijn en moet "
					+ "lager liggen dan of gelijk zijn aan het huidig saldo!");
		this.maxKredietOnderNul = maxKredietOnderNul;
	}

	@Override
	public boolean haalAf(double bedrag)
	{
		if (getSaldo() - bedrag >= maxKredietOnderNul)
			return super.haalAf(bedrag); // kan alleen nog mislukken omdat bedrag <= 0 is
		
		// else - bedrag te hoog!
		return false;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s. Max krediet onder nul = %.2f", 
				super.toString(), maxKredietOnderNul);
	}

}

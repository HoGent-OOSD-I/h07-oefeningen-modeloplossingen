package domein;

public class Grijpkraan extends Automaat
{	
	public Grijpkraan(int aantalPrijzen)
	{
		super(aantalPrijzen);
	}

    @Override
	public boolean draaiHendel()
	{
		boolean gewonnen = sr.nextBoolean();

		if (gewonnen)
		{
			return super.draaiHendel();
		}
		
		if (isMuntInGleuf())
		{	 
			setMuntInGleuf(false);
			setAantalMunten(getAantalMunten()+1);
		}
		return false;
	}

    public String geefResultaatNKeerDraaien(int n, boolean neem) {
        boolean gelukt;
        String resultaat;
        int aantal = getAantalItems();

        String uitvoer = super.draaiNKeer(n,neem);
        for (int i = 1; i <= n; i++) {
            betaal();
            gelukt = draaiHendel();
            resultaat = gelukt ? "" : "geen ";
            uitvoer += String.format("Poging %d: %sprijs gewonnen%n", i, resultaat);
            if (gelukt) // we moeten er alleen iets uitnemen als er iets uit gekomen is!
                neemItem();
        }
        return uitvoer;
    }
}

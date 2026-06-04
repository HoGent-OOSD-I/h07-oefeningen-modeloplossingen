package domein;

import utils.Kleur;

public class KauwgomAutomaat extends Automaat
{
	public KauwgomAutomaat(int aantalBallen)
	{
		super(aantalBallen);
	}

	public Kleur bepaalKleur()
	{
		Kleur[] kleuren = Kleur.values();
		int randomIndex = sr.nextInt(kleuren.length);
		return kleuren[randomIndex];
	}

    public String geefResultaatNKeerDraaien(int n, boolean neem) {
        boolean gelukt;
        String uitvoer = super.draaiNKeer(n,neem);

        for (int i = 1; i <= n; i++) {
            betaal();
            gelukt = draaiHendel();
            uitvoer += String.format("Poging %d: ", i);
            if (gelukt)
                uitvoer += String.format("%s kauwgombal%n", bepaalKleur().name().toLowerCase());
            else // mislukt
                if (isItemInBak()) // er zit nog een kauwgom in
                    uitvoer += String.format("kauwgombal zit er nog in!%n");
                else // er is geen kauwgom meer voorradig
                    uitvoer += String.format("geen kauwgom meer!%n");
            if (neem) // ik neem de bal er uit als neem = true
                neemItem();
        }
        return uitvoer;
    }
}
package domein;

import java.security.SecureRandom;

public class Automaat
{
	private int aantalItems;
	private int aantalMunten;
	private boolean muntInGleuf;
	private boolean itemInBak;
	
	protected final SecureRandom sr;

	public Automaat(int aantalItems)
	{
		setAantalItems(aantalItems);
		sr = new SecureRandom();
	}
	
	public int getAantalItems()
	{
		return this.aantalItems;
	}

	public final void setAantalItems(int value)
	{
		this.aantalItems = value;
	}

	public int getAantalMunten()
	{
		return this.aantalMunten;
	}

	public final void setAantalMunten(int value)
	{
		this.aantalMunten = value;
	}

	public boolean isMuntInGleuf()
	{
		return this.muntInGleuf;
	}

	public final void setMuntInGleuf(boolean value)
	{
		this.muntInGleuf = value;
	}

	public boolean isItemInBak()
	{
		return this.itemInBak;
	}

	public final void setItemInBak(boolean value)
	{
		this.itemInBak = value;
	}

	public void betaal()
	{
		setMuntInGleuf(true);
	}

	public boolean draaiHendel()
	{
		if (muntInGleuf && !itemInBak && aantalItems != 0)
		{
			setAantalItems(aantalItems - 1);
			setAantalMunten(aantalMunten + 1);
			setMuntInGleuf(false);
			setItemInBak(true);
			return true; // draaien gelukt
		}
		
		// else - niet betaald, er lag nog iets in de bak of er zijn geen kauwgommen meer
		neemMuntTerug();
		return false;
	}

	public void neemItem()
	{
		setItemInBak(false);
	}

	public void neemMuntTerug()
	{
		setMuntInGleuf(false);
	}

    public String geefResultaatNKeerDraaien(int n, boolean neem) {
        String uitvoer = String.format("%d keer aan de hendel draaien van een %s met %d item%s%n", n,
                getClass().getSimpleName().toLowerCase(), aantalItems, aantalItems == 1 ? "" : "s");
        return uitvoer;
    }
}

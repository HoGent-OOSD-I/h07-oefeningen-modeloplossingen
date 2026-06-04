package persistentie;

import domein.Sleutel;
import domein.Voorwerp;
import domein.Wapen;

public class VoorwerpMapper 
{
	public Voorwerp[] geefVoorwerpen()
	{
    	Voorwerp voorwerpen[] = new Voorwerp[4];        
        voorwerpen[0] = new Wapen("colt", 1.5, 3, 6, false); 
        voorwerpen[1] = new Wapen("brown", 0.5, 1, 23, true);
        voorwerpen[2] = new Sleutel("voordeur", 0.5, 3, 1);
        voorwerpen[3] = new Sleutel("achterdeur", 0.5, 1, 2);
		return voorwerpen;
	}

}

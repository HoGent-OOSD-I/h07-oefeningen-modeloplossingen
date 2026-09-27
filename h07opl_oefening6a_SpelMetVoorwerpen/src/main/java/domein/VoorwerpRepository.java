package domein;

import java.util.List;

import persistentie.VoorwerpMapper;

public class VoorwerpRepository 
{
	private final VoorwerpMapper rm;
	private final Voorwerp[] voorwerpen;
	
	public VoorwerpRepository()
	{
		rm = new VoorwerpMapper(); // niet vergeten!!!
		voorwerpen = rm.geefVoorwerpen();
	}

	public Voorwerp[] getVoorwerpen() {
		return voorwerpen;
	}



}

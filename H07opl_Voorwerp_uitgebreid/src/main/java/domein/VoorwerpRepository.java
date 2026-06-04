package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import persistentie.VoorwerpMapper;


public class VoorwerpRepository
{
	private final VoorwerpMapper rm;
	private final List<Voorwerp> voorwerpen;
	
	public VoorwerpRepository()
	{
		rm = new VoorwerpMapper(); // niet vergeten!!!
		voorwerpen = new ArrayList<>(Arrays.asList(rm.geefVoorwerpen()));
	}

	public List<Voorwerp> getVoorwerpen() {
		return voorwerpen;
	}


	public void voegVoorwerpToe(Voorwerp v)
	{
		 voorwerpen.add(v);	
	}
}

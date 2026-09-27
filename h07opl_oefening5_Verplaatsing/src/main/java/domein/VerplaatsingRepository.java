package domein;

import persistentie.VerplaatsingMapper;

public class VerplaatsingRepository 
{
	private final VerplaatsingMapper vMapper;
	private final Verplaatsing[] vpn;
	

	public VerplaatsingRepository() 
	{
		vMapper = new VerplaatsingMapper();
		vpn = vMapper.geefVerplaatsingen();
	}
	
	public Verplaatsing[] getVpn() {
		return vpn;
	}

	public double geefKostenVerplaatsing(int index)
	{
		Verplaatsing vp = vpn[index];
		if(vp instanceof VerplaatsingPerAuto auto)				
    		return auto.berekenPrijs();			
    	else				
    		return ((VerplaatsingPerBusTram)vp).berekenPrijs();
	}
	
	public double geefTotaleKosten()
	{
		double totaleKosten = 0;
		for (int index = 0; index < vpn.length;index++)
        {
            totaleKosten += geefKostenVerplaatsing(index);
        }
       
        return totaleKosten;
	}

}

package domein;

public class VerplaatsingPerAuto extends Verplaatsing
{
    private double benzineprijs;    // prijs in euro per liter
    private double verbruik;        // liter per kilometer
    
    public static final double MIN_BENZINEPRIJS = 0.5;			
    public static final double MAX_BENZINEPRIJS = 2.0;			
    public static final double MIN_VERBRUIK = 0.02;			
    public static final double MAX_VERBRUIK = 0.07;			

    public VerplaatsingPerAuto(String van, String naar, double aantalKm, double benzineprijs, double verbruik) 
    {
        super(van, naar, aantalKm);
        setBenzineprijs(benzineprijs);
        setVerbruik(verbruik);
    }
    
    public final void setBenzineprijs(double benzineprijs) {								
    	if (benzineprijs < MIN_BENZINEPRIJS || benzineprijs > MAX_BENZINEPRIJS)							
    		throw new IllegalArgumentException(						
    				String.format("De benzineprijs moet tussen %.1f en %.1f euro liggen",				
    						MIN_BENZINEPRIJS, MAX_BENZINEPRIJS));		
    	this.benzineprijs = benzineprijs;							
    }								
    
    public final void setVerbruik(double verbruik) {								
    	if (verbruik < MIN_VERBRUIK || verbruik > MAX_VERBRUIK)							
    		throw new IllegalArgumentException(						
    				String.format("Het verbruik moet tussen de %.2f en de %.2f liter per km liggen",				
    						MIN_VERBRUIK, MAX_VERBRUIK));		
    	this.verbruik = verbruik;							
    }								
    
    public double getBenzineprijs()  
    { 
        return benzineprijs; 
    }
    
    public double getVerbruik() 
    { 
        return verbruik; 
    }
    
    @Override
    public String toString() 
    { 
        return String.format("%s per auto", super.toString()); 
    }
    
    public double berekenPrijs() 
    {
        return 2 * verbruik * benzineprijs * getAantalKm();
    }
}
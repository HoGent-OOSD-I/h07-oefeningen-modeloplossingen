package domein;

public class Voorwerp
{
    private final String naam;
    private double gewicht;
    private int niveau;
    
    private static final int MAX_NIVEAU = 10;
    private static final int MAX_GEWICHT = 1000;
    public static final int MIN_GEWICHT = 0;		
    public static final int MIN_NIVEAU = 1;		
    
    public Voorwerp(String naam, double gewicht, int niveau)
    {
        controleerNaam(naam);
        this.naam = naam;
        setGewicht(gewicht);
        setNiveau(niveau);
    }
    
    public Voorwerp(String naam, double gewicht)
    {
        this(naam,gewicht,1);
    }
    
    private void controleerNaam(String naam) {
        if (naam == null || naam.isBlank())
            throw new IllegalArgumentException("Elk voorwerp moet verplicht een naam hebben.");
    }
           
    private void setGewicht(double gewicht) {										
    	if (gewicht < MIN_GEWICHT || gewicht >= MAX_GEWICHT)									
    		throw new IllegalArgumentException(String								
    				.format("Gewicht moet groter of gelijk aan %d en minder dan %d kg zijn", MIN_GEWICHT, MAX_GEWICHT));						
    	this.gewicht = gewicht;									
    }										
    										
    private void setNiveau(int niveau) {										
    	if (niveau < MIN_NIVEAU || niveau > MAX_NIVEAU)									
    		throw new IllegalArgumentException(								
    				String.format("Niveau moet tussen %d en %d liggen", MIN_NIVEAU, MAX_NIVEAU));						
    	this.niveau = niveau;
    }
    
    public String getNaam()
    {
        return naam;
    }
    public double getGewicht()
    {
        return gewicht;
    }
    public int getNiveau()
    {
        return niveau;
    }
    @Override
    public String toString()
    {
        return String.format("%s %s met gewicht %.3f kg uit niveau %d", this.getClass().getSimpleName(), naam, gewicht, niveau);
    }


}

package dto;

public record VerplaatsingDTO(String van, String naar, int lijnnr, boolean bus, char soort) 
{

	public VerplaatsingDTO(String van, String naar,int lijnnr, boolean bus)
	{
		this(van, naar, lijnnr, bus, 'B');
	}
	
	public VerplaatsingDTO(String van, String naar)
	{
		this(van, naar, 0, false,'A');
	}
}

package dto;

public record VoorwerpDTO(String naam,double gewicht,int niveau,int kracht,boolean gebruikt,int aantalInOmloop,int deur,char soort) 
{
	public VoorwerpDTO(String naam,double gewicht,int niveau,int kracht,boolean gebruikt)
	{
		this(naam,gewicht,niveau,kracht,gebruikt,0,0,'W');
	}
	
	public VoorwerpDTO(String naam,double gewicht,int niveau,int aantalInOmloop,int deur)
	{
		this(naam,gewicht,niveau,0,false,aantalInOmloop,deur,'S');
	}

}

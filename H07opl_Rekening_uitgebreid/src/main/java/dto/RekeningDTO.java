package dto;

public record RekeningDTO(long rekeningnummer, double saldo, String houder,double maxKredietOnderNul, double aangroeiIntrest, char soort)
{
	public static RekeningDTO maakSpaarrekeningDTO(long rekeningnummer, double saldo, String houder, double aangroeiIntrest)
	{
		return new RekeningDTO(rekeningnummer, saldo, houder, 0, aangroeiIntrest, 'S');
	}	
	public static RekeningDTO maakZichtrekeningDTO(long rekeningnummer, double saldo, String houder, double maxKredietOnderNul)
	{
		return new RekeningDTO(rekeningnummer, saldo, houder, maxKredietOnderNul, 0, 'Z');
	}
}

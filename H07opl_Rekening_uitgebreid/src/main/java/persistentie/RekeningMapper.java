package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Rekening;
import domein.SpaarRekening;
import domein.ZichtRekening;

public class RekeningMapper
{
	public List<Rekening> geefRekeningen()
	{
		// we doen alsof we de inhoud van de tabel Rekening uit onze database ophalen
		List<Rekening> lijst = new ArrayList<>();
		// normaliter: SQL-statement (select gebruiken) om een ResultSet krijgen
		// Resultset overlopen en uit elke record een Object van Rekening maken
		Rekening sr1, sr2, zr1, zr2;
		sr1 = new SpaarRekening(101L, "Senne");
		sr2 = new SpaarRekening(202L, "Michiel");
		zr1 = new ZichtRekening(303L, "Kamiel", -2000);
		zr2 = new ZichtRekening(404L, "Jens", -2500);
		
		sr1.stortOp(1000);
		sr2.stortOp(2000);
		zr1.stortOp(3000);
		zr2.stortOp(4000);
		
		SpaarRekening.setAangroeiIntrest(2);
		
		lijst.add(zr2);
		lijst.add(sr2);
		lijst.add(sr1);
		lijst.add(zr1);
		
		return lijst;
	}
}

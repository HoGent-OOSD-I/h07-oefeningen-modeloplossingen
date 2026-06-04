package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Rekening;

public class RekeningTest
{
	private Rekening piet, sofie;

	@BeforeEach
	public void before()
	{
		piet = new Rekening(232346789122L, "Piet");
		sofie = new Rekening(232346789122L, "Sofie");
	}
	
	@Test
	public void maakRekening_rekeningnummerEnHouderOK_maaktObject()
	{
		Assertions.assertEquals(232346789122L, piet.getRekeningNr());
		Assertions.assertEquals(0.0, piet.getSaldo());
		Assertions.assertEquals("Piet", piet.getHouder());
	}

	@Test
	public void maakRekening_defaultWaardenZonderParameters_maaktObject()
	{
		Rekening rek = new Rekening();
		Assertions.assertEquals(0L, rek.getRekeningNr());
		Assertions.assertEquals(0.0, rek.getSaldo());
		Assertions.assertEquals("onbekend", rek.getHouder());
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {" "})
	public void maakRekening_verkeerdeHouder_werptException(String houder)
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Rekening(232346789122L, houder));
	}
	
	@Test
	public void maakRekening_verkeerdRekeningnummer_werptException()
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Rekening(232346789123L, "Jan"));
	}
	
	@Test
	public void stortOp_geldigBedrag_saldoVerhoogt()
	{
		piet.stortOp(150);
		Assertions.assertEquals(150.0, piet.getSaldo());
	}

	@Test
	public void stortOp_0_saldoBlijftGelijk()
	{
		piet.stortOp(0);
		Assertions.assertEquals(0., piet.getSaldo());
	}
	
	@Test
	public void stortOp_negatiefBedrag_saldoBlijftGelijk()
	{
		piet.stortOp(-300);
		Assertions.assertEquals(0., piet.getSaldo());
	}

	@Test
	public void haalAf_geldigBedragSaldoToereikend_saldoDaalt()
	{
		sofie.stortOp(150);
		sofie.haalAf(30);
		Assertions.assertEquals(120., sofie.getSaldo());
	}

	@Test
	public void haalAf_geldigBedragSaldoOntoereikend_saldoWordtNegatief()
	{
		sofie.haalAf(230);
		Assertions.assertEquals(-230, sofie.getSaldo());
	}
	
	@Test
	public void haalAf_ongeldigBedrag_saldoBlijftGelijk()
	{
		sofie.haalAf(-230);
		Assertions.assertEquals(0.0, sofie.getSaldo());
	}
	
	@Test
	public void haalAf_0_saldoBlijftGelijk()
	{
		sofie.haalAf(0);
		Assertions.assertEquals(0.0, sofie.getSaldo());
	}

	@Test
	public void schrijfBedragOverNaar_geldigBedragSaldoToereikend_overschrijvingLukt()
	{
		sofie.stortOp(150);
		sofie.schrijfBedragOverNaar(30, piet);
		Assertions.assertEquals(120., sofie.getSaldo());
		Assertions.assertEquals(30., piet.getSaldo());
	}

	@Test
	public void schrijfBedragOverNaar_negatiefBedragOverschrijven_geenOverschrijvingSaldiBlijvenGelijk()
	{
		sofie.stortOp(150);
		sofie.schrijfBedragOverNaar(-30, piet);
		Assertions.assertEquals(150., sofie.getSaldo());
		Assertions.assertEquals(0., piet.getSaldo());
	}

	@Test
	public void schrijfBedragOverNaar_bedragOverschrijvenWaarbijSaldoOnderNulGaat_saldoWordtNegatief()
	{
		sofie.stortOp(150);
		sofie.schrijfBedragOverNaar(200, piet);
		Assertions.assertEquals(-50, sofie.getSaldo());
		Assertions.assertEquals(200, piet.getSaldo());
	}
}

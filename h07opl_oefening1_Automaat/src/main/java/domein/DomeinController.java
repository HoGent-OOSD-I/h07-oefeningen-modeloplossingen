package domein;

public class DomeinController
{
    private KauwgomAutomaat k;
    private Grijpkraan g;

    public void maakKauwgomAutomaatMetXBallen(int x)
    {
        k = new KauwgomAutomaat(x);
    }

    public void maakGrijpkraanMetXPrijzen(int x)
    {
        g = new Grijpkraan(x);
    }

    public String geefResultaatNKeerDraaienAanKauwgomAutomaat(int n)
    {
        return k.geefResultaatNKeerDraaien(n, true);
    }

    public String geefResultaatNKeerDraaienAanGrijpkraan(int n)
    {
        return g.geefResultaatNKeerDraaien(n, true);
    }

    public String geefResultaatDraaienAanKauwgomAutomaatZonderBetalen()
    {
        boolean gelukt = k.draaiHendel();
        String resultaat = gelukt ? "ge" : "mis";
        return String.format("Zonder te betalen... %slukt%n", resultaat);
    }

    public String geefResultaatDraaienAanKauwgomAutomaatNaTerugnemenMunt()
    {
        k.betaal();
        k.neemMuntTerug();
        boolean gelukt = k.draaiHendel();
        String resultaat = gelukt ? "ge" : "mis";
        return String.format("Munt teruggenomen... %slukt%n", resultaat);
    }

    public String geefResultaat2KeerDraaienAanKauwgomAutomaatZonderKauwgomUitnemen()
    {
        return k.geefResultaatNKeerDraaien(2, false);
    }
}

package cui;

import java.util.List;

import domein.DomeinController;
import dto.VoorwerpDTO;

public class VoorwerpApplicatie {
	private DomeinController dc;

	public VoorwerpApplicatie(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		System.out.println("Beginsituatie:");
		toonOverzicht();

		dc.voegWapenToe("Long Rifle", 1.25, 4, 99, false);
		dc.voegSleutelToe("Garagedeur", 0.5, 4, 3);
		dc.voegWapenToe("Hagelgeweer", 0.75, 1, 35, true);
		dc.voegSleutelToe("Tuinhuisdeur", 0.5, 10, 4);

		System.out.println("\n\nNa het toevoegen van enkele wapens en sleutels:");
		toonOverzicht();
	}

	private void toonOverzicht() {
		VoorwerpDTO[] overzicht = dc.geefVoorwerpDTOs();

		if (overzicht == null)
			System.out.printf("collectie is leeg%n%n");
		else

			for (VoorwerpDTO dto : overzicht) {
				if (dto.soort() == 'W')
					System.out.printf("Wapen %s met gewicht %.3f kg uit niveau %d en met kracht %d %s gebruikt.%n",
							dto.naam(), dto.gewicht(), dto.niveau(), dto.kracht(), dto.gebruikt() ? "al" : "nog niet");
				else if (dto.soort() == 'S') {
					System.out.printf("Sleutel %s met gewicht %.3f kg uit niveau %d past op deur %d.%n", dto.naam(),
							dto.gewicht(), dto.niveau(), dto.deur());
					System.out.printf("Er zijn %d sleutel(s) in omloop.%n", dto.aantalInOmloop());
				}
			}
	}
}

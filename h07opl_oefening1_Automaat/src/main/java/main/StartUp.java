package main;

import cui.AutomaatApplicatie;
import domein.DomeinController;

public class StartUp
{
	public static void main()
	{
		new AutomaatApplicatie(new DomeinController()).start();
	}
}	
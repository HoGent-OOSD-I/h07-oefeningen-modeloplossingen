package main;

import cui.RekeningApplicatie;
import domein.DomeinController;

public class StartUp
{
	public static void main(String[] args)
	{
		new RekeningApplicatie(new DomeinController()).werkMetRekeningen();
	}

}

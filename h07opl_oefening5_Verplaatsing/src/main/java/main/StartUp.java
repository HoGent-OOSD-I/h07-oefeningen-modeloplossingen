package main;

import cui.VerplaatsingApplicatie;
import domein.DomeinController;

public class StartUp 
{
    public static void main()
    {
        new VerplaatsingApplicatie(new DomeinController()).start();
    }
}

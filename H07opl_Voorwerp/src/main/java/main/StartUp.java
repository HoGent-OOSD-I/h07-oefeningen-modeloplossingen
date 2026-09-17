package main;

import cui.VoorwerpApplicatie;
import domein.DomeinController;

public class StartUp 
{
    public static void main()
    {
        new VoorwerpApplicatie(new DomeinController()).start();
    }
}

package main;

import cui.VerplaatsingApplicatie;
import domein.DomeinController;

public class StartUp 
{
    public static void main(String[] args) 
    {
        new VerplaatsingApplicatie(new DomeinController()).start();
    }
}

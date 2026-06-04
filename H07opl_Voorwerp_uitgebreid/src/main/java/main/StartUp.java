package main;

import cui.VoorwerpApplicatie;
import domein.DomeinController;

public class StartUp 
{
    public static void main(String[] args) 
    {
        new VoorwerpApplicatie(new DomeinController()).start();
    }
}

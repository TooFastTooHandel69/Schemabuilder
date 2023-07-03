package com.company;

import java.util.*;
import java.util.Scanner;

class Oefening
{
    private static ArrayList<Structuur> alleOefeningen;
    private String naam;
    private String doel;
    private static ArrayList<Structuur> initialiseerOefeningen(){
        alleOefeningen = new ArrayList<Structuur>();
        alleOefeningen.add(new Structuur("Dumbell-Shoulder-press", "Schouder",4,10,60, 20));
        alleOefeningen.add(new Structuur("Overhead-press", "Schouder",4,10,60, 30));
        alleOefeningen.add(new Structuur("shoulder-fly", "Schouder",4,10,60, 14));
        alleOefeningen.add(new Structuur("reverse-cable-crossover", "Schouder",4,10,60, 9));
        alleOefeningen.add(new Structuur("behind-the-neck-press", "Schouder",4,10,60, 30));

        alleOefeningen.add(new Structuur("Bicep-curls","Bicep", 3, 12, 30, 30));
        alleOefeningen.add(new Structuur("Barbell-curls", "Bicep", 5, 10, 60, 35));
        alleOefeningen.add(new Structuur("Hammer-Curls", "Bicep", 3,12,30,16));
        alleOefeningen.add(new Structuur("Bicep-Cable-Curl", "Bicep", 5,10,15,23));

        alleOefeningen.add(new Structuur("Tricep-extensions","Tricep", 5,10,30,20));
        alleOefeningen.add(new Structuur("Cable-push-down","Tricep", 5,10,60,30));
        alleOefeningen.add(new Structuur("Kick-Backs","Tricep", 5,10,45,12));

        alleOefeningen.add(new Structuur("Sit-ups", "Buik", 3,25,30, 30));
        alleOefeningen.add(new Structuur("Plank", "Buik", 3,60,120, 0));
        alleOefeningen.add(new Structuur("Reverse-crunsh", "Buik", 4,25,30, 30));

        alleOefeningen.add(new Structuur("Squats","Benen", 5,10,60,100));
        alleOefeningen.add(new Structuur("Stiff-leg-deadlift","Benen", 5,10,60,70));
        alleOefeningen.add(new Structuur("leg-extensions","Benen", 4,10,60,50));
        alleOefeningen.add(new Structuur("Hack-squats","Benen", 4,10,80,120));
        alleOefeningen.add(new Structuur("Leg-curl","Benen", 4,10,30,40));

        alleOefeningen.add(new Structuur("Lat-pull-downs", "Rug", 4,12,30,45));
        alleOefeningen.add(new Structuur("Dubbel-rows", "Rug", 5,8,60,30));
        alleOefeningen.add(new Structuur("T-bar", "Rug", 5,10,80,50));
        alleOefeningen.add(new Structuur("Seated-row", "Rug", 5,8,60,60));
        alleOefeningen.add(new Structuur("Pull-Ups", "Rug", 5,8,60,100));

        alleOefeningen.add(new Structuur("Bench press", "Borst",3,6,30, 140));
        alleOefeningen.add(new Structuur("Cable-fly", "Borst",4,12,30, 41));
        alleOefeningen.add(new Structuur("incline-Bench press", "Borst",3,10,30, 80));
        alleOefeningen.add(new Structuur("Low-Cable-Crossovers", "Borst",4,12,30, 14));
        alleOefeningen.add(new Structuur("Dumbell-press", "Borst",4,12,30, 14));


        alleOefeningen.add(new Structuur("Seated Calve-Raises", "Kuiten",3,12,30, 40));
        alleOefeningen.add(new Structuur("Standing Calve-Raises", "Kuiten",3,12,30, 40));


        return alleOefeningen;
    }
    public Oefening(String naam){
        initialiseerOefeningen();
        this.naam = naam;
    }
    public Oefening(String naam, String doel){
        this(naam);
        this.doel = doel;

    }


    private static void printOefening(String naam, String spierGroep, Integer aantalSets, Integer reps, Integer rustTijd, Integer gewicht)
    {
        System.out.println("Oefening voor " + spierGroep + ": " + naam +
                " herhaal " + aantalSets + " sets " +
                "(rust tussendoor " + rustTijd + " seconden) " +
                reps +
                " repetitions " + "gewicht " + gewicht);
    }
    public void printSchema(ArrayList<String> spierGroep){
        System.out.println("Schema: " + this.naam);
        if(this.doel != null){
            System.out.println("Droom body: " + this.doel);
        }
        for(String kay : spierGroep){
            for (Structuur oefening : alleOefeningen){
                if(kay.equals(oefening.getSpierGroep())){
                    printOefening(oefening.getNaam(), oefening.getSpierGroep(), oefening.getAantalSets(), oefening.getHerhalingen(), oefening.getRustTijd(), oefening.getGewicht());
                }
            }
        }
        System.out.println();

    }
}
class Structuur {
    private String naam;
    private String spierGroep;
    private Integer aantalSets;
    private Integer reps;
    private Integer rustTijd;
    private Integer gewicht;
    public Structuur(String naam, String spierGroup, Integer aantalsets, Integer reps, Integer rustTijd, Integer gewicht){
        this.naam = naam;
        this.spierGroep = spierGroup;
        this.aantalSets = aantalsets;
        this.reps = reps;
        this.rustTijd = rustTijd;
        this.gewicht = gewicht;

    }
    public String getNaam(){
        return this.naam;
    }
    public String getSpierGroep(){
        return this.spierGroep;
    }
    public Integer getAantalSets(){
        return this.aantalSets;
    }
    public Integer getHerhalingen(){
        return this.reps;
    }
    public Integer getRustTijd(){
        return this.rustTijd;
    }
    public Integer getGewicht() {return this.gewicht;}

}
class Schema{
    private String name;
    private String dreamBody;
    private ArrayList<TrainingDag> TrainingsDagen;

    public Schema() {
        TrainingsDagen = new ArrayList<>();
        initialiseerDag();
    }

    public void schemaGenarator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wat is u naam?");
        name = scanner.nextLine();

        System.out.println("Voer de naam in van een persoon wiens lichaamsbouw u bewondert:");
        dreamBody = scanner.nextLine();

        System.out.println("Laten we beginnen!");

        System.out.println("Hoeveel dagen per week wil je trainen?");
        int nummervanTrainingsDagen = scanner.nextInt();

        if (nummervanTrainingsDagen >= 3 || nummervanTrainingsDagen
        == TrainingsDagen.size()) {
            for (int i = 0; i < nummervanTrainingsDagen; i++) {
                TrainingDag trainingDay = TrainingsDagen.get(i);
                System.out.println("Dag " + (i + 1) + ":");
                PrintTrainingsSchema((ArrayList<String>) trainingDay.getSpierGroep());
            }
        } else {
            System.out.println("Ongeldig aantal trainingsdagen. Kies een geldige optie.");
        }
    }

    private void initialiseerDag() {
        TrainingsDagen.add(new TrainingDag("Rug", "Bicep", "Buik"));
        TrainingsDagen.add(new TrainingDag("Benen", "Schouder", "Kuiten"));
        TrainingsDagen.add(new TrainingDag("Borst", "Tricep"));
        TrainingsDagen.add(new TrainingDag("Rug", "Bicep", "Buik"));
        TrainingsDagen.add(new TrainingDag("Benen", "Schouder", "Kuiten"));
        TrainingsDagen.add(new TrainingDag("Borst", "Tricep"));
        TrainingsDagen.add(new TrainingDag("Borst", "Benen", "Rug"));
        // Add more training days as needed
    }

    private void PrintTrainingsSchema(ArrayList<String> muscleGroups) {
        Oefening oefeningen = new Oefening(name, dreamBody);
        oefeningen.printSchema(muscleGroups);
        System.out.println();
    }

    private static class TrainingDag {
        private List<String> SpierGroepen;

        public TrainingDag(String... SpierGroepen) {
            this.SpierGroepen = new ArrayList<>();
            for (String muscleGroup : SpierGroepen) {
                this.SpierGroepen.add(muscleGroup);
            }
        }

        public List<String> getSpierGroep() {
            return SpierGroepen;
        }
    }


}
class Menu {
    public void lijst() {
        String[] list = {"Typ een getal voor uw keuze.", "1. Trainingschema", "2. Oefeningen voor een spiergroep naar keuze"};

        for (String s : list) {
            System.out.println(s);
        }
    }
}
class Spiergroep{

    private String voor;

    private String droom;

    public void lijst() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat is uw naam?");
        voor = scanner.nextLine();
        System.out.println("Geef hier de naam van een persoon waarvan jij zijn lichaam bewondert.");
        droom = scanner.nextLine();
        System.out.println("Laten we aan de slag gaan!");
        String[] list = {"Kies welke spiergroep je wilt trainen","Typ een getal voor uw keuze.", "1.Borst", "2.Rug", "3.Benen", "4.Schouder", "5.Buik", "6.Bicep", "7.Tricep", "8.Kuiten"};

        for (String s : list) {
            System.out.println(s);
        }

        int num = scanner.nextInt();
        if (num==1){
            Borst h = new Borst();
            h.Exercise();
        }
        else if (num==2){
           Rug C = new Rug();
           C.Exercise();
        }
        else if (num==3){
            Benen C = new Benen();
            C.Exercise();
        }
        else if (num==4){
            Schouder C = new Schouder();
            C.Exercise();
        }
        else if (num==5){
            BuikSpieren C = new BuikSpieren();
            C.Exercise();
        }
        else if (num==6){
            Bicep C = new Bicep();
            C.Exercise();
        }
        else if (num==7){
            Tricep C = new Tricep();
            C.Exercise();
        }
        else if (num==8){
            Kuiten C = new Kuiten();
            C.Exercise();
        }
        else{
            System.out.println("Moeilijk he een getal kiezen!");
        }
    }
    public String getDroom() {
        return droom;
    }
    public String getVoor() {
        return voor;
    }

}
class Borst extends Spiergroep{
    public void Exercise() {
        ArrayList<String> koen = new ArrayList<>();
        koen.add("Borst");
        Oefening koenP = new Oefening(getVoor(),getDroom());
        koenP.printSchema(koen);
    }
}
class Rug extends Spiergroep{
    public void Exercise() {
        ArrayList<String> koen = new ArrayList<>();
        koen.add("Rug");
        Oefening koenP = new Oefening(getVoor(),getDroom());
        koenP.printSchema(koen);
    }
}
class Benen extends Spiergroep{
    public void Exercise() {
        ArrayList<String> koen = new ArrayList<>();
        koen.add("Benen");
        Oefening koenP = new Oefening(getVoor(),getDroom());
        koenP.printSchema(koen);
    }
}
class Schouder extends Spiergroep{
    public void Exercise() {
        ArrayList<String> koen = new ArrayList<>();
        koen.add("Schouder");
        Oefening koenP = new Oefening(getVoor(),getDroom());
        koenP.printSchema(koen);
    }
}
class BuikSpieren extends Spiergroep{
    public void Exercise() {
        ArrayList<String> koen = new ArrayList<>();
        koen.add("buik");
        Oefening koenP = new Oefening(getVoor(),getDroom());
        koenP.printSchema(koen);
    }
}
class Bicep extends Spiergroep{
    public void Exercise() {
        ArrayList<String> koen = new ArrayList<>();
        koen.add("Bicep");
        Oefening koenP = new Oefening(getVoor(),getDroom());
        koenP.printSchema(koen);
    }
}
class Tricep extends Spiergroep{
    public void Exercise() {
        ArrayList<String> koen = new ArrayList<>();
        koen.add("Tricep");
        Oefening koenP = new Oefening(getVoor(),getDroom());
        koenP.printSchema(koen);
    }
}
class Kuiten extends Spiergroep{
    public void Exercise() {
        ArrayList<String> koen = new ArrayList<>();
        koen.add("Kuiten");
        Oefening koenP = new Oefening(getVoor(),getDroom());
        koenP.printSchema(koen);
    }
}



class Main
{

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        Menu y = new Menu();
        y.lijst();
        int num = scanner.nextInt();
        Schema h = new Schema();
        Spiergroep k = new Spiergroep();
        if (num==1){
            h.schemaGenarator();
        }
        else if (num==2){
            k.lijst();
        }
        else {
            System.out.println("type 1 of 2 probeer opnieuw.");
        }
    }

}
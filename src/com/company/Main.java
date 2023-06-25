package com.company;

import java.util.*;
import java.util.Scanner;

class oefeningen
{
    private static ArrayList<frame> alleOefeningen;
    private String naam;
    private String doel;
    private static ArrayList<frame> initialiseerOefeningen(){
        alleOefeningen = new ArrayList<frame>();
        alleOefeningen.add(new frame("Dumbell-Shoulder-press", "Schouder",4,10,60, 20));
        alleOefeningen.add(new frame("Overhead-press", "Schouder",4,10,60, 30));
        alleOefeningen.add(new frame("shoulder-fly", "Schouder",4,10,60, 14));
        alleOefeningen.add(new frame("reverse-cable-crossover", "Schouder",4,10,60, 9));
        alleOefeningen.add(new frame("behind-the-neck-press", "Schouder",4,10,60, 30));

        alleOefeningen.add(new frame("Bicep-curls","Bicep", 3, 12, 30, 30));
        alleOefeningen.add(new frame("Barbell-curls", "Bicep", 5, 10, 60, 35));
        alleOefeningen.add(new frame("Hammer-Curls", "Bicep", 3,12,30,16));
        alleOefeningen.add(new frame("Bicep-Cable-Curl", "Bicep", 5,10,15,23));

        alleOefeningen.add(new frame("Tricep-extensions","Tricep", 5,10,30,20));
        alleOefeningen.add(new frame("Cable-push-down","Tricep", 5,10,60,30));
        alleOefeningen.add(new frame("Kick-Backs","Tricep", 5,10,45,12));

        alleOefeningen.add(new frame("Sit-ups", "Buik", 3,25,30, 30));
        alleOefeningen.add(new frame("Plank", "Buik", 3,60,120, 0));
        alleOefeningen.add(new frame("Reverse-crunsh", "Buik", 4,25,30, 30));

        alleOefeningen.add(new frame("Squats","Benen", 5,10,60,100));
        alleOefeningen.add(new frame("Stiff-leg-deadlift","Benen", 5,10,60,70));
        alleOefeningen.add(new frame("leg-extensions","Benen", 4,10,60,50));
        alleOefeningen.add(new frame("Hack-squats","Benen", 4,10,80,120));
        alleOefeningen.add(new frame("Leg-curl","Benen", 4,10,30,40));

        alleOefeningen.add(new frame("Lat-pull-downs", "Rug", 4,12,30,45));
        alleOefeningen.add(new frame("Dubbel-rows", "Rug", 5,8,60,30));
        alleOefeningen.add(new frame("T-bar", "Rug", 5,10,80,50));
        alleOefeningen.add(new frame("Seated-row", "Rug", 5,8,60,60));
        alleOefeningen.add(new frame("Pull-Ups", "Rug", 5,8,60,100));

        alleOefeningen.add(new frame("Bench press", "Borst",3,6,30, 140));
        alleOefeningen.add(new frame("Cable-fly", "Borst",4,12,30, 41));
        alleOefeningen.add(new frame("incline-Bench press", "Borst",3,10,30, 80));
        alleOefeningen.add(new frame("Low-Cable-Crossovers", "Borst",4,12,30, 14));
        alleOefeningen.add(new frame("Dumbell-press", "Borst",4,12,30, 14));


        alleOefeningen.add(new frame("Seated Calve-Raises", "Kuiten",3,12,30, 40));
        alleOefeningen.add(new frame("Standing Calve-Raises", "Kuiten",3,12,30, 40));


        return alleOefeningen;
    }
    public oefeningen(String naam){
        initialiseerOefeningen();
        this.naam = naam;
    }
    public oefeningen(String naam, String doel){
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
            for (frame oefening : alleOefeningen){
                if(kay.equals(oefening.getSpierGroep())){
                    printOefening(oefening.getNaam(), oefening.getSpierGroep(), oefening.getAantalSets(), oefening.getHerhalingen(), oefening.getRustTijd(), oefening.getGewicht());
                }
            }
        }
        System.out.println();

    }
}
class frame{
    private String naam;
    private String spierGroep;
    private Integer aantalSets;
    private Integer reps;
    private Integer rustTijd;
    private Integer gewicht;
    public frame(String naam, String spierGroup, Integer aantalsets,Integer reps, Integer rustTijd, Integer gewicht){
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
class schema extends menu {
    private String name;
    private String dreamBody;
    private ArrayList<TrainingDag> TrainingsDagen;

    public schema() {
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
        oefeningen oefeningen = new oefeningen(name, dreamBody);
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

//    public void lijst() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Wat is uw naam?");
//        String voor = scanner.nextLine();
//        System.out.println("Geef hier de naam van een persoon waarvan jij zijn lichaam bewondert.");
//        String droom = scanner.nextLine();
//            System.out.println("Laten we aan de slag gaan!");
//        System.out.println("Hoeveel dagen wilt u dit week trainen");
//        Integer dag = scanner.nextInt();
//        if (dag == 3) {
//            System.out.println("Day 1:");
//            ArrayList<String> day1MuscleGroups = new ArrayList<>();
//            day1MuscleGroups.add("Back");
//            day1MuscleGroups.add("Biceps");
//            day1MuscleGroups.add("Abs");
//            oefeningen kp = new oefeningen(voor, droom);
//            kp.printSchema(day1MuscleGroups);
//
//            System.out.println("Day 2:");
//            ArrayList<String> day2MuscleGroups = new ArrayList<>();
//            day2MuscleGroups.add("Legs");
//            day2MuscleGroups.add("Shoulders");
//            day2MuscleGroups.add("Calves");
//            oefeningen sp = new oefeningen(voor, droom);
//            sp.printSchema(day2MuscleGroups);
//
//            System.out.println("Day 3:");
//            ArrayList<String> day3MuscleGroups = new ArrayList<>();
//            day3MuscleGroups.add("Chest");
//            day3MuscleGroups.add("Triceps");
//            oefeningen YP = new oefeningen(voor, droom);
//            YP.printSchema(day3MuscleGroups);
//        }
//        else if (dag == 4) {
//            System.out.println("Dag EEN Gaat als volgt");
//            ArrayList<String> koen = new ArrayList<>();
//            koen.add("Rug");
//            koen.add("Buik");
//            oefeningen koenP = new oefeningen(voor,droom);
//            koenP.printSchema(koen);
//            System.out.println("Dag Twee kom op hou het vol!!!");
//            ArrayList<String> koen1 = new ArrayList<>();
//            koen1.add("Benen");
//            koen1.add("Kuiten");
//            oefeningen koenT = new oefeningen(voor);
//            koenT.printSchema(koen1);
//            System.out.println("Dag Drie!!");
//            ArrayList<String> koen2 = new ArrayList<>();
//            koen2.add("Borst");
//            koen2.add("Tricep");
//            oefeningen koenK = new oefeningen(voor);
//            koenK.printSchema(koen2);
//            System.out.println("Dag Vier!!!!");
//            ArrayList<String> koen3 = new ArrayList<>();
//            koen3.add("Bicep");
//            koen3.add("Schouder");
//            oefeningen koenw = new oefeningen(voor);
//            koenw.printSchema(koen3);
//        }
//        else if (dag == 5) {
//            System.out.println("Dag EEN Gaat als volgt");
//            ArrayList<String> koen = new ArrayList<>();
//            koen.add("Rug");
//            koen.add("Buik");
//            oefeningen koenP = new oefeningen(voor,droom);
//            koenP.printSchema(koen);
//            System.out.println("Dag Twee kom op hou het vol!!!");
//            ArrayList<String> koen1 = new ArrayList<>();
//            koen1.add("Benen");
//            koen1.add("Kuiten");
//            oefeningen koenT = new oefeningen(voor);
//            koenT.printSchema(koen1);
//            System.out.println("Dag Drie!!");
//            ArrayList<String> koen2 = new ArrayList<>();
//            koen2.add("Borst");
//            koen2.add("Tricep");
//            oefeningen koenK = new oefeningen(voor);
//            koenK.printSchema(koen2);
//            System.out.println("Dag Vier!!!!");
//            ArrayList<String> koen3 = new ArrayList<>();
//            koen3.add("Bicep");
//            koen3.add("Schouder");
//            oefeningen koenw = new oefeningen(voor);
//            koenw.printSchema(koen3);
//            System.out.println("Dag Vijf!!!!");
//            ArrayList<String> koen4 = new ArrayList<>();
//            koen4.add("Benen");
//            koen4.add("Borst");
//            oefeningen koenq = new oefeningen(voor);
//            koenq.printSchema(koen4);
//        }
//        else if (dag == 6) {
//            System.out.println("Dag EEN Gaat als volgt");
//            ArrayList<String> koen = new ArrayList<>();
//            koen.add("Rug");
//            koen.add("Buik");
//            oefeningen koenP = new oefeningen(voor,droom);
//            koenP.printSchema(koen);
//            System.out.println("Dag Twee kom op hou het vol!!!");
//            ArrayList<String> koen1 = new ArrayList<>();
//            koen1.add("Benen");
//            koen1.add("Kuiten");
//            oefeningen koenT = new oefeningen(voor);
//            koenT.printSchema(koen1);
//            System.out.println("Dag Drie!!");
//            ArrayList<String> koen2 = new ArrayList<>();
//            koen2.add("Borst");
//            koen2.add("Tricep");
//            oefeningen koenK = new oefeningen(voor);
//            koenK.printSchema(koen2);
//            System.out.println("Dag Vier!!!!");
//            ArrayList<String> koen3 = new ArrayList<>();
//            koen3.add("Bicep");
//            koen3.add("Schouder");
//            oefeningen koenw = new oefeningen(voor);
//            koenw.printSchema(koen3);
//            System.out.println("Dag Vijf!!!!");
//            ArrayList<String> koen4 = new ArrayList<>();
//            koen4.add("Benen");
//            koen4.add("Borst");
//            oefeningen koenq = new oefeningen(voor);
//            koenq.printSchema(koen4);
//            System.out.println("Dag zes kom op hou het vol!!!!");
//            ArrayList<String> koen5 = new ArrayList<>();
//            koen5.add("Rug");
//            koen5.add("Bicep");
//            koen5.add("Tricep");
//            oefeningen koenr = new oefeningen(voor);
//            koenr.printSchema(koen5);
//        }
//        else if (dag == 7) {
//            System.out.println("Dag EEN Gaat als volgt");
//            ArrayList<String> koen = new ArrayList<>();
//            koen.add("Rug");
//            koen.add("Buik");
//            oefeningen koenP = new oefeningen(voor,droom);
//            koenP.printSchema(koen);
//            System.out.println("Dag Twee kom op hou het vol!!!");
//            ArrayList<String> koen1 = new ArrayList<>();
//            koen1.add("Benen");
//            koen1.add("Kuiten");
//            oefeningen koenT = new oefeningen(voor);
//            koenT.printSchema(koen1);
//            System.out.println("Dag Drie!!");
//            ArrayList<String> koen2 = new ArrayList<>();
//            koen2.add("Borst");
//            koen2.add("Tricep");
//            oefeningen koenK = new oefeningen(voor);
//            koenK.printSchema(koen2);
//            System.out.println("Dag Vier!!!!");
//            ArrayList<String> koen3 = new ArrayList<>();
//            koen3.add("Bicep");
//            koen3.add("Schouder");
//            oefeningen koenw = new oefeningen(voor);
//            koenw.printSchema(koen3);
//            System.out.println("Dag Vijf!!!!");
//            ArrayList<String> koen4 = new ArrayList<>();
//            koen4.add("Benen");
//            koen4.add("Borst");
//            oefeningen koenq = new oefeningen(voor);
//            koenq.printSchema(koen4);
//            System.out.println("Dag zes kom op hou het vol!!!!");
//            ArrayList<String> koen5 = new ArrayList<>();
//            koen5.add("Rug");
//            koen5.add("Bicep");
//            koen5.add("Tricep");
//            oefeningen koenr = new oefeningen(voor);
//            koenr.printSchema(koen5);
//            System.out.println("Dag zeven als je dit iedere week doet ben je voordat je het weet je eigen droom body<3<3<3");
//            ArrayList<String> koen6 = new ArrayList<>();
//            koen6.add("Schouder");
//            koen6.add("Kuiten");
//            koen6.add("Buik");
//            oefeningen koent = new oefeningen(voor);
//            koent.printSchema(koen6);
//        }
//        else {
//            System.out.println("De aantal dagen die u heeft aangegeven om te trainen is niet reëel.");
//            System.out.println("Ik raad u aan om keuze twee te kiezen.");
//        }

//    }
}
class menu{
    public void lijst() {
        String[] list = {"Typ een getal voor uw keuze.", "1. Trainingschema", "2. Oefeningen voor een spiergroep naar keuze"};

        for (String s : list) {
            System.out.println(s);
        }
    }
}
class spiergroep extends menu{

    public void lijst() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat is uw naam?");
        String voor = scanner.nextLine();
        System.out.println("Geef hier de naam van een persoon waarvan jij zijn lichaam bewondert.");
        String droom = scanner.nextLine();
        System.out.println("Laten we aan de slag gaan!");
        String[] list = {"Kies welke spiergroep je wilt trainen","Typ een getal voor uw keuze.", "1.Borst", "2.Rug", "3.Benen", "4.Schouder", "5.Buik", "6.Bicep", "7.Tricep", "8.Kuiten"};

        for (String s : list) {
            System.out.println(s);
        }

        int num = scanner.nextInt();
        if (num==1){
            ArrayList<String> koen = new ArrayList<>();
            koen.add("Borst");
            oefeningen koenP = new oefeningen(voor,droom);
            koenP.printSchema(koen);
        }
        else if (num==2){
            ArrayList<String> koen = new ArrayList<>();
            koen.add("Rug");
            oefeningen koenP = new oefeningen(voor,droom);
            koenP.printSchema(koen);
        }
        else if (num==3){
            ArrayList<String> koen = new ArrayList<>();
            koen.add("Benen");
            oefeningen koenP = new oefeningen(voor,droom);
            koenP.printSchema(koen);
        }
        else if (num==4){
            ArrayList<String> koen = new ArrayList<>();
            koen.add("Schouder");
            oefeningen koenP = new oefeningen(voor,droom);
            koenP.printSchema(koen);
        }
        else if (num==5){
            ArrayList<String> koen = new ArrayList<>();
            koen.add("Buik");
            oefeningen koenP = new oefeningen(voor,droom);
            koenP.printSchema(koen);
        }
        else if (num==6){
            ArrayList<String> koen = new ArrayList<>();
            koen.add("Bicep");
            oefeningen koenP = new oefeningen(voor,droom);
            koenP.printSchema(koen);
        }
        else if (num==7){
            ArrayList<String> koen = new ArrayList<>();
            koen.add("Tricep");
            oefeningen koenP = new oefeningen(voor,droom);
            koenP.printSchema(koen);
        }
        else if (num==8){
            ArrayList<String> koen = new ArrayList<>();
            koen.add("Kuiten");
            oefeningen koenP = new oefeningen(voor,droom);
            koenP.printSchema(koen);
        }
        else{
            System.out.println("Moeilijk he een getal kiezen!");
        }
    }

}



class Main
{

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        menu y = new menu();
        y.lijst();
        int num = scanner.nextInt();
        schema h = new schema();
        spiergroep k = new spiergroep();
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
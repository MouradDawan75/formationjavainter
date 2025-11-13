package javainter.ddd.agregates;

/*
Agregate (composition): contient des Entity + VO
C'est l'objet principal du domaine, il reflète le besoin mérier et c'est l'objet qu'on expose via le service.

C'est une sorte de regroupement d'objets reliés entre eux que nous traitons comme une seule entité
dont le but est la gestion centralisée des modifications apportées aux autres objets

- permet de garantir la consistance des modifications apportées aux objets
- de réduire le nombre d'objets à maintenir dans le code
 */

import javainter.ddd.entities.User;
import javainter.ddd.valueobjects.Corpulance;

import java.time.LocalDate;

public class Imc {

    private int id;
    private User user;
    private Corpulance corpulance;
    private String interpretation;
    private LocalDate mesureDate;
    private double value;

    public Imc(User user, Corpulance corpulance, String interpretation, LocalDate mesureDate, double value) {

        this.user = user;
        this.corpulance = corpulance;
        this.interpretation = interpretation;
        this.mesureDate = mesureDate;
        this.value = value;
    }

    public Imc(User user, Corpulance corpulance,  LocalDate mesureDate) {

        this.user = user;
        this.corpulance = corpulance;
        this.mesureDate = mesureDate;

    }

    public void computeValue(){
        this.value = (corpulance.getWeight()) / Math.pow(corpulance.getHeight(), 2);
    }


    public void interpreter() {
        interpretation = staticInterpreter(value);
    }

    public static String staticInterpreter(double value){
        if(value < 16.5){
            return "dénutrition";
        } else if (value < 18.5) {
            return "maigreur";
        } else if (value < 25) {
            return "corpulence normale";
        } else if (value < 30) {
            return "surpoids";
        } else if (value < 35) {
            return "obésité modérée";
        }else{
            return " obésité sévère";
        }
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Corpulance getCorpulance() {
        return corpulance;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public LocalDate getMesureDate() {
        return mesureDate;
    }

    public double getValue() {
        return value;
    }
}

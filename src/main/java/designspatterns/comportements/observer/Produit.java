package designspatterns.comportements.observer;

import java.util.ArrayList;
import java.util.List;

public class Produit implements Sujet<Double>{

    private String description;
    private double prix;

    //doit gérer une collection d'observers
    List<Observer<Double>> observers = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
        notify(prix);
    }

    public Produit(String description, double prix) {
        this.description = description;
        this.prix = prix;
    }

    public Produit() {
    }

    @Override
    public void attach(Observer<Double> obs) {
        observers.add(obs);
    }

    @Override
    public void detach(Observer<Double> obs) {
        observers.remove(obs);
    }

    @Override
    public void notify(Double obj) {
        for(Observer o : observers){
            o.update(obj);
        }
    }
}

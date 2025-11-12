package javainter.solid.openclose.bad;

public class Rectangle {

    private double hauteur;
    private double largeur;

    public Rectangle(double hauteur, double largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public Rectangle() {
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
}

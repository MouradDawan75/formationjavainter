package javainter.solid.openclose.bad;

public class Cercle {

    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    public Cercle() {
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }
}

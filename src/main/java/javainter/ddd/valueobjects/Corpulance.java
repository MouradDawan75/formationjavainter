package javainter.ddd.valueobjects;

import java.util.Objects;

public class Corpulance {

    private double weight;
    private double height;

    public Corpulance(double height, double weight) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    //pas de setter


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Corpulance that = (Corpulance) o;
        return Double.compare(weight, that.weight) == 0 && Double.compare(height, that.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, height);
    }
}

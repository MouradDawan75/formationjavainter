package javainter.solid.openclose.bad;

public class SurfaceCalculateur {

    /*
    open/close: une classe doit être ouverte à l'extension, mais fermée
    l'ajout d'une classe (Triangle), nécessite l'ajout d'une nouvelle méthode -> c'est une violation de open/close
     */

    public double surfaceRectangle(Rectangle rec){
        return rec.getHauteur() * rec.getLargeur();
    }

    public double cercleSurface(Cercle cer){
        return  Math.PI * Math.pow(cer.getRayon(), 2);
    }

    //nouvelle méthode pour le calcul de la surface d'un triangle
    public double triangleSurface(Triangle t){
        return 0;
    }
}

package designspatterns.comportements.observer;

public class Client implements Observer<Double>{

    private String nom;

    public Client(String nom) {
        this.nom = nom;
    }

    public Client() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void update(Double prix) {
        //logique
        System.out.println(nom+" "+"notification de prix reçue: "+prix );
    }
}

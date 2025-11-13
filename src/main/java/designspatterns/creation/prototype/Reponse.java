package designspatterns.creation.prototype;

public class Reponse implements Cloneable{

    private String texte;
    private boolean correct;

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Reponse(String texte, boolean correct) {
        this.texte = texte;
        this.correct = correct;
    }

    public Reponse() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

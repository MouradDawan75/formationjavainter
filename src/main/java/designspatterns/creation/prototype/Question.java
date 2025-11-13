package designspatterns.creation.prototype;

import java.util.ArrayList;
import java.util.List;

public class Question implements Cloneable{

    private String texte;
    public List<Reponse> reponses = new ArrayList<>();

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    public Question(String texte) {
        this.texte = texte;
    }

    public Question() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Question qst  = (Question) super.clone(); //cloange des types standards: int, string,char......


        //gestion des types complèxes
        qst.reponses = new ArrayList<>();
        for(Reponse rep : reponses){
            qst.reponses.add((Reponse) rep.clone());
        }

        return qst;
    }
}

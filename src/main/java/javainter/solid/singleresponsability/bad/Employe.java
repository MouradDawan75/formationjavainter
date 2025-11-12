package javainter.solid.singleresponsability.bad;

public class Employe {

    private int id;
    private String name;

    public Employe(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void save (Employe e){

    }

    public Boolean isPromotionDueThisYear(){
        return false;
    }
}
/*
Constat: classe qui gère plusieurs tâches
Si on constate qu'une classe gère 2 tâches ou plus, posez la question de savoir s'il vous devez scinder cette classe en 2.
Single Of Responsability: on doit définir des classes qui ne gèrent qu'une seule tâche. doit s'appliquer par tout: packages, classes, méthodes
Avantages:
- Meilleure organisation du code
- Faible couplage
- facilité de maintenance  - de debug
 */

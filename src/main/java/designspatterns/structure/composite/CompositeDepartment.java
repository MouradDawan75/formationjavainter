package designspatterns.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui décrit le rôle du pattern composite
 */
public class CompositeDepartment implements Depatement{
    /*
   Contient une collection d'objets
   Implèmente les méthodes communes à ces objets
    */

    private List<Depatement> departments = new ArrayList<>();

    public void addDepartement(Depatement dep){
        departments.add(dep);
    }

    public void removeDepartment(Depatement dep){
        departments.remove(dep);
    }

    @Override
    public void printDepatementName() {
        departments.forEach(d -> d.printDepatementName());
    }


}

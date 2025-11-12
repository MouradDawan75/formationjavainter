package javainter.solid.interfacesegregation.bad;

import javainter.solid.singleresponsability.bad.Employe;

import java.util.Date;

public interface IFonctionnalites {
    void insert(Employe e);
    void delete(Employe e);
    String getTypeContrat();
    Date getDateEmbauche();
}

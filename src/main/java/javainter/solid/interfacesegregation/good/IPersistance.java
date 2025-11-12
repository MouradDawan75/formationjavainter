package javainter.solid.interfacesegregation.good;

import javainter.solid.singleresponsability.bad.Employe;

public interface IPersistance {
    void insert(Employe e);
    void delete(Employe e);
}

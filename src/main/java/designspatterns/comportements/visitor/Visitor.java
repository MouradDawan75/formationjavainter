package designspatterns.comportements.visitor;

/**
 * Interface qui décrit le rôle du visitor.
 * Son rôle est de visite tous es objets qui partagent le mm traitement
 */
public interface Visitor {

    void visit(Rectangle rec);
    void visit(Cercle cer);
}

/*
Open/Close: n'est pas respectée
 */

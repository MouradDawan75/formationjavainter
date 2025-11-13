package designspatterns.comportements.visitor;

/**
 * Interface qui décrit le rôle de chauqe objet dans le pattern visitor.
 * Le rôle de chaque bjet est d'accèpter la visite du visitor
 */
public interface Forme {
    void accept(Visitor v);
}

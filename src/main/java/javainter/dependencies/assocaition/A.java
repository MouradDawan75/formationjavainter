package javainter.dependencies.assocaition;

/*
Dépendence de type association
L'objet n'a pas à connaitre le processus d'instaciation de l'objet B
 */

public class A {

    private B b;

    public A(B b){
        this.b = b;
    }
}

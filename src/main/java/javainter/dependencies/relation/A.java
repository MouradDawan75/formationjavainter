package javainter.dependencies.relation;

/*
Dépendence de type relation: la plus faible forme de dépendence -> limitée dans le temps
l'objet A utilise l'objet B de manière temporaire
réduite à l'exécution de la méthodA
 */
public class A {

    public A(){

    }

    public void methodA(B b){
        b.methodB();
    }
}

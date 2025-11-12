package javainter.dependencies.composition;

/*
Dépendence de type composition
- Un type appartient à un autre
- Ajout de la responsabilité de création
 */
public class A {

    private B b;

    private A(){
        //A doit savoir comment instancier B
        this.b = new B("sdsqdqsd");
    }

    public void methodA(){
        if(b == null){
            b = new B("sdqsd");
        }
        b.methodB();
    }
}

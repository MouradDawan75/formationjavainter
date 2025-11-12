package javainter.dependencies.heritage;

/*
Dépendence de type héritage: niveau de couplage plus fort
Pb: tout changement dans la classe mère aura un impact sur les classes filles
 */
public class B extends A{

    public B(int field) {
        super(field);
    }
}

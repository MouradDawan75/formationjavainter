package javainter;

@FunctionalInterface
public interface ICalcul {

    void add();
    //void multiply();
    default void m1() {};
    static  void m2(){};
}

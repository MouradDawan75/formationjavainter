package designspatterns.creation.factory;

public class Mobile implements Computer{
    @Override
    public void compute() {
        System.out.println(">>> mobile.....");
    }
}

package designspatterns.comportements.visitor2;

public interface VisitorGeneric<T,R> {
    R visit(T obj);
}

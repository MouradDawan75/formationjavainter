package designspatterns.comportements.observer;

/**
 * Interface qui décrit le rôle du Sujet dans le pattern obsever
 * @param <T>
 */
public interface Sujet<T> {

    //son rôle est de gérer une collection d'observers
    void attach(Observer<T> obs);
    void detach(Observer<T> obs);
    void notify(T obj);
}

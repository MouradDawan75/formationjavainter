package designspatterns.comportements.observer;

/**
 * Interface qui décrit le rôle de l'observer dans ce pattern
 * @param <T>
 */
public interface Observer<T> {
    void update(T obj);
}

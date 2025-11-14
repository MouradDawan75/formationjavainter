package designspatterns.comportements.state;

/**
 * Interface qui décrit le rôle du pattern State
 */
public interface CommandeState {

    void next(Commande cmd);
    void previous(Commande cmd);
    void printState();
}

package designspatterns.comportements.mediator;

/**
 * Interface qui décrit le rôle du pattern Mediator.
 * Doit connaitre tous les users et interactions possibles entre eux
 */
public interface IChatRoom {
    void addUser(Participant p);
    void sendMessage(String msg, String userId);
}

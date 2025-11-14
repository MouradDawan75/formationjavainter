package designspatterns.comportements.mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements IChatRoom{
    /*
    Doit connaitre tous les objets. Gère une collection d'objets
     */

    private Map<String, Participant> usersMap = new HashMap<>();

    @Override
    public void addUser(Participant p) {
        this.usersMap.put(p.getId(), p);
    }

    @Override
    public void sendMessage(String msg, String userId) {
        Participant p = usersMap.get(userId);
        p.receive(msg);
    }
}

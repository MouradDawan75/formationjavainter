package designspatterns.comportements.mediator;

public abstract class Participant {

    //tous les objets dépendent du Mediator
    private IChatRoom mediator;
    private String id;
    private String name;

    public abstract void send(String msg, String userId);
    public abstract void receive(String msg);

    public Participant(IChatRoom mediator, String id, String name) {
        this.mediator = mediator;
        this.id = id;
        this.name = name;
    }

    public IChatRoom getMediator() {
        return mediator;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

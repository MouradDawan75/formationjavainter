package designspatterns.comportements.mediator;

public class ChatUser extends Participant{

    public ChatUser(IChatRoom mediator, String id, String name) {
        super(mediator, id, name);
    }

    @Override
    public void send(String msg, String userId) {
        System.out.println(this.getName()+">>> Send message: "+msg);
        getMediator().sendMessage(msg, userId);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.getName()+" Received message: "+msg);
    }
}

package designspatterns.comportements.state;

public class CommandeRecue implements CommandeState{
    @Override
    public void next(Commande cmd) {
        System.out.println("Commande reçue par le client.....");
    }

    @Override
    public void previous(Commande cmd) {
        cmd.setState(new CommandePayee());
    }

    @Override
    public void printState() {
        System.out.println("confirmation de la réception de la commande.....");
    }
}

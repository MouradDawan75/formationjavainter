package designspatterns.comportements.state;

public class CommandePayee implements CommandeState{
    @Override
    public void next(Commande cmd) {
        cmd.setState(new CommandeRecue());
    }

    @Override
    public void previous(Commande cmd) {
        cmd.setState(new CommandePasse());
    }

    @Override
    public void printState() {
        System.out.println("Commande payée en cours de livraison.....");
    }
}

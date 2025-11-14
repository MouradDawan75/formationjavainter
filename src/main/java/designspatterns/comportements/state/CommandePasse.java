package designspatterns.comportements.state;

public class CommandePasse implements CommandeState{
    @Override
    public void next(Commande cmd) {
        cmd.setState(new CommandePayee());
    }

    @Override
    public void previous(Commande cmd) {
        System.out.println("Commande passée. Attente du paiement........");
    }

    @Override
    public void printState() {
        System.out.println("Commande validée, pas encore livrée.....");
    }
}

package designspatterns.comportements.state;

public class Commande {

     /*
    Etats d'une commande
    passée
    payée
    livrée
    reçue

    if(etat == "passée)

    else if(etat == "payée)

     */

    private CommandeState state = new CommandePasse(); //état initiale de la commande


    public void next() {
        state.next(this);
    }


    public void previous() {
        state.previous(this);
    }

    public void printState() {
        state.printState();
    }


    public CommandeState getState() {
        return state;
    }

    public void setState(CommandeState state) {
        this.state = state;
    }
}

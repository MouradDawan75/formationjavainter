package designspatterns.comportements.chainofresponsability;

/**
 * Classe qui décrit la chaine de responsabilité de ce pattern. Chaque objet possède un successeur et peut
 * soit traiter la demande, soit la soumettre à son supérieur
 */
public abstract class Staff {

    private String name;
    private Staff successor;

    public abstract void handleComplain(ComplainRequest request);

    public Staff(String name, Staff successor) {
        this.name = name;
        this.successor = successor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Staff getSuccessor() {
        return successor;
    }

    public void setSuccessor(Staff successor) {
        this.successor = successor;
    }
}

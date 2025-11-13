package designspatterns.comportements.chainofresponsability;

public class Director extends Staff {
    public Director(String name, Staff successor) {
        super(name, successor);
    }

    //Traite les demandes de type 3 et plus
    @Override
    public void handleComplain(ComplainRequest request) {
        System.out.println(request.getMessage()+" traité par le Directeur");
        request.setState(ComplaintState.CLOSED);
    }
}

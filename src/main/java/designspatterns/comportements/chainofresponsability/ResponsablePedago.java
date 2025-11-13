package designspatterns.comportements.chainofresponsability;

public class ResponsablePedago extends Staff {
    public ResponsablePedago(String name, Staff successor) {
        super(name, successor);
    }

    //Ne peut traiter que les demande de niveau 2
    @Override
    public void handleComplain(ComplainRequest request) {
        if(request.getComplaintType() == 2){
            System.out.println(request.getMessage()+ " req traitée par Responsable pedago.");
            request.setState(ComplaintState.CLOSED);
        }else {
            System.out.println("Request transmise au succésseur (directeur)");
            getSuccessor().handleComplain(request);
        }
    }
}

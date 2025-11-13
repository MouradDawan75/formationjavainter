package designspatterns.comportements.chainofresponsability;

public class Teacher extends Staff {

    public Teacher(String name, Staff successor) {
        super(name, successor);
    }

    //Ne peut traiter que les demandes de niveau 1
    @Override
    public void handleComplain(ComplainRequest request) {
        if(request.getComplaintType() == 1){
            System.out.println(request.getMessage()+ " req traitée par Teacher");
            request.setState(ComplaintState.CLOSED);
        }else {
            System.out.println("Request transmise au succésseur (responsabe pedago.)");
            getSuccessor().handleComplain(request);
        }
    }
}

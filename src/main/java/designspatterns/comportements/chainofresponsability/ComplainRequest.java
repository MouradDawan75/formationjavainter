package designspatterns.comportements.chainofresponsability;

public class ComplainRequest {

    private int studentNumero;
    private int complaintType; // 1: teacher - 2: reposnable pedago. 3: Directeur
    private String message;
    private ComplaintState state;

    public ComplainRequest(int studentNumero, int complaintType, String message, ComplaintState state) {
        this.studentNumero = studentNumero;
        this.complaintType = complaintType;
        this.message = message;
        this.state = state;
    }

    public int getStudentNumero() {
        return studentNumero;
    }

    public void setStudentNumero(int studentNumero) {
        this.studentNumero = studentNumero;
    }

    public int getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(int complaintType) {
        this.complaintType = complaintType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ComplaintState getState() {
        return state;
    }

    public void setState(ComplaintState state) {
        this.state = state;
    }
}

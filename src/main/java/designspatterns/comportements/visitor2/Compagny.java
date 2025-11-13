package designspatterns.comportements.visitor2;

public class Compagny implements Subject{

    private String name;
    private String mesureSecurity;
    private double profitability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMesureSecurity() {
        return mesureSecurity;
    }

    public void setMesureSecurity(String mesureSecurity) {
        this.mesureSecurity = mesureSecurity;
    }

    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    @Override
    public void accept(VisitorGeneric v) {
        v.visit(this);
    }
}

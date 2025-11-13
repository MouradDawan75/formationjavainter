package designspatterns.comportements.visitor2;

public class ProfitabilyInspector implements VisitorGeneric<Compagny, String >{
    @Override
    public String visit(Compagny obj) {
        if(obj.getProfitability() < 0.05){
            return "bad profitability";
        }
        return "good profitability";
    }
}

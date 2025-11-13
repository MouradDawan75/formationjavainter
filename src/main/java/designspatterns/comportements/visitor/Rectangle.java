package designspatterns.comportements.visitor;

public class Rectangle implements Forme{
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

//    public void ExportXml(){
//        // logic
//    }
}

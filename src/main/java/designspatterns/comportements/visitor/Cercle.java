package designspatterns.comportements.visitor;

public class Cercle implements Forme{
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

//    public void ExportXml(){
//        //logic
//    }
}

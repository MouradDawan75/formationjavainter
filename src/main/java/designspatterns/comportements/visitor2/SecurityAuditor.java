package designspatterns.comportements.visitor2;

public class SecurityAuditor implements VisitorGeneric<Compagny, SecurityReport>{
    @Override
    public SecurityReport visit(Compagny obj) {
        return new SecurityReport();
    }
}

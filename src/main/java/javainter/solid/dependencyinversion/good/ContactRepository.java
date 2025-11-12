package javainter.solid.dependencyinversion.good;

public class ContactRepository implements IContactRepository{
    @Override
    public Contact getById(int id) {
        return null;
    }
}

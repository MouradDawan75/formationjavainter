package javainter.solid.dependencyinversion.bad;

public class ContactService {



    public Object computeContact(int id){
        ContactRepository repo = new ContactRepository();
        Contact c = repo.getById(id);

        //appliquer un traitement au contact

        return "résultat";
    }
}

/*
Service complètement dépendant du Repository
Code sans dépendance
 */
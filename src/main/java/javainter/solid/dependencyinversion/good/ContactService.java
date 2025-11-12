package javainter.solid.dependencyinversion.good;

public class ContactService {


    private IContactRepository contactRepository;

    //option1: injection via le contructeur
    /*
    Avantage: Un objet service dans un état stable -> dépendance fournie
    Inconvénient: impossible de changer de dépendance
     */
    public ContactService(IContactRepository repo){
        contactRepository = repo;
    }

    public Object computeContact(int id){
        Contact c = contactRepository.getById(id);

        //traiter le contact

        return "résultat";
    }

    /*
    Option2: injection via le setter
    Avantage: possibilité de chager de dépendance
    Incovénient: contrainte -> il faut s'assurer que la dépendance à bien été injectée
     */

    public void setContactRepository(IContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactService(){

    }

    /*
    Option3: injection via les params de la méthodes
    Avantage: possibilité de changer de dépendance
    Inconvénient: dépéndance à fournir à chaque appelle de méthode
     */

    public Object computeContactOther(int id, IContactRepository repo){
        contactRepository = repo;
        Contact c = contactRepository.getById(id);

        return "résultat";
    }
}

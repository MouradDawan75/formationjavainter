package designspatterns.creation.builder;



public class Utilisateur {

    private String firstName; //required
    private String lastName; //required
    private int age;
    private String phone;
    private String adresse;

    //option1: la classe gère sa propre instanciation

//    public Utilisateur(String firstName, String lastName, int age, String phone, String adresse) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.phone = phone;
//        this.adresse = adresse;
//    }

    private Utilisateur(){

    }

    //Etape2: définir une méthode static qui donne accès à la classe static (+ d'eventuel attributs recquis)

    public static UtilisateurBuilder builder(String firstName, String lastName){
        return new UtilisateurBuilder(firstName, lastName);
    }


    //Etape1: définir une classe static interne pour gérer l'objet à construire
    // méthode pour chaque attribut
    public static class UtilisateurBuilder{

        private Utilisateur utilisateur;

        //gestion des attributs recquis
        public UtilisateurBuilder(String firstName, String lastName){
            utilisateur = new Utilisateur();
            utilisateur.firstName = firstName;
            utilisateur.lastName = lastName;
        }

        public UtilisateurBuilder withAge(int age){
            utilisateur.age = age;
            return this;
        }

        public UtilisateurBuilder withPhone(String phone){
            utilisateur.phone = phone;
            return this;
        }

        public UtilisateurBuilder withAdresse(String adresse){
            utilisateur.adresse = adresse;
            return this;
        }

        //méthode qui renvoie l'utilisateur construit

        public Utilisateur build(){
            return this.utilisateur;
        }

    }
}

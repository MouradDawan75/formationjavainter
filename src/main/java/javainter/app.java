package javainter;

import javainter.ddd.dtos.ImcDto;
import javainter.ddd.repositories.ImcRepositoryImpl;
import javainter.ddd.services.ImcService;
import javainter.ddd.services.ImcServiceImpl;
import javainter.ddd.services.MapperTool;
import javainter.ddd.valueobjects.Corpulance;
import javainter.heritage.Animal;
import javainter.heritage.Chat;
import javainter.heritage.Chien;
import javainter.heritage.Giraffe;
import javainter.solid.dependencyinversion.good.ContactFichierRepository;
import javainter.solid.dependencyinversion.good.ContactRepository;
import javainter.solid.dependencyinversion.good.ContactService;
import javainter.solid.liskovsubtitution.bad.Bicycle;
import javainter.solid.liskovsubtitution.bad.Car;
import javainter.solid.liskovsubtitution.bad.TransportationDevice;
import org.modelmapper.ModelMapper;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class Customer{
    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}

class CustomerDto{
    private String lastName;
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}

public class app {

    public static void main(String[] args) {

        /*
        Types de classes:
        - Classe objet: décrit la structure d'un objet
        - Classe service: propose principalement des méthodes
        - Interface: pseudo classe abstraite qui ne contient que des signatures de méthodes
        - Classe abstraite: définie une structure de base pour les autres classes: contient les éléments communs (attributs + méthodes)
         */

        Test x = new Test(); // le rôle d'un constructeur est d'initialiser tous les attributs de l'objet à construire

        //le constructeur sans params, affècte des valeurs par défaut aux attributs de l'objet à construire

        //Instancier une interface fonctionnelle (ne contenant qu'une seule méthode abstraite): ICalcul
        //Option1: utiliser une classe qui implèmente l'interface en question

        ICalcul ical1 = new Calcul();

        //Option2: utiliser une classe anonyme -> syntaxe très utilisée dans les Threads
        ICalcul ical2 = new ICalcul() {
            @Override
            public void add() {
                System.out.println("********");
            }
        };

        //Option3: utiliser une expression lambda -> méthode anonyme: (params) -> instructions; syntaxe très utilisée dans l'api stream
       ICalcul ical3 = () -> System.out.println("expression lambda....");

       //Option4: utiliser de méthode réference -> syntaxe très utilisée dans l'api stream

        // réferencer une méthode d'instance
        Test t = new Test();
        ICalcul ical4 = t::methodeInstance;

        // réferencer une méthode static (de classe)
        ICalcul ical5 = Test::methodeClasse;;

        /*
        Polymorphisme: c'est le fait qu'un objet puisse  prendre plusieurs formes.
        C'est une conséquence de l'héritage, c'est  l'objet parent qui peut prendre la forme de tous les objets enfants
         */

        //Intérêts: pouvoir définir des collections polymorphiques et des méthodes polymorphiques
        //Collection polymorphique:
        List<Animal> animaux = new ArrayList<>();
        animaux.add(new Chat());
        animaux.add(new Chien());
        animaux.add(new Giraffe());

        son(new Chat());
        son(new Chien());
        String s = "test";
        s.toLowerCase();

        List<A> lstA = new ArrayList<>();
        List<B> lstB = new ArrayList<>();
        List<C> lstAC= new ArrayList<>();

        List<MyInterface> myList = new ArrayList<>();

        /*
        Bonnes pratiques: les 5 principes SOLID
        S: Single Of Responsability
        O: open close - classe ouverte à l'extension, mais fermée à la modification
        L: Liskov Substitution: les objets enfants sont substituables aux objets parents
        I: Interface Segregation
        D: Dependency Inversion / Dependency Injection

        Tell don't ask: dites aux objets ce qu'ils doivent faire, ne leur posez pas de question sur leur état.
        Loi Demeter:
        Une classe ne doit interagir qu'avec les classes amies.
        Une méthode définie dans une classe:
        -peut utiliser ses propres params
        -peut utiliser ses variables locales ou les attributs de la classes
         */

        /*
        Liskov Subtitution: concerne l'héritage
        Si A se comporte comme B, alors A hérite de B
         */

        TransportationDevice device = new TransportationDevice();
        device.startEngine();

        device = new Car();
        device.startEngine();

        device = new Bicycle();
        device.startEngine(); // pas de moteur dans Bicycle

        //Dependency Inversion - Injection

        //option1: via constructeur
        ContactService contactService = new ContactService(new ContactRepository());
        contactService.computeContact(10);

        //Pour un autre répository:
        contactService = new ContactService(new ContactFichierRepository()); //nouvelle instance

        //option2: via setter
        ContactService setterContactService = new ContactService();
        setterContactService.setContactRepository(new ContactRepository());

        setterContactService.setContactRepository(new ContactFichierRepository()); //mm instance pour un autre répo

        //option3: via les params de la méthode
        ContactService paramContactService = new ContactService();

        paramContactService.computeContactOther(15, new ContactRepository());
        paramContactService.computeContactOther(15, new ContactFichierRepository()); //mm instance pour un autre répo

        /*
        Designs Patterns d'architecture: mvc,repository,service,dto,mvvm......
        DDD: Data Driven Design -> conception guidée par les données
        DDD: Domain Driven Design -> conception guidée par le métier
        Architecture Hexagonale -> guidée par le métier
        Architecture orientée service SOA -> Services Oriented Architecture
        Architecture back/front

        Web Service REST - Api REST -> est un style d'architecture -> utilise les méthode du protocole HTTP(Get,Post,Delete,Put)
         */

        //Démo Model Mapper: dépendence Maven

        ModelMapper mapper = new ModelMapper();

        Customer customer = new Customer();
        customer.setNom("DUPONT");
        customer.setPrenom("Jean");

        //Ajouter une règle de mapping:

        mapper.typeMap(Customer.class, CustomerDto.class)
                .addMappings(m -> {
                    m.map(src -> src.getNom(), CustomerDto::setLastName);
                    m.map(src -> src.getPrenom(), CustomerDto::setFirstName);
                });

        CustomerDto customerDto = mapper.map(customer, CustomerDto.class);


        System.out.println(customerDto);

        ImcService imcService = new ImcServiceImpl(new ImcRepositoryImpl());

        System.out.println("Votre taille (en mètres): ");
        Scanner sc = new Scanner(System.in);

        double height = sc.nextDouble();
        sc.nextLine();

        System.out.println("Votre poids: ");
        double weight = sc.nextDouble();

        Corpulance corpulance = new Corpulance(height, weight);
        ImcDto imcDto = imcService.compute(corpulance);

        System.out.println("Résultat: "+imcDto.getValue());
        System.out.println("Interprétation: ");
        System.out.println(imcDto.getInterpretation());
    }

    //polymorphisme par sous typage: le plus recommandé en pratique
    static void son(Animal a){
        a.emettreSon();
    }

    //polymorphisme ad-hoc: non recommandé en pratique -> nécessite un contrôle + un cast
    static void son1(Object o){
        if(o instanceof Animal) {
            Animal a = (Animal) o;
            a.emettreSon();
        }
    }

    //Polymorphisme par type générique
    static <T extends Animal> void son3(T t){
        t.emettreSon();
    }


    static void methodeA(A a){

    }

    static void methodeB(B b){

    }

    static void methodeC(C c){

    }

    static void myMthode(MyInterface m){

    }


}

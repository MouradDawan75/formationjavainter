package designspatterns;

import designspatterns.comportements.chainofresponsability.*;
import designspatterns.comportements.mediator.ChatRoom;
import designspatterns.comportements.mediator.ChatUser;
import designspatterns.comportements.mediator.IChatRoom;
import designspatterns.comportements.mediator.Participant;
import designspatterns.comportements.observer.Client;
import designspatterns.comportements.observer.Observer;
import designspatterns.comportements.observer.Produit;
import designspatterns.comportements.state.Commande;
import designspatterns.comportements.templatemethod.FacebookNetwork;
import designspatterns.comportements.templatemethod.NetworkTemplateMethod;
import designspatterns.comportements.templatemethod.TwitterNetwork;
import designspatterns.comportements.visitor.*;
import designspatterns.creation.factory.Computer;
import designspatterns.creation.factory.ComputerFactory;
import designspatterns.creation.factory.Laptop;
import designspatterns.creation.factory.Mobile;
import designspatterns.creation.prototype.Question;
import designspatterns.creation.prototype.Reponse;
import designspatterns.creation.singleton.Pdg;
import designspatterns.creation.builder.Utilisateur;
import designspatterns.structure.composite.CompositeDepartment;
import designspatterns.structure.composite.Depatement;
import designspatterns.structure.composite.FinancialDepartment;
import designspatterns.structure.composite.SalesDepartment;
import designspatterns.structure.facade.FacadeHelper;
import designspatterns.structure.facade.MySqlHelper;
import designspatterns.structure.facade.OracleHelper;
import designspatterns.structure.proxy.Internet;
import designspatterns.structure.proxy.ProxyInternet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class application {

    public static void main(String[] args) throws Exception {

        /*
        Besoins de la conception objet (bonnes pratiques):
        - Encapsuler des données sans en empêcher l'accès
        - Limiter les dépendance entre objets: héritage -> composition -> association -> relation
        - Concevoir des objets polyvalents, fléxibles, réutilisables (pratiquer le polymorphisme)


        Designs patterns: se sont des solutions standards mises en place par la communauté dans le but de résoudre des
        problèmes récurrents.

        - patterns de créations
        - patterns de comportements
        - patterns de structures

         */

        System.out.println(">>>>>>>>>>>>>>> Patterns de création:");
        //*********************Singleton
        /*
        Garantir l'existance d'une seule et unique instance d'une classe donnée dans toute l'application
         */

        System.out.println(">>> Singleton:");
        Pdg pdg1 = Pdg.getInstance("pdg1");
        Pdg pdg2 = Pdg.getInstance("pdg2");

        System.out.println(pdg1.getName());
        System.out.println(pdg2.getName());


        System.out.println(">>> Builder:");
        //builder: permet de simplifier la création d'objets complèxes (plusierus attributs)

        Utilisateur u = Utilisateur.builder("DUPONT", "jean").withAge(50).build();
        Utilisateur u1 = Utilisateur.builder("DUPONT", "jean").withPhone("06060606").build();

        System.out.println(">>> Factory:");
        /*
        A utiiser avec des objets liès (classe mère + classes filles)
        Factory (fabrique): classe qui va gérer le processus de création d'ojets
         */

        Computer laptop = ComputerFactory.getComputer(Laptop.class);

        Computer mobile = ComputerFactory.getComputer(Mobile.class);

        /*
        Inconvéniet:
        sa complexité de mise en place
         */

        System.out.println(">>> Prototype:");

        /*
        Création de copies d'objets complèxes à partir d'objets existants, sans faire la chose suivante:
        B.at1 = A.getAt1()
        B.at2 = A.getAt2()
         */
        int x = 10;
        int y = x;

        //pour les types simples: comme c'est des types valeurs, en mémoire se sont des copies qui seront générées
        //les types complèxes sont des types réference, comment obtenir une copie d'un type complèxe

        Reponse rep1 = new Reponse("response1", true);
        Reponse rep2 = (Reponse) rep1.clone();
        //rep2.setTexte(rep1.getTexte());

        rep1.setTexte("new reponse");

        System.out.println(rep2.getTexte());

        //Copie d'une Question

        Question qst1 = new Question("comment cloner un objet?");
        qst1.getReponses().add(new Reponse("Implementer l'interface cloneable", true));
        qst1.getReponses().add(new Reponse("Implementer l'interface copie", false));

        Question qst2 = (Question) qst1.clone();

        qst1.setTexte("new questions1");
        qst1.getReponses().get(0).setTexte("new reponse pour qst1");

        System.out.println(qst2.getTexte());
        System.out.println(qst2.getReponses().get(0).getTexte());

        System.out.println(">>>>>>>>>>>>>>> Patterns de comportement:");
        /*
        Très pratique dans une conception basée sur le métier (DDD - Hexagonale)
        permettent de décrire:
        - des algorithmes
        - des comportements entre les objets
        - des formes de communications entre les objets
        - d'assigner des responsabilités aux objets pour définir leur comportement
         */

        System.out.println(">>>> chain of responsability:");
        /*
        Pour le mettre en place, if faut avoir une hierarchie d'objets avec un traitement que tous les objets peuvent exécuter.
        Permet de faire circuler une info dans une chaine d'objets. Chaque objet dans cette chaine, peut soit exécuter le traitement
        en question, soit le soumettre à l'objet supérieur
         */

        Teacher teacher = new Teacher("Teacher", new ResponsablePedago("Responsabe Pedago.", new Director("Directeur", null)));
        teacher.handleComplain(new ComplainRequest(125, 1, "Req1", ComplaintState.OPENED));
        teacher.handleComplain(new ComplainRequest(666, 2, "Req2", ComplaintState.OPENED));
        teacher.handleComplain(new ComplainRequest(777, 3, "Req3", ComplaintState.OPENED));

        System.out.println(">>>> Observer:");
        /*
        permet de mettre en place un mécanisme de souscription pour envoyer des notifications à des objets
        concernant des évenements qu'ils observent.
        2 objets participent à un tel système:
        Subject( Publisher ): déclenche l'envoi d'une notification
        Observer (Subscriber):  l'objet qui reçoit la notif.....
         */
        Produit prod = new Produit("PC Dell", 1999);
        Observer<Double> obs1 = new Client("Jean");
        Observer<Double> obs2 = new Client("Marie");

        prod.attach(obs1);
        prod.attach(obs2);

        prod.setPrix(1200); // ce changement déclenche l'envoi de 2 notifications

        System.out.println(">>>> Visitor:");

        /*
        Pour le mettre en place, il faut avoir des objets qui partagent le mm traitement, mais qui diffère selon le type de l'objet
        Permet de séparer les algorithmes et les objets sur lesquels ils opèrent
         */

        List<Forme> formes = new ArrayList<>();
        formes.add(new Rectangle());
        formes.add(new Cercle());

        formes.forEach(f -> new ExportXmlVisitor());
        formes.forEach(f -> new ExportJsonVisitor());

        System.out.println(">>>> State:");

        /*
        A utiliser lorsque le comportement d'un objet varie selon son état.
        Concerne principalement un objet qui peut plusieurs états connus d'avance.

        State propose d'extraire tout le code lié aux états de l'objet et de le mettre
        dans des classes distinctes.

        Créer une classe pour chaque état de l'objet

        Possibilité d'ajouter de nouveaux états -> code ouvert à 'extension, mais fermé à la modification

        Ex: Commande:  passée - payée - livrée - reçue
         */

        Commande cmd = new Commande();
        cmd.printState();
        cmd.next();
        cmd.printState();
        cmd.next();
        cmd.printState();
        cmd.next();
        cmd.printState();

        System.out.println(">>>> Template Method:");

        /*
        A mettre en place lorsque:
        des classes contiennent beaucoup de code similaire.
        Bien que le code est complètement différent d'une classe à une autre, la structure de base reste la mm (mm algorithme)

        Ce pattern permet de mettre en place le squelette d'un algorithme dans une classe mére et laisser les classes filles
        redéfinir certaines étapes de l'algorithme sans changer la structure

        Pattern qui propose de découper un algorithme en plusieurs étapes, de transformer chaque étape en méthode,
        ensuite de les regrouper l'ensemble des étapes dans une seule méthode appelée Template Method.

        Seule méthode appelée dans le code

        Ex: Envoi d'un message via les réseaux sociaux: login - send message - logout
        Beaucoup de traitements similaires dans les réseaux sociaux


         */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        NetworkTemplateMethod network = null;
        System.out.println("Input user name: ");
        String userName = reader.readLine();
        System.out.println("Input password: ");
        String password = reader.readLine();

        //Message to send
        System.out.println("Message to send: ");
        String message = reader.readLine();

        //type text block: pratique pour les chaines multilignes
        System.out.println("""
                Choose social network:
                1- Facebook
                2- Twitter
                """);

        int choice = Integer.parseInt(reader.readLine());
        if(choice == 1){
            network = new FacebookNetwork(userName,password);
        }else{
            network = new TwitterNetwork(userName, password);
        }

        //appel de template method
        network.post(message);

        /*
        Sans template method
        network.login()
        network.sendMessage()
        network.logout()
         */

        reader.close();

        System.out.println(">>>> Mediator:");
        /*
        Permet de réduire les dépendences entre les objets
        permet de restreindre les communications directes entre les différents objets et de les forcer
        à collaborer uniquement via un objet intermédiaire.

        Mediator doit connaitre tous les objets et toutes es interactions possibles entre ces objets.
        Au final les objets vont dépendrent du Mediator
        Ex: piste d'attérissage (tour de contrôle joue le rôle d'un médiateur) - les salons de chat
         */

        IChatRoom chatRoom = new ChatRoom();
        Participant p1 = new ChatUser(chatRoom, "1", "Jean");
        Participant p2 = new ChatUser(chatRoom, "2", "Claire");

        chatRoom.addUser(p1);
        chatRoom.addUser(p2);

        p1.send("Hello", "2");
        p2.send("Bonjour", "1");


        System.out.println(">>>>>>>>>>>>>>> Patterns de structure:");
        /*
        Appelés aussi patterns de composition
        Pratique lors d'une conception basée sur l'interaction.
        Les modèles d'interactions montrent l'interaction du composant en cours de dév. et d'autres systèmes externes (api.bd...)
        La modélisation de système à système mets en évidence les problèmes de communication qui peuvent subvenir.
        Proxy, bridge, facade decorator, composite
         */

        System.out.println(">>>>>>>>>>>>>>> Proxy:");
        /*
        Permet de fournir un substitut d'un objet.
        Un proxy vous donne le contrôle sur l'objet original vous permettant d'effectuer des traitement dessus avant ou après que la demande
        ne lui parvienne.

        Dans le code, un Proxy est une copie de l'objet original. Les 2 partagent la mm structure
         */

        Internet internet = new ProxyInternet();

        try{
            internet.connectTo("dawan.fr");
            internet.connectTo("123.com");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(">>>>>>>>>>>>>>> Bridge:");
        /*
        Permet de définir une sorte de pont entre différents systèmes externes fournissants le mm type de contenu
         */

        System.out.println(">>>>>>>>>>>>>>> Facade:");
        /*
        propose un accès simplifié à un ensemble de classes complèxes
        Ex: application qui appelle une BD distante (MySql, Oracle) et génère des rapports PDF et HTML.

        Il propose en sortie des méthodes répondants aux besoins métiers
         */

        //Sans Facade
        System.out.println(">>Sans facade:");
        String tableName = "employes";
        Connection cnx = MySqlHelper.getMySqlConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHtmlReport(tableName, cnx);
        mySqlHelper.generateMySqlPdfReport(tableName, cnx);

        Connection cnx2 = OracleHelper.getOracleConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOracleHtmlReport(tableName, cnx2);
        oracleHelper.generateOraclePdfReport(tableName, cnx2);

        //Avec Facade
        System.out.println(">>Avec facade:");
        FacadeHelper.generateReport(FacadeHelper.DbType.ORACLE, FacadeHelper.ReportType.HTML, tableName);
        FacadeHelper.generateReport(FacadeHelper.DbType.ORACLE, FacadeHelper.ReportType.PDF, tableName);
        FacadeHelper.generateReport(FacadeHelper.DbType.MYSQL, FacadeHelper.ReportType.HTML, tableName);
        FacadeHelper.generateReport(FacadeHelper.DbType.MYSQL, FacadeHelper.ReportType.PDF, tableName);

        System.out.println(">>>>>>>>>>>>>>> Composite:");
        /*
        Soit manipuler des objets individuellement
        soit manipuler une composition d'objets (possèdant un lien)
         */

        //Manipuler les objets individuelement:
        Depatement salesDeprtment = new SalesDepartment();
        Depatement financialDepartment = new FinancialDepartment();

        salesDeprtment.printDepatementName();
        financialDepartment.printDepatementName();

        //objets liés par la la méthode printDepatementName

        //Manipuler une composition d'objets

        CompositeDepartment compositeDepartment = new CompositeDepartment();
        compositeDepartment.addDepartement(salesDeprtment);
        compositeDepartment.addDepartement(financialDepartment);
        compositeDepartment.printDepatementName();




    }
}

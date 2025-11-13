package designspatterns;

import designspatterns.creation.factory.Computer;
import designspatterns.creation.factory.ComputerFactory;
import designspatterns.creation.factory.Laptop;
import designspatterns.creation.factory.Mobile;
import designspatterns.creation.prototype.Question;
import designspatterns.creation.prototype.Reponse;
import designspatterns.creation.singleton.Pdg;
import designspatterns.creation.builder.Utilisateur;

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

        System.out.println(">>>>>>>>>>>>>>> Pattern de création:");
        //*********************Singleton

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

    }
}

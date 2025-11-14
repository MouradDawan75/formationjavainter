package designspatterns.comportements.templatemethod;

/**
 * Classe qui décrit e rôle du pattern Template Method
 */
public abstract class NetworkTemplateMethod {

    String userName;
    String password;

    public NetworkTemplateMethod(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    /*
    Etapes de l'algorithme pour l'envoi d'un message
     */

    abstract boolean login(String userName, String password);
    abstract boolean sendMessage(byte[] data);
    abstract void logout();

    /*
    Template Method: qui regroupe toutes les étapes et qui déclenche leur appelle
    Seule méthode appelée dans le code
     */

    public boolean post(String message){

        //Appel de login
        if(login(this.userName, this.password)){

            //appel de sendMessage
            boolean result =  sendMessage(message.getBytes());

            //appel de logout
            logout();

            return result;
        }

        return false;
    }
}

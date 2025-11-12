package javainter;
import java.beans.XMLEncoder;

public class Test {

    //x est une variable de classe, pas besoin de l'initialiser car elle possède une valeur par défaut
    /*
    types numériques: 0
    types complèxes: null
    type boolean: false
     */

    int x;

    public void methodeInstance(){
        //y est une variabe locale qui doit être initialisée
        int y = 0;
    }

    public static void methodeClasse(){

    }

    public static boolean checkPassword(String pass){
        return false;
    }
}

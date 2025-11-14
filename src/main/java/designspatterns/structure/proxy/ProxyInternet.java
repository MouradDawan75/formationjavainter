package designspatterns.structure.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet{

    //Un proxy donne le contrôle sur l'objet original
    private Internet internet = new RealInternet();

    private static List<String> bannedSites;

    //bloc d'initialisation static -> appelé avant le constructeur de la classe
    static{
        bannedSites = new ArrayList<>();
        bannedSites.add("abc.com");
        bannedSites.add("123.com");
        bannedSites.add("azerty.com");
    }

    @Override
    public void connectTo(String url) throws Exception {
        if(bannedSites.contains(url)){
            throw  new Exception("Access denied.....");
        }
        internet.connectTo(url);
    }
}

package designspatterns.creation.singleton;

public class Pdg {

    private String name;
    private static Pdg instance;


    private Pdg(){

    }

    public static Pdg getInstance(String name){

        if(instance == null){
            instance = new Pdg();
        }
        instance.name = name;
        return instance;
    }

    public String getName() {
        return name;
    }
}

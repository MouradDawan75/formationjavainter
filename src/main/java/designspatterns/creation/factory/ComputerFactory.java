package designspatterns.creation.factory;

public class ComputerFactory {

    //méthode ne respectant pas le open/close
    public Computer getComputer(String computer){
        if(computer.equalsIgnoreCase("laptop")){
            return new Laptop();
        } else if (computer.equalsIgnoreCase("mobile")) {
            return new Mobile();
        }

        return null;
    }

    public static Computer getComputer(Class<? extends Computer> clazz) throws Exception {
        return clazz.getDeclaredConstructor().newInstance(); //appel du constructeur sans params
    }
}

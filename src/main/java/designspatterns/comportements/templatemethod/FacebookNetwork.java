package designspatterns.comportements.templatemethod;

public class FacebookNetwork extends NetworkTemplateMethod{


    public FacebookNetwork(String userName, String password) {
        super(userName, password);
    }

    @Override
    boolean login(String userName, String password) {
        System.out.println("Check user parameters");
        System.out.println("Name: "+this.userName);
        System.out.println("Password: ");
        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }

        simulateLatency();

        System.out.println("Login success on Facebook.....");


        return true;
    }



    @Override
    boolean sendMessage(byte[] data) {
        boolean messageSend = true;
        if(messageSend){
            System.out.println("message: "+new String(data)+" was posted on Facebook....");
            return true;
        }
        return false;
    }

    @Override
    void logout() {
        System.out.println("User: "+userName+" was logged out from Facebook");
    }

    private void simulateLatency() {

        int i = 0;
        System.out.println();
        while (i < 10){
            System.out.print(".");
            try {
                Thread.sleep(500);
                i++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

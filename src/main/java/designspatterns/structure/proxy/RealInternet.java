package designspatterns.structure.proxy;

public class RealInternet implements Internet{
    @Override
    public void connectTo(String url) throws Exception {
        System.out.println("Connect to: "+url);
    }
}

package javainter.solid.liskovsubtitution.good;

public class TransportationDeviceWithEngine extends TransportationDevice{
    private Engine engine;


    @Override
    public void startMoving() {
        //start engine
    }
}

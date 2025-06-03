import strategy.XyzDriveStrategy;

public class XyzVehicle extends Vehicle {
    XyzVehicle() {
        super(new XyzDriveStrategy());
    }
    
}

class Main{
    public static void main(String[] args) {
        Vehicle sportsCar = new NormalVehicle();
        Vehicle normalCar = new SportsVehicle();
        Vehicle xyzCar = new XyzVehicle();

        sportsCar.drive();
        normalCar.drive();
        xyzCar.drive();
    }}
class Main{
    public static void main(String[] args) {
        Vehicle sportsCar = new NormalVehicle();
        Vehicle normalCar = new SportsVehicle();

        sportsCar.drive();
        normalCar.drive();
    }}
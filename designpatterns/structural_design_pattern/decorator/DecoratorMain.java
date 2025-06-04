package designpatterns.structural_design_pattern.decorator;

public class DecoratorMain {
    public static void main(String[] args) {
      Coffee coffee = new SugarDecorator(new MilkDecorator(new BasicCoffee()));

      System.out.println(coffee.getDescription()); // Basic Coffee, Milk, Sugar
      System.out.println("Cost: $" + coffee.cost()); // Cost: $6.5  
    }
}

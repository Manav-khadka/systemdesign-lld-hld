# systemdesign-lld-hld

## Table of Contents

1. [SOLID Principles](#solid-principles)
2. [Design Patterns](#design-patterns)
    - [Creational Patterns](#creational-patterns)
    - [Structural Patterns](#structural-patterns)
        - [Decorator Pattern](#decorator-pattern)
    - [Behavioral Patterns](#behavioral-patterns)
        - [Strategy Pattern](#strategy-pattern)
        - [Observer Pattern](#observer-pattern)

---

## SOLID Principles {#solid-principles}

SOLID is an acronym for five design principles intended to make software designs more understandable, flexible, and maintainable.

### S - Single Responsibility Principle

A class should have only one reason to change, meaning it should have only one responsibility or job.

**Example:** Instead of having a class that handles both user data and authentication, split them into separate classes:
- `UserRepository` - manages user data
- `AuthenticationService` - handles authentication logic

### O - Open/Closed Principle

Software entities should be open for extension but closed for modification.

**Example:** Use interfaces and inheritance to allow adding new functionality without changing existing code:
```java
interface PaymentProcessor {
    void processPayment(Payment payment);
}

class CreditCardProcessor implements PaymentProcessor { ... }
class PayPalProcessor implements PaymentProcessor { ... }
// New payment methods can be added without modifying existing code
```

### L - Liskov Substitution Principle

Objects of a superclass should be replaceable with objects of subclasses without affecting program correctness.

**Example:** If a method accepts a `Bird` type, any subclass like `Sparrow` or `Penguin` should work correctly without requiring the method to check the specific type.

### I - Interface Segregation Principle

Clients should not be forced to depend on interfaces they do not use.

**Example:** Instead of one large interface:
```java
interface Worker {
    void work();
    void eat();
    void sleep();
}
```
Create smaller, focused interfaces:
```java
interface Workable { void work(); }
interface Eatable { void eat(); }
interface Sleepable { void sleep(); }
```

### D - Dependency Inversion Principle

High-level modules should not depend on low-level modules. Both should depend on abstractions.

**Example:** Instead of:
```java
class OrderService {
    private MySQLDatabase database;
    // Direct dependency on concrete implementation
}
```

Use:
```java
class OrderService {
    private DatabaseInterface database;
    // Depends on abstraction, not implementation
}
```

---

## Design Patterns {#design-patterns}

### Creational Patterns {#creational-patterns}
*Coming soon...*

### Structural Patterns {#structural-patterns}

#### Decorator Pattern {#decorator-pattern}

The Decorator Pattern allows you to add new functionality to objects dynamically without altering their structure. It is useful for adhering to the Open/Closed Principle and for composing behaviors at runtime.

**Example from codebase:**  
Located in [`designpatterns/structural_design_pattern/decorator/`](designpatterns/structural_design_pattern/decorator/)

- `Coffee` interface defines the contract for coffee objects.
- `BasicCoffee` is a concrete implementation of `Coffee`.
- `CoffeeDecorator` is an abstract class that implements `Coffee` and wraps another `Coffee` object.
- `MilkDecorator` and `SugarDecorator` are concrete decorators that add milk and sugar functionality.

**Sample usage:**
```java
Coffee coffee = new SugarDecorator(new MilkDecorator(new BasicCoffee()));
System.out.println(coffee.getDescription()); // Basic Coffee, Milk, Sugar
System.out.println("Cost: $" + coffee.cost()); // Cost: $6.5
```

### Behavioral Patterns {#behavioral-patterns}

#### Strategy Pattern {#strategy-pattern}

The Strategy Pattern is used to define a family of algorithms, encapsulate each one, and make them interchangeable. It lets the algorithm vary independently from clients that use it.

**Example from codebase:**  
Located in [`designpatterns/behavioral_design_pattern/strategy/`](designpatterns/behavioral_design_pattern/strategy/)

- `Vehicle` class uses a `DriveStrategy` interface to allow different driving behaviors.
- Concrete strategies: `NormalDriveStrategy`, `SportsDriveStrategy`, `XyzDriveStrategy`.
- Vehicles like `NormalVehicle`, `SportsVehicle`, and `XyzVehicle` use different strategies.

**Sample usage:**
```java
Vehicle sportsCar = new SportsVehicle();
sportsCar.drive(); // Output: Driving in sports mode.

Vehicle normalCar = new NormalVehicle();
normalCar.drive(); // Output: Driving normally.
```

#### Observer Pattern {#observer-pattern}

The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

**Example from codebase:**  
Located in [`designpatterns/behavioral_design_pattern/observer/`](designpatterns/behavioral_design_pattern/observer/)

- `StockObservable` interface and its implementation `IphoneObservableImpl` manage stock and observers.
- Observers like `EmailAlertObserverImpl` and `MobileAlertObserverImpl` get notified when stock changes.

**Sample usage:**
```java
IphoneObservableImpl iphoneObservable = new IphoneObservableImpl();
NotificationAlertObserver emailObserver = new EmailAlertObserverImpl("test@example.com", iphoneObservable);
NotificationAlertObserver mobileObserver = new MobileAlertObserverImpl("1234567890", iphoneObservable);

iphoneObservable.addObserver(emailObserver);
iphoneObservable.addObserver(mobileObserver);

iphoneObservable.setStockCount(10); // Notifies all observers
```

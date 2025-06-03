# systemdesign-lld-hld
## Table of Contents

1. [SOLID Principles](#solid-principles)
    - [Single Responsibility Principle (S)](#s---single-responsibility-principle)
    - [Open/Closed Principle (O)](#o---openclosed-principle)
    - [Liskov Substitution Principle (L)](#l---liskov-substitution-principle)
    - [Interface Segregation Principle (I)](#i---interface-segregation-principle)
    - [Dependency Inversion Principle (D)](#d---dependency-inversion-principle)
<!-- 2. [High-Level Design (HLD)](#high-level-design-hld)
3. [Low-Level Design (LLD)](#low-level-design-lld)
4. [Design Patterns](#design-patterns)
    - [Creational Patterns](#creational-patterns)
    - [Structural Patterns](#structural-patterns)
    - [Behavioral Patterns](#behavioral-patterns)
5. [System Design Concepts](#system-design-concepts)
    - [Scalability](#scalability)
    - [Reliability](#reliability)
    - [Availability](#availability)
    - [Performance](#performance)
6. [Architecture Styles](#architecture-styles)
    - [Monolithic](#monolithic)
    - [Microservices](#microservices)
    - [Event-Driven](#event-driven)
    - [Serverless](#serverless)
7. [Case Studies](#case-studies) -->



## SOLID Principles

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

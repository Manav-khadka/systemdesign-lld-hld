package observer;

import observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    private String email;
    StockObservable stockObservable;

    public EmailAlertObserverImpl(String email, StockObservable stockObservable) {
        this.email = email;
        this.stockObservable = stockObservable;
    }
    @Override
    public void update() {
        sendMessage("Stock is available now. Please check your email: " + email);
       }

    private void sendMessage(String string) {
        // Simulating sending an email
        System.out.println("Sending email to " + email + ": " + string);
    }
    
}

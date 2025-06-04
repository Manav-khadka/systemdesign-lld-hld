package observer;

import observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    private String mobileNumber;
    private StockObservable stockObservable;

    public MobileAlertObserverImpl(String mobileNumber, StockObservable stockObservable) {
        this.mobileNumber = mobileNumber;
        this.stockObservable = stockObservable;
    }
    @Override
    public void update() {
        sendMessage("Stock is available now. Please check your mobile: " + mobileNumber);
    }

    private void sendMessage(String string) {
        // Simulating sending a mobile alert
        System.out.println("Sending mobile alert to " + mobileNumber + ": " + string);
    }

}

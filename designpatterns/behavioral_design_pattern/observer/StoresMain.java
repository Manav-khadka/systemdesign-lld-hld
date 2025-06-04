import observable.IphoneObservableImpl;
import observer.NotificationAlertObserver;

public class StoresMain {
    public static void main(String[] args) {
        IphoneObservableImpl iphoneObservable = new IphoneObservableImpl();
        NotificationAlertObserver emailObserver = new observer.EmailAlertObserverImpl("test@example.com", iphoneObservable);
        NotificationAlertObserver mobileObserver = new observer.MobileAlertObserverImpl("1234567890", iphoneObservable);
        iphoneObservable.addObserver(emailObserver);
        iphoneObservable.addObserver(mobileObserver);
        iphoneObservable.setStockCount(10);
        iphoneObservable.setStockCount(0);
        iphoneObservable.setStockCount(5);  
        iphoneObservable.setStockCount(0);
        iphoneObservable.setStockCount(0);}
}
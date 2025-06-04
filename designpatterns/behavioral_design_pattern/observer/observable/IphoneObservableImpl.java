package observable;

import java.util.ArrayList;
import java.util.List;

import observer.NotificationAlertObserver;

public class IphoneObservableImpl implements StockObservable{

    public int stockCount = 0;
    public List<NotificationAlertObserver> observers = new ArrayList<>();


    @Override
    public void addObserver(NotificationAlertObserver observer) {
       observers.add(observer);
    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (NotificationAlertObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int stockCount) {
        System.out.println("Current Stock Count: " + this.stockCount + ", New Stock Count: " + stockCount);
       if(this.stockCount==0 && stockCount > 0) {
        this.stockCount = stockCount;
        notifyObservers();
       }
       this.stockCount = stockCount;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
    
    
}

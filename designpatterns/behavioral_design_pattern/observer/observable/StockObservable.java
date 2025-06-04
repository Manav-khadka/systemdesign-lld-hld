package observable;

import observer.NotificationAlertObserver;

public interface StockObservable {
    
    public void addObserver(NotificationAlertObserver observer);

    public void removeObserver(NotificationAlertObserver observer);

    public void notifyObservers();

    public void setStockCount(int stockCount);

    public int getStockCount();
    
}

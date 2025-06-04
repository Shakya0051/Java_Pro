public class OnlineShoppingApp {
    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();

        Thread customerThread = new Thread(() -> {
            store.placeOrder();
        });

       
        Thread sellerThread = new Thread(() -> {
            try {
                Thread.sleep(3000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            store.restockItem();
        });

        customerThread.start();
        sellerThread.start();
    }
}


class OnlineStore {
    private boolean itemAvailable = false;

    
    public synchronized void placeOrder() {
        System.out.println("Customer: Placing order...");

        while (!itemAvailable) {
            System.out.println("Customer: Item not available, waiting for seller to restock...");
            try {
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Customer: Order processed successfully!");
        itemAvailable = false; 
    }

    
    public synchronized void restockItem() {
        System.out.println("Seller: Restocking item...");
        itemAvailable = true;
        System.out.println("Seller: Item restocked. Notifying customer...");
        notify(); 
    }
}


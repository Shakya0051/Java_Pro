class BankAccount {
    private int balance = 1000;

   
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is trying to withdraw $" + amount);

        while (balance < amount) {
            System.out.println("Not enough balance. Waiting for deposit...");
            try {
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " successfully withdrew $" + amount + ". Remaining balance: $" + balance);
    }

   
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing $" + amount);
        balance += amount;
        System.out.println("New balance: $" + balance);
        notify(); 
    }
}


public class Banking {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            account.withdraw(1500);
        }, "Thread-Withdraw");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.deposit(1000);
        }, "Thread-Deposit");

        t1.start();
        t2.start();
    }
}

    

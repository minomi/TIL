package sync;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 27..
 */

class Calculator {
    private int memory;

    public void setMemory(int memory) {
        synchronized (this) {
            this.memory = memory;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }

    public void anotherSyncBlock() {
        synchronized (this) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }
    }

}

class User extends Thread {
    private Calculator calculator;
    private int number;

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(number);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        User user1 = new User();
        user1.setNumber(100);
        user1.setName("User1");
        user1.setCalculator(calculator);
        user1.start();

        User user2 = new User();
        user2.setNumber(20);
        user2.setName("User2");
        user2.setCalculator(calculator);
        user2.start();

        calculator.anotherSyncBlock();
    }
}

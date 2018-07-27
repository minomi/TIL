package api;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 27..
 */

class SumThread extends Thread {
    private long sum;

    @Override
    public void run() {
        for (int i = 1 ; i <= 100 ; i++) {
            sum += i;
        }
    }

    public long getSum() {
        return sum;
    }
}

public class JoinExam {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("1 ~ 100 까지 합 : " + sumThread.getSum());
    }
}

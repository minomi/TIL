package beep;

import java.awt.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 27..
 */

class Beep {
    void start(int interval) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0 ; i < 5 ; i++) {
            toolkit.beep();
            try { Thread.sleep(interval); }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// 1. Runnable Interface 구현
class BeepTask implements Runnable {

    @Override
    public void run() {
        Beep beep = new Beep();
        beep.start(300);
    }
}

// 2. Thread class 상속
class BeepThread extends Thread {
    @Override
    public void run() {
        Beep beep = new Beep();
        beep.start(400);
    }
}

public class BeepPrintExam {

    public static void main(String[] args) {
        Runnable beepTask = new BeepTask();
        Thread beepThread1 = new Thread(beepTask);
        Thread beepThread2 = new BeepThread();
        // 3. Lambda 식 이용
        Thread beepThread3 = new Thread(() -> {
            Beep beep = new Beep();
            beep.start(500);
        });

        beepThread1.start();
        beepThread2.start();
        beepThread3.start();

        for(int i = 0 ; i < 5 ; i++) {
            System.out.println("띵");
            try {Thread.sleep(500);}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

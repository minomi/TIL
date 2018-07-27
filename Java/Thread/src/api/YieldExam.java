package api;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 27..
 */

class YieldThread extends Thread {
    public boolean isStop = false;
    public boolean isWorking = true;

    @Override
    public void run() {
        while (!isStop) {
            if (isWorking) {
                System.out.println(Thread.currentThread().getName() + "작업 중");
            } else {
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "작업 종료");
    }
}

public class YieldExam {
    public static void main(String[] args) {
        YieldThread threadA = new YieldThread();
        YieldThread threadB = new YieldThread();

        threadA.setName("ThreadA");
        threadB.setName("ThreadB");

        threadA.start();
        threadB.start();
        // A, B 같이 실행

        try { Thread.sleep(100); } catch (Exception e) {e.printStackTrace();}
        threadA.isWorking = false; // B 만 실행
        try { Thread.sleep(100); } catch (Exception e) {e.printStackTrace();}
        threadA.isWorking = true; // A, B 같이 실행
        try { Thread.sleep(100); } catch (Exception e) {e.printStackTrace();}
        threadA.isStop = true;
        threadB.isStop = true;
        // A, B 종료
    }

}

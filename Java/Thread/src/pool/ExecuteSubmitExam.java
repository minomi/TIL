package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 28..
 */
public class ExecuteSubmitExam {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0 ; i < 10 ; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("[총 스레드 개수 : " + poolSize + "] 작업 스레드 이름 : " + threadName);
                    int value = Integer.parseInt("삼"); // 예외 발생
                }
            };

//            executorService.execute(runnable);
            executorService.submit(runnable);
            Thread.sleep(10);
        }

        executorService.shutdown();
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 1..
 */
public class ParallelExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("홍길동", "신용권", "김자바", "람다식", "박병철");

        list.stream().forEach(ParallelExample::print);
        list.parallelStream().forEach(ParallelExample::print);

    }

    public static void print(String str) {
        System.out.println(str + " : " + Thread.currentThread().getName());
    }

}

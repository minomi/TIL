import java.util.Arrays;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 3..
 */
public class FilteringExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("홍길동", "신용권", "김자바", "신용권", "신민철");
        names.stream().distinct().forEach(n -> System.out.println(n));
        System.out.println();
        names.stream().filter(n -> n.startsWith("신")).forEach(n -> System.out.println(n));
    }
}

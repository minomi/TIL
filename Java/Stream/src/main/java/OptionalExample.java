import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 3..
 */
public class OptionalExample {

    public static void main(String[] args ) {
        List<Integer> list = new ArrayList<>();

//        double avg = list.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .getAsDouble();
//
        OptionalDouble optionalDouble = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        if (optionalDouble.isPresent()) {
            System.out.println("avg : " + optionalDouble.getAsDouble());
        } else {
            System.out.println("avg : 0.0 ");
        }

        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("avg : " + avg);

        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a -> System.out.println("avg : " + a));

    }

}

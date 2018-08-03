import java.util.Arrays;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 8. 3..
 */
public class FlatMapExample {
    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("java8 lambda", "stream mapping");

        // 단어 뽑기
        inputList.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));

        System.out.println();

        inputList = Arrays.asList("10, 20, 30", "40, 50, 60");

        //숫자로 나타내기
        inputList.stream()
                .flatMapToInt(data -> {
                  String[] strArr = data.split(",");
                  int[] intArr = new int[strArr.length];
                  for (int i = 0 ; i < strArr.length ; i++) {
                      intArr[i] = Integer.parseInt(strArr[i].trim());
                  }
                  return Arrays.stream(intArr);
                })
                .forEach(number -> System.out.println(number));

    }
}

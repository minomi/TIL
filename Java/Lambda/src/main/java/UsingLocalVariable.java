/**
 * IDE : IntelliJ IDEA
 * Created by minho on 03/11/2018.
 */
public class UsingLocalVariable {
    void method(final int arg) {
        int localVar = 40;

        MyFunctionalInterface fi = () -> {
            int ar = 2;
            System.out.println(++ar);
//            arg++;
//            localVar++;
        };

        fi.method();
        System.out.println(arg);
    }

    public static void main(String[] args) {
        UsingLocalVariable ulv = new UsingLocalVariable();
        ulv.method(40);
        Runnable runnable = () -> {
            int a = 2;
            System.out.println(a);
        };
        new Thread(runnable).start();
    }
}

import javax.activation.MailcapCommandMap;
import java.util.ArrayList;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 04/11/2018.
 */
public class MaleStudents {
    private List<Student> list;

    public MaleStudents() {
        this.list = new ArrayList<>();
        System.out.println(Thread.currentThread().getName() + " new");
    }

    public void accumulate(Student student) {
        list.add(student);
        System.out.println(Thread.currentThread().getName() + " accumulate");
    }

    public void combine(MaleStudents maleStudents) {
        list.addAll(maleStudents.getList());
        System.out.println(Thread.currentThread().getName() + " combine");
    }

    public List<Student> getList() {
        return list;
    }
}
